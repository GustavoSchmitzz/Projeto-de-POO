package com.assistencia.service.impl;

import com.assistencia.entity.Garantia;
import com.assistencia.persistencia.repository.GarantiaRepository;
import com.assistencia.persistencia.repository.OrdemDeServicoRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.GarantiaService;

public class GarantiaServiceImpl implements GarantiaService {
    private final GarantiaRepository garantiaRepository = RepositoryAbstractFactory.criarGarantiaRepository();
    private final OrdemDeServicoRepository ordemDeServicoRepository = RepositoryAbstractFactory.criarOrdemDeServicoRepository();

    public Garantia adicionaGarantia(Garantia garantia) {
        if (garantia == null) {
            throw new IllegalArgumentException("A garantia nao pode ser nula.");
        }
        if (garantia.getDiasDeGarantia() < 90) {
            throw new IllegalArgumentException("Os dias de garantia nao deve ser menor que 90.");
        }
        return garantia;
    }
    public Garantia buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor que 1.");
        }
        return garantiaRepository.buscarTodos().stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Garantia nao encontrada."));
    }
    public boolean removerGarantia(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor que 1.");
        }
        Garantia garantia = buscaPorId(id);
        if(garantia == null) {
            throw new RuntimeException("Garantia nao encontrada.");
        }

        return true;
    }
}
