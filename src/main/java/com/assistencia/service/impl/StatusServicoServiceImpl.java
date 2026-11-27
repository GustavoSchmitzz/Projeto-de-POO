package com.assistencia.service.impl;

import com.assistencia.entity.StatusServico;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.persistencia.repository.StatusServicoRepository;
import com.assistencia.service.StatusServicoService;
import com.assistencia.service.dto.StatusServicoDto;

import java.util.List;

public class StatusServicoServiceImpl implements StatusServicoService {
    private final StatusServicoRepository statusServicoRepository = RepositoryAbstractFactory.criarStatusServicoRepository();

    public StatusServico buscaPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id nao pode ser igual ou menor que zero.");
        }
        return statusServicoRepository.buscarTodos().stream()
                .filter(s -> s.getId() != null && s.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Status nao encontrado no banco de dados."));
    }

    @Override
    public List<StatusServicoDto> listarTodos() {
        List<StatusServico> lista = statusServicoRepository.buscarTodos();

        List<StatusServicoDto> dtos = lista.stream().map(this::toDto).toList();

        return dtos;
    }

    private StatusServicoDto toDto(StatusServico statusServico) {
        StatusServicoDto dto = new StatusServicoDto();

        dto.setId(statusServico.getId() + "");
        dto.setStatus(statusServico.getStatus());

        return dto;
    }
}
