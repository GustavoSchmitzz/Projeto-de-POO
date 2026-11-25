package com.assistencia.service;

import com.assistencia.entity.FormaDePagamento;

public interface FormaDePagamentoService extends Service{
    public FormaDePagamento buscaPorId(int id);
}
