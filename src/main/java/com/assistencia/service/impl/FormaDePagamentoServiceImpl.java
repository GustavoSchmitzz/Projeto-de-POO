package com.assistencia.service.impl;

import com.assistencia.entity.FormaDePagamento;
import com.assistencia.persistencia.repository.FormaDePagamentoRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.FormaDePagamentoService;
import com.assistencia.service.dto.FormaDePagamentoDto;

import java.util.List;

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

    @Override
    public List<FormaDePagamentoDto> listarTodos() {
        List<FormaDePagamento> lista = pagamentoRepository.buscarTodos();

        List<FormaDePagamentoDto> dtos = lista.stream().map(this::toDto).toList();

        return dtos;
    }

    private FormaDePagamentoDto toDto(FormaDePagamento formaDePagamento) {
        FormaDePagamentoDto dto = new FormaDePagamentoDto();

        dto.setId(formaDePagamento.getId() + "");
        dto.setFormaPagamento(formaDePagamento.getFormaPagamento());

        return dto;
    }
}
