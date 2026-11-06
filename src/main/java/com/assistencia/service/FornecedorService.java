package com.assistencia.service;

import com.assistencia.entity.Fornecedor;

public interface FornecedorService {
    public Fornecedor cadastrar(Fornecedor fornecedor);
    public Fornecedor buscaPorId(int id);
    public boolean remover(int id);
    public boolean atualizar(Fornecedor fornecedor);
}
