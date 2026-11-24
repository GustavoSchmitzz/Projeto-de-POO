package com.assistencia.service.impl;

import com.assistencia.entity.Cliente;
import com.assistencia.entity.PecaComDefeito;
import com.assistencia.persistencia.repository.PecaComDefeitoRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.PecaComDefeitoService;
import com.assistencia.service.dto.PecaComDefeitoDto;

public class PecaComDefeitoServiceImpl implements PecaComDefeitoService {

    private final PecaComDefeitoRepository pecaComDefeitoRepository = RepositoryAbstractFactory.criarPecaComDefeitoRepository();

    @Override
    public PecaComDefeito buscaPorID(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("O Id nao pode ser menor ou igual a zero.");
        }
        PecaComDefeito pecaComDefeito = pecaComDefeitoRepository.buscar(id);
        if (pecaComDefeito == null) {
            throw new IllegalArgumentException("Peca com defeito nao encontrada no banco de dados.");
        }
        return pecaComDefeito;
    }

    @Override
    public PecaComDefeito adicionaPeca(PecaComDefeitoDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Peca com defeito nao pode ser nulo.");
        }
        if (dto.getTipoPeca() == null || dto.getTipoPeca().trim().isEmpty()) {
            throw new IllegalArgumentException("O Tipo de Peca nao pode ser nulo ou vazio.");
        }
        if (dto.getMarca() == null || dto.getMarca().trim().isEmpty()) {
            throw new IllegalArgumentException("A marca nao pode ser nulo ou vazio.");
        }
        if (dto.getDescricao() == null || dto.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A Descricao nao pode ser nula ou vazia.");
        }
        if (dto.getModelo() == null ||  dto.getModelo().trim().isEmpty()) {
            throw new IllegalArgumentException("O modelo nao pode ser nula ou vazia.");
        }
        if (dto.getCliente() == null || dto.getCliente().trim().isEmpty() || Integer.parseInt(dto.getCliente().trim()) <= 0) {
            throw new IllegalArgumentException("O Id nao pode ser nulo ou menor que 1.");
        }

        PecaComDefeito pecaComDefeito = new PecaComDefeito();
        if (dto.getId() != null && !dto.getId().trim().isEmpty()) {
            pecaComDefeito.setId(Integer.parseInt(dto.getId().trim()));
        }
        pecaComDefeito.setTipoPeca(dto.getTipoPeca().trim().toLowerCase());
        pecaComDefeito.setMarca(dto.getMarca().trim().toLowerCase());
        pecaComDefeito.setModelo(dto.getModelo().trim().toLowerCase());
        pecaComDefeito.setDescricao(dto.getDescricao().trim().toLowerCase());

        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(dto.getCliente().trim()));
        pecaComDefeito.setCliente(cliente);

        return pecaComDefeitoRepository.criar(pecaComDefeito);
    }

    @Override
    public boolean atualizaPecaComDefeito(PecaComDefeitoDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Peca com defeito nao pode ser nulo.");
        }
        if (dto.getId() == null || dto.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("O Id nao pode ser nulo.");
        }
        int id = Integer.parseInt(dto.getId().trim());
        if (pecaComDefeitoRepository.buscar(id) == null) {
            throw new RuntimeException("O produto com defeito nao existe no banco de dados.");
        }
        if (dto.getTipoPeca() == null || dto.getTipoPeca().trim().isEmpty()) {
            throw new IllegalArgumentException("O Tipo de Peca nao pode ser nulo ou vazio.");
        }
        if (dto.getModelo() == null || dto.getModelo().trim().isEmpty()) {
            throw new IllegalArgumentException("O Modelo nao pode ser nulo ou vazio.");
        }
        if (dto.getMarca() == null || dto.getMarca().trim().isEmpty()) {
            throw new IllegalArgumentException("A marca nao pode ser nula ou vazia.");
        }
        if (dto.getDescricao() == null ||  dto.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A Descricao nao pode ser nula ou vazia.");
        }
        if (dto.getCliente() == null || dto.getCliente().trim().isEmpty() || Integer.parseInt(dto.getCliente().trim()) <= 0) {
            throw new IllegalArgumentException("O Id nao pode ser nulo ou menor que 1.");
        }

        PecaComDefeito pecaComDefeito = new PecaComDefeito();
        pecaComDefeito.setId(id);
        pecaComDefeito.setTipoPeca(dto.getTipoPeca().trim().toLowerCase());
        pecaComDefeito.setMarca(dto.getMarca().trim().toLowerCase());
        pecaComDefeito.setModelo(dto.getModelo().trim().toLowerCase());
        pecaComDefeito.setDescricao(dto.getDescricao().trim().toLowerCase());

        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(dto.getCliente().trim()));
        pecaComDefeito.setCliente(cliente);

        return pecaComDefeitoRepository.atualizar(pecaComDefeito);
    }
}
