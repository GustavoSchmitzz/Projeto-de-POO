package com.assistencia.service;

import com.assistencia.entity.Fornecedor;
import com.assistencia.persistencia.repository.impl.FornecedorRepositoryImpl;

public class FornecedorService {
    private FornecedorRepositoryImpl fornecedorRepository;
    public FornecedorService(FornecedorRepositoryImpl fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor cadastrar(Fornecedor fornecedor) {
        if (fornecedor == null) {
            throw new IllegalArgumentException("cliente nao pode ser nulo.");
        }
        if(fornecedor.getNome() == null || fornecedor.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("nome nao pode ser nulo, vazio ou ter mais de 100 caracteres.");
        }
        if(fornecedor.getTelefone() == null ||
                !fornecedor.getTelefone().trim().matches("^[0-9]{10,11}$")) {
            throw new IllegalArgumentException("telefone nao pode ser nulo, vazio ou ter mais de 11 caracteres.");
        }

        fornecedor.setNome(fornecedor.getNome().trim().toLowerCase());
        fornecedor.setTelefone(fornecedor.getTelefone().trim().toLowerCase());

        return fornecedorRepository.criar(fornecedor);
    }
    public Fornecedor buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id nao pode ser menor ou igual a zero.");
        }
        Fornecedor fornecedor = fornecedorRepository.buscar(id);
        if (fornecedor == null) {
            throw new IllegalArgumentException("cliente nao encontrado.");
        }
        return fornecedor;
    }
    public boolean remover(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id nao pode ser menor ou igual a zero.");
        }
        Fornecedor fornecedor = fornecedorRepository.buscar(id);
        if (fornecedor == null) {
            throw new IllegalArgumentException("cliente nao encontrado.");
        }
        return fornecedorRepository.deletar(id);
    }
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
        if(fornecedor.getNome() == null || fornecedor.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("nome nao pode ser nulo.");
        }
        if(fornecedor.getTelefone() == null || fornecedor.getTelefone().trim().matches("^[0-9]{10,11}$")) {
            throw new IllegalArgumentException("telefone nao pode ser nulo.");
        }

        fornecedor.setNome(fornecedor.getNome().trim().toLowerCase());
        fornecedor.setTelefone(fornecedor.getTelefone().trim());

        return fornecedorRepository.atualizar(fornecedor);
    }
}


