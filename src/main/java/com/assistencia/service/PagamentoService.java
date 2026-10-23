package com.assistencia.service;

import com.assistencia.entity.FormaDePagamento;
import com.assistencia.repository.FormaDePagamentoRepository;

public class PagamentoService {
    private final FormaDePagamentoRepository pagamentoRepository;
    public PagamentoService(FormaDePagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public FormaDePagamento buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor ou igual a zero.");
        }
        FormaDePagamento pagamento = pagamentoRepository.buscaOID(id);
        if (pagamento == null) {
            throw new RuntimeException("forma de pagamento nao encontrada.");
        }
        return pagamento;
    }
}
