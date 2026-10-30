package com.assistencia.service;

import com.assistencia.entity.Garantia;
import com.assistencia.entity.OrdemDeServico;
import com.assistencia.persistencia.repository.impl.GarantiaRepositoryImpl;
import com.assistencia.persistencia.repository.impl.OrdemDeServicoRepositoryImpl;

public class GarantiaService {
    private final GarantiaRepositoryImpl garantiaRepository;
    private final OrdemDeServicoRepositoryImpl ordemDeServicoRepository;

    public GarantiaService(GarantiaRepositoryImpl garantiaRepository,
                           OrdemDeServicoRepositoryImpl ordemDeServicoRepository) {
        this.garantiaRepository = garantiaRepository;
        this.ordemDeServicoRepository = ordemDeServicoRepository;
    }

    public Garantia adicionaGarantia(Garantia garantia) {
        if (garantia == null) {
            throw new IllegalArgumentException("A garantia nao pode ser nula.");
        }
        if (garantia.getDiasDeGarantia() < 90) {
            throw new IllegalArgumentException("Os dias de garantia nao deve ser menor que 90.");
        }
         return garantiaRepository.criar(garantia);
    }
    public Garantia buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor que 1.");
        }
        Garantia garantia = garantiaRepository.buscar(id);
        if(garantia == null) {
            throw new RuntimeException("Garantia nao encontrada.");
        }

        return garantia;
    }
    public boolean removerGarantia(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser menor que 1.");
        }
        Garantia garantia = garantiaRepository.buscar(id);
        if(garantia == null) {
            throw new RuntimeException("Garantia nao encontrada.");
        }

        return garantiaRepository.deletar(id);
    }
}
