package com.assistencia.service;

import com.assistencia.entity.Cliente;
import com.assistencia.service.dto.ClienteDto;

public interface ClienteService {
    public Cliente cadastrar(ClienteDto cliente);
    public Cliente buscaPorId(int id);
    public boolean remover(int id);
    public boolean atualizar(ClienteDto cliente);
}

