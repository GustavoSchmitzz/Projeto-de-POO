package com.assistencia.service.impl;

import com.assistencia.entity.StatusServico;
import com.assistencia.persistencia.repository.impl.StatusServicoRepositoryImpl;
import com.assistencia.service.StatusServicoService;

public class StatusServicoServiceImpl implements StatusServicoService {
    private final StatusServicoRepositoryImpl statusServicoRepository;
    public StatusServicoServiceImpl(StatusServicoRepositoryImpl statusServicoRepository) {
        this.statusServicoRepository = statusServicoRepository;
    }

    public StatusServico buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser igual ou menor que zero.");
        }
        StatusServico status = statusServicoRepository.buscar(id);
        if (status == null) {
            throw new RuntimeException("Status nao encontrado no banco de dados.");
        }

        return status;
    }
}
