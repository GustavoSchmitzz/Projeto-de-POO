package com.assistencia.service.impl;

import com.assistencia.entity.Garantia;
import com.assistencia.persistencia.repository.GarantiaRepository;
import com.assistencia.persistencia.repository.OrdemDeServicoRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.GarantiaService;
import com.assistencia.service.dto.GarantiaDto;

public class GarantiaServiceImpl implements GarantiaService {
    private final GarantiaRepository garantiaRepository = RepositoryAbstractFactory.criarGarantiaRepository();
    private final OrdemDeServicoRepository ordemDeServicoRepository = RepositoryAbstractFactory.criarOrdemDeServicoRepository();

    @Override
    public Garantia adicionaGarantia(GarantiaDto dto) {
        validar(dto);
        int dias = Integer.parseInt(dto.getDiasDeGarantia().trim());

        Garantia garantia = new Garantia();
        if (dto.getId() != null && !dto.getId().trim().isEmpty()) {
            garantia.setId(Integer.parseInt(dto.getId().trim()));
        }
        garantia.setDiasDeGarantia(dias);
        return garantia;
    }

    @Override
    public Garantia buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor que 1.");
        }
        return garantiaRepository.buscarTodos().stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Garantia nao encontrada."));
    }

    @Override
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
    
    private void validar(GarantiaDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("A garantia nao pode ser nula.");
        }
        if (dto.getDiasDeGarantia() == null || dto.getDiasDeGarantia().trim().isEmpty()) {
            throw new IllegalArgumentException("Os dias de garantia nao deve ser menor que 90.");
        }
        int dias = Integer.parseInt(dto.getDiasDeGarantia().trim());
        if (dias < 90) {
            throw new IllegalArgumentException("Os dias de garantia nao deve ser menor que 90.");
        }
    }
}

