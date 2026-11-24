package com.assistencia.service.impl;

import com.assistencia.entity.OrdemDeServico;
import com.assistencia.entity.OrdemPeca;
import com.assistencia.entity.Peca;
import com.assistencia.persistencia.repository.OrdemPecaRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.OrdemPecaService;
import com.assistencia.service.dto.OrdemPecaDto;

public class OrdemPecaServiceImpl implements OrdemPecaService {
    private final OrdemPecaRepository ordemPecaRepository = RepositoryAbstractFactory.criarOrdemPecaRepository();

    @Override
    public OrdemPeca abreOrdemPeca(OrdemPecaDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("ordemPeca nao pode ser nulo.");
        }
        if (dto.getQuantidade() == null || dto.getQuantidade().trim().isEmpty()) {
            throw new IllegalArgumentException("Quantidade nao pode ser menor ou igual a zero.");
        }
        int quantidade = Integer.parseInt(dto.getQuantidade().trim());
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade nao pode ser menor ou igual a zero.");
        }
        if (dto.getOrdemDeServico() == null || dto.getOrdemDeServico().trim().isEmpty()) {
            throw new IllegalArgumentException("OrdemDeServico nao pode ser nulo.");
        }
        if (dto.getPeca() == null || dto.getPeca().trim().isEmpty()) {
            throw new IllegalArgumentException("Peca nao pode ser nulo.");
        }

        OrdemPeca ordemPeca = new OrdemPeca();
        if (dto.getId() != null && !dto.getId().trim().isEmpty()) {
            ordemPeca.setId(Integer.parseInt(dto.getId().trim()));
        }
        ordemPeca.setQuantidade(quantidade);

        OrdemDeServico os = new OrdemDeServico();
        os.setId(Integer.parseInt(dto.getOrdemDeServico().trim()));
        ordemPeca.setOrdemDeServico(os);

        Peca peca = new Peca();
        peca.setId(Integer.parseInt(dto.getPeca().trim()));
        ordemPeca.setPeca(peca);

        return ordemPecaRepository.criar(ordemPeca);
    }
}

