package com.assistencia.service.impl;

import com.assistencia.entity.EntregaOrdemDeServico;
import com.assistencia.entity.OrdemDeServico;
import com.assistencia.persistencia.repository.EntregaOrdemDeServicoRepository;
import com.assistencia.persistencia.repository.OrdemDeServicoRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.EntregaOrdemDeServicoService;
import com.assistencia.service.dto.EntregaOrdemDeServicoDto;

import java.time.LocalDate;
import java.util.List;

public class EntregaOrdemDeServicoServiceImpl implements EntregaOrdemDeServicoService {
    private final OrdemDeServicoRepository ordemDeServicoRepository = RepositoryAbstractFactory.criarOrdemDeServicoRepository();
    private final EntregaOrdemDeServicoRepository entregaServicoRepository = RepositoryAbstractFactory.criarEntregaOrdemDeServicoRepository();

    /* Status OS
     *
     * id = 1 significa em espera
     * id = 2 significs em andamento
     * id = 3 significa pronto para entrega
     * id = 4 significa entrega concluída
     */
    public EntregaOrdemDeServico entregaAOrdemDeServico(int idOS) {
        if (idOS <= 0) {
            throw new IllegalArgumentException("O id Da ordem de serviço nao pode ser negativo.");
        }
        OrdemDeServico os = ordemDeServicoRepository.buscar(idOS);
        if (os == null) {
            throw new RuntimeException("Ordem de servico nao existente.");
        }
        if (os.getStatusServico().getId() == 4) {
            throw new IllegalStateException("A ordem de servico ja foi entrege.");
        }
        if (os.getStatusServico().getId() != 3) {
            throw new IllegalStateException("A ordem de serviço nao esta pronta para entrega.");
        }
        os.getStatusServico().setId(4);

        boolean atualizou = ordemDeServicoRepository.atualizar(os);
        if (!atualizou) {
            throw new RuntimeException("Nao foi possivel atualizar a ordem de servico.");
        }

        EntregaOrdemDeServico entregaServico = new EntregaOrdemDeServico();
        entregaServico.setDataEntrega(LocalDate.now());
        entregaServico.setOrdemDeServico(os);

        return entregaServicoRepository.criar(entregaServico);
    }
    public boolean reverteAEntrega(int idEntrega) {
        if (idEntrega <= 0) {
            throw new IllegalArgumentException("O id nao pode ser negativo.");
        }
        EntregaOrdemDeServico entrega = entregaServicoRepository.buscar(idEntrega);
        if (entrega == null) {
            throw new IllegalArgumentException("O registro de entrega não foi encontrado.");
        }

        int idOS = entrega.getOrdemDeServico().getId();
        OrdemDeServico os = ordemDeServicoRepository.buscar(idOS);

        if (os == null) {
            throw new RuntimeException("Ordem de servico nao existente.");
        }
        if (os.getStatusServico().getId() != 4) {
            throw new IllegalStateException("A ordem de serviço nao esta entregue.");
        }

        os.getStatusServico().setId(3);

        boolean atualizou = ordemDeServicoRepository.atualizar(os);
        if (!atualizou) {
            throw new RuntimeException("Nao foi possivel reverter a ordem de servico.");
        }

        return entregaServicoRepository.deletar(idEntrega);
    }

    @Override
    public List<EntregaOrdemDeServicoDto> listarTodos() {
        List<EntregaOrdemDeServico> lista = entregaServicoRepository.buscarTodos();

        List<EntregaOrdemDeServicoDto> dtos = lista.stream().map(this::toDto).toList();

        return dtos;
    }

    private EntregaOrdemDeServicoDto toDto(EntregaOrdemDeServico entrega) {
        EntregaOrdemDeServicoDto dto = new EntregaOrdemDeServicoDto();

        dto.setId(entrega.getId() + "");
        dto.setDataEntrega(entrega.getDataEntrega().toString());
        dto.setOrdemDeServico(entrega.getOrdemDeServico().getId() + "");

        return dto;
    }
}
