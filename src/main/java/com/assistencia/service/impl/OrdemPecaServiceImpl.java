package com.assistencia.service.impl;

import com.assistencia.entity.OrdemPeca;
import com.assistencia.persistencia.repository.OrdemPecaRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.OrdemPecaService;

public class OrdemPecaServiceImpl implements OrdemPecaService {
    private final OrdemPecaRepository ordemPecaRepository = RepositoryAbstractFactory.criarOrdemPecaRepository();

    public OrdemPeca abreOrdemPeca(OrdemPeca ordemPeca) {
        if (ordemPeca == null) {
            throw new IllegalArgumentException("ordemPeca nao pode ser nulo.");
        }
        if (ordemPeca.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Quantidade nao pode ser menor ou igual a zero.");
        }
        if (ordemPeca.getOrdemDeServico() == null) {
            throw new IllegalArgumentException("OrdemDeServico nao pode ser nulo.");
        }
        if (ordemPeca.getPeca().getId() == null) {
            throw new IllegalArgumentException("Peca nao pode ser nulo.");
        }

         return ordemPecaRepository.criar(ordemPeca);
    }
}
