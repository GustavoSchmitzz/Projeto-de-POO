package com.assistencia.service.impl;

import com.assistencia.entity.FormaDePagamento;
import com.assistencia.persistencia.repository.impl.FormaDePagamentoRepositoryImpl;
import com.assistencia.service.FormaDePagamentoService;

public class FormaDePagamentoServiceImpl implements FormaDePagamentoService {
    private final FormaDePagamentoRepositoryImpl pagamentoRepository;
    public FormaDePagamentoServiceImpl(FormaDePagamentoRepositoryImpl pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public FormaDePagamento buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor ou igual a zero.");
        }
        FormaDePagamento pagamento = pagamentoRepository.buscar(id);
        if (pagamento == null) {
            throw new RuntimeException("forma de pagamento nao encontrada.");
        }
        return pagamento;
    }
}
