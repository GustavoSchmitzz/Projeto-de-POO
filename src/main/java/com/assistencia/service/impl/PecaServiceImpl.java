package com.assistencia.service.impl;

import com.assistencia.entity.Peca;
import com.assistencia.persistencia.repository.impl.PecaRepositoryImpl;
import com.assistencia.service.PecaService;

public class PecaServiceImpl implements PecaService {
    private PecaRepositoryImpl pecaRepository;
    public PecaServiceImpl(PecaRepositoryImpl pecaRepository) {
        this.pecaRepository = pecaRepository;
    }

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
}
