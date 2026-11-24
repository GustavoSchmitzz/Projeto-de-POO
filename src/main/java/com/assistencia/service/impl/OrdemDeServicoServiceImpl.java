package com.assistencia.service.impl;

import com.assistencia.entity.*;
import com.assistencia.persistencia.repository.FornecedorRepository;
import com.assistencia.persistencia.repository.RepositoryAbstractFactory;
import com.assistencia.service.OrdemDeServicoService;
import com.assistencia.service.dto.OrdemDeServicoDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrdemDeServicoServiceImpl implements OrdemDeServicoService {
    private final FornecedorRepository fornecedorRepository = RepositoryAbstractFactory.criarFornecedorRepository();

    @Override
    public OrdemDeServico abrirOrdem(OrdemDeServicoDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("ordemDeServico nao pode ser nulo.");
        }
        if (dto.getDataInicio() == null || dto.getDataInicio().trim().isEmpty()) {
            throw new IllegalArgumentException("dataInicio nao pode ser nulo.");
        }
        if (dto.getValorServico() == null || dto.getValorServico().trim().isEmpty()) {
            throw new IllegalArgumentException("valorServico nao pode ser menor que zero.");
        }
        double valorServico = Double.parseDouble(dto.getValorServico().trim());
        if (valorServico < 0) {
            throw new IllegalArgumentException("valorServico nao pode ser menor que zero.");
        }
        if (BigDecimal.valueOf(valorServico).scale() > 2) {
            throw new IllegalArgumentException("O valor do servico nao deve ter mais de duas casas decimais.");
        }
        if (dto.getTecnico() == null || dto.getTecnico().trim().isEmpty()) {
            throw new IllegalArgumentException("Tecnico nao pode ser nulo.");
        }
        if (dto.getPeca() == null || dto.getPeca().trim().isEmpty()) {
            throw new IllegalArgumentException("Peca nao pode ser nulo.");
        }
        if (dto.getStatusServico() == null || dto.getStatusServico().trim().isEmpty())  {
            throw new IllegalArgumentException("StatusServico nao pode ser nulo.");
        }

        OrdemDeServico ordemDeServico = new OrdemDeServico();
        if (dto.getId() != null && !dto.getId().trim().isEmpty()) {
            ordemDeServico.setId(Integer.parseInt(dto.getId().trim()));
        }
        ordemDeServico.setDataInicio(LocalDate.parse(dto.getDataInicio().trim()));
        ordemDeServico.setValorServico(valorServico);

        Tecnico tecnico = new Tecnico();
        tecnico.setId(Integer.parseInt(dto.getTecnico().trim()));
        ordemDeServico.setTecnico(tecnico);

        PecaComDefeito peca = new PecaComDefeito();
        peca.setId(Integer.parseInt(dto.getPeca().trim()));
        ordemDeServico.setPeca(peca);

        StatusServico statusServico = new StatusServico();
        statusServico.setId(Integer.parseInt(dto.getStatusServico().trim()));
        ordemDeServico.setStatusServico(statusServico);

        if (dto.getGarantia() != null && !dto.getGarantia().trim().isEmpty()) {
            Garantia garantia = new Garantia();
            garantia.setId(Integer.parseInt(dto.getGarantia().trim()));
            ordemDeServico.setGarantia(garantia);
        }

        if (dto.getPagamento() != null && !dto.getPagamento().trim().isEmpty()) {
            FormaDePagamento pagamento = new FormaDePagamento();
            pagamento.setId(Integer.parseInt(dto.getPagamento().trim()));
            ordemDeServico.setPagamento(pagamento);
        }

        if (dto.getOrdemPeca() != null && !dto.getOrdemPeca().trim().isEmpty()) {
            OrdemPeca ordemPeca = new OrdemPeca();
            ordemPeca.setId(Integer.parseInt(dto.getOrdemPeca().trim()));
            ordemDeServico.setOrdemPeca(ordemPeca);
        }

        return ordemDeServico;
    }

}
