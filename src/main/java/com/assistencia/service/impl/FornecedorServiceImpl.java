package com.assistencia.service.impl;

import com.assistencia.entity.Fornecedor;
import com.assistencia.persistencia.repository.FornecedorRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.FornecedorService;

public class FornecedorServiceImpl implements FornecedorService {
    private final FornecedorRepository fornecedorRepository = RepositoryAbstractFactory.criarFornecedorRepository();

    @Override
    public Fornecedor cadastrar(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new IllegalArgumentException("fornecedor nao pode ser nulo.");
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
    public boolean atualizar(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new IllegalArgumentException("fornecedor nao pode ser nulo.");
        }
        if (fornecedor.getId() == null) {
            throw new IllegalArgumentException("id nao pode ser nulo.");
        }
        if (fornecedorRepository.buscar(fornecedor.getId()) == null) {
            throw new IllegalArgumentException("O fornecedor nao existe no banco de dados.");
        }
        
        return fornecedorRepository.atualizar(fornecedor);
    }
}
