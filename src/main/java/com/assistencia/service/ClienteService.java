package com.assistencia.service;

import com.assistencia.entity.Cliente;

public interface ClienteService {
    public Cliente cadastrar(Cliente cliente);
    public Cliente buscaPorId(int id);
    public boolean remover(int id);
    public boolean atualizar(Cliente cliente);
}
