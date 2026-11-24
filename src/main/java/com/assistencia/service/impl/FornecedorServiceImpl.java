package com.assistencia.service.impl;

import com.assistencia.entity.Fornecedor;
import com.assistencia.persistencia.repository.FornecedorRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.FornecedorService;
import com.assistencia.service.dto.FornecedorDto;

public class FornecedorServiceImpl implements FornecedorService {
    private final FornecedorRepository fornecedorRepository = RepositoryAbstractFactory.criarFornecedorRepository();

    @Override
    public Fornecedor cadastrar(FornecedorDto dto) {
        validar(dto);

        Fornecedor fornecedor = new Fornecedor();
        if (dto.getId() != null && !dto.getId().trim().isEmpty()) {
            fornecedor.setId(Integer.parseInt(dto.getId().trim()));
        }
        fornecedor.setNome(dto.getNome());
        fornecedor.setTelefone(dto.getTelefone());
        if (dto.getEmail() != null && !dto.getEmail().trim().isEmpty()) {
            fornecedor.setEmail(dto.getEmail());
        }

        return fornecedorRepository.criar(fornecedor);
    }

    @Override
    public Fornecedor buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id nao pode ser menor ou igual a zero.");
        }
        Fornecedor fornecedor = fornecedorRepository.buscar(id);
        if (fornecedor == null) {
            throw new IllegalArgumentException("fornecedor nao encontrado.");
        }
        return fornecedor;
    }

    @Override
    public boolean remover(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id nao pode ser menor ou igual a zero.");
        }
        Fornecedor fornecedor = fornecedorRepository.buscar(id);
        if (fornecedor == null) {
            throw new IllegalArgumentException("fornecedor nao encontrado.");
        }
        return fornecedorRepository.deletar(id);
    }

    @Override
    public boolean atualizar(FornecedorDto dto) {
        validar(dto);
        if (dto.getId() == null || dto.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("id nao pode ser nulo.");
        }
        int id = Integer.parseInt(dto.getId().trim());
        if (fornecedorRepository.buscar(id) == null) {
            throw new IllegalArgumentException("O fornecedor nao existe no banco de dados.");
        }

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        fornecedor.setNome(dto.getNome());
        fornecedor.setTelefone(dto.getTelefone());
        if (dto.getEmail() != null && !dto.getEmail().trim().isEmpty()) {
            fornecedor.setEmail(dto.getEmail());
        }
        
        return fornecedorRepository.atualizar(fornecedor);
    }

    private void validar(FornecedorDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("fornecedor nao pode ser nulo.");
        }
    }
}
