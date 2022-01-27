package com.spring_full_api.spring_api.Service;

import java.util.Date;
import java.util.Optional;

import com.spring_full_api.spring_api.Domain.ItemPedido;
import com.spring_full_api.spring_api.Domain.PagamentoComBoleto;
import com.spring_full_api.spring_api.Domain.Pedido;
import com.spring_full_api.spring_api.Domain.enums.EstadoPagamento;
import com.spring_full_api.spring_api.Service.exceptions.ObjectNotFoundException;
import com.spring_full_api.spring_api.repository.ItemPedidoRepository;
import com.spring_full_api.spring_api.repository.PagamentoRepository;
import com.spring_full_api.spring_api.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado, Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            BoletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }

        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setPreco(produtoService.buscar(ip.getProduto().getId()).getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        return obj;
    }
}