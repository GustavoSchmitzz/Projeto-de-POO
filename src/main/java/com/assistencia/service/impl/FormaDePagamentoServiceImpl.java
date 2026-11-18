package com.assistencia.service.impl;

import com.assistencia.entity.FormaDePagamento;
import com.assistencia.persistencia.repository.FormaDePagamentoRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.FormaDePagamentoService;

public class FormaDePagamentoServiceImpl implements FormaDePagamentoService {
    private final FormaDePagamentoRepository pagamentoRepository = RepositoryAbstractFactory.criarFormaDePagamentoRepository();

    public FormaDePagamento buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor ou igual a zero.");
        }
        return pagamentoRepository.buscarTodos().stream()
                .filter(p -> p.getId() != null && p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("forma de pagamento nao encontrada."));
    }
}
