package com.spring_full_api.spring_api.Service;

import java.util.Calendar;
import java.util.Date;

import com.spring_full_api.spring_api.Domain.PagamentoComBoleto;

import org.springframework.stereotype.Service;

@Service
public class BoletoService {
    public static void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instante){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(instante);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        pagto.setDataPagamento(calendar.getTime());
    }
}