package com.assistencia.service;

import com.assistencia.entity.Fornecedor;
import com.assistencia.service.dto.FornecedorDto;

public interface FornecedorService extends Service{
    public Fornecedor cadastrar(FornecedorDto fornecedor);
    public Fornecedor buscaPorId(int id);
    public boolean remover(int id);
    public boolean atualizar(FornecedorDto fornecedor);
}

