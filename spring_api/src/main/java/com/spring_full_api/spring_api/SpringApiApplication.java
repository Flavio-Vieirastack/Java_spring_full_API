package com.spring_full_api.spring_api;

import java.util.Arrays;

import com.spring_full_api.spring_api.Domain.Categoria;
import com.spring_full_api.spring_api.Domain.Cidade;
import com.spring_full_api.spring_api.Domain.Cliente;
import com.spring_full_api.spring_api.Domain.Endereco;
import com.spring_full_api.spring_api.Domain.Estado;
import com.spring_full_api.spring_api.Domain.Produto;
import com.spring_full_api.spring_api.Domain.enums.TipoCliente;
import com.spring_full_api.spring_api.repository.CategoriaRepository;
import com.spring_full_api.spring_api.repository.CidadeRepository;
import com.spring_full_api.spring_api.repository.ClienteRepository;
import com.spring_full_api.spring_api.repository.EnderecoRepository;
import com.spring_full_api.spring_api.repository.EstadoRepository;
import com.spring_full_api.spring_api.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 800.00);
		Produto p3 = new Produto(null, "mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas gerais");
		Estado est2 = new Estado(null, "São paulo");
	
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
	
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "maria silva", "maria@gmail.com", "635210148", TipoCliente.PESSOA_FISICA);

		cli1.getTelefones().addAll( Arrays.asList("99885522", "9988447722"));

		Endereco e1 = new Endereco(null, "Rua flores", "300", "apto 03", "jardim", "3025417", cli1, c1);

		Endereco e2 = new Endereco(null, "Avenida matos", "105", "sala 800", "centro", "3025417", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
