package com.assistencia.service.impl;

import com.assistencia.entity.Cliente;
import com.assistencia.persistencia.repository.ClienteRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository = RepositoryAbstractFactory.criarClienteRepository();

    @Override
    public Cliente cadastrar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("cliente nao pode ser nulo.");
        }
        
        return clienteRepository.criar(cliente);
    }

    @Override
    public Cliente buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id nao pode ser menor ou igual a zero.");
        }
        Cliente cliente = clienteRepository.buscar(id);
        if (cliente == null) {
            throw new IllegalArgumentException("cliente nao encontrado.");
        }
        return cliente;
    }

    @Override
    public boolean remover(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id nao pode ser menor ou igual a zero.");
        }
        Cliente cliente = clienteRepository.buscar(id);
        if (cliente == null) {
            throw new IllegalArgumentException("cliente nao encontrado.");
        }
        return clienteRepository.deletar(id);
    }

    @Override
    public boolean atualizar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("cliente nao pode ser nulo.");
        }
        if (cliente.getId() == null) {
            throw new IllegalArgumentException("id nao pode ser nulo.");
        }
        if (clienteRepository.buscar(cliente.getId()) == null) {
            throw new IllegalArgumentException("O cliente nao existe no banco de dados.");
        }
        return clienteRepository.atualizar(cliente);
    }
}
