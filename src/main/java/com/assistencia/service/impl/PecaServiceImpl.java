package com.assistencia.service.impl;

import com.assistencia.entity.Peca;
import com.assistencia.persistencia.repository.PecaRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.PecaService;
import com.assistencia.service.dto.PecaDto;

import java.util.List;

public class PecaServiceImpl implements PecaService {
    private final PecaRepository pecaRepository = RepositoryAbstractFactory.criarPecaRepository();

    public Peca buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser igual ou menor que zero");
        }
        Peca peca = pecaRepository.buscar(id);
        if (peca == null) {
            throw new IllegalArgumentException("Peca nao encontrada");
        }
        return peca;
    }
    public boolean deletarPeca(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser igual ou menor que zero");
        }
        Peca peca = pecaRepository.buscar(id);
        if (peca.getEstoque() > 0) {
            throw new IllegalArgumentException("Nao é possivel deletar uma peça que tem no estoque");
        }
        if (peca == null) {
            throw new IllegalArgumentException("Peca nao encontrada");
        }
        return pecaRepository.deletar(id);
    }
    public boolean adicionarAoEstoque(int id, int quant) {
        if (id <= 0 || quant <= 0) {
            throw new IllegalArgumentException("Id e quantidade nao pode ser igual ou menor que zero");
        }
        Peca peca = pecaRepository.buscar(id);
        if (peca == null) {
            throw new IllegalArgumentException("Peca nao encontrada");
        }
        peca.setEstoque(peca.getEstoque() + quant);

        return pecaRepository.atualizar(peca);
    }

    @Override
    public List<PecaDto> listarTodos() {
        List<Peca> lista = pecaRepository.buscarTodos();

        List<PecaDto> dtos = lista.stream().map(this::toDto).toList();

        return dtos;
    }

    private PecaDto toDto(Peca peca) {
        PecaDto dto = new PecaDto();

        dto.setId(peca.getId() + "");
        dto.setNome(peca.getNome());
        dto.setValor(peca.getValor() + "");
        dto.setEstoque(peca.getEstoque() + "");
        dto.setFornecedor(peca.getFornecedor().getId() + "");

        return dto;
    }
}
