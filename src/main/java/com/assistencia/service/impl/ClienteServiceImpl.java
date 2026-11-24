package com.assistencia.service.impl;

import com.assistencia.entity.Cliente;
import com.assistencia.persistencia.repository.ClienteRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.ClienteService;
import com.assistencia.service.dto.ClienteDto;

public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository = RepositoryAbstractFactory.criarClienteRepository();

    @Override
    public Cliente cadastrar(ClienteDto dto) {
        validar(dto);

        Cliente cliente = new Cliente();
        if (dto.getId() != null && !dto.getId().trim().isEmpty()) {
            cliente.setId(Integer.parseInt(dto.getId().trim()));
        }
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        
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
        
        Cliente cliente = clienteRepository.buscar(id);
        if (cliente == null) {
            throw new IllegalArgumentException("cliente nao encontrado.");
        }
        return clienteRepository.deletar(id);
    }

    @Override
    public boolean atualizar(ClienteDto dto) {
        validar(dto);
        if (dto.getId() == null || dto.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("id nao pode ser nulo.");
        }
        int id = Integer.parseInt(dto.getId().trim());
        if (clienteRepository.buscar(id) == null) {
            throw new IllegalArgumentException("O cliente nao existe no banco de dados.");
        }

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());

        return clienteRepository.atualizar(cliente);
    }

    private void validar(ClienteDto dto) {
        
        if (dto == null) {
            throw new IllegalArgumentException("cliente nao pode ser nulo.");
        }
    }
}
