package com.assistencia.entity;

import java.math.BigDecimal;
import java.time.LocalDate;


public class OrdemDeServico {
    private int id;
    private LocalDate dataInicio;
    private double valorServico;
    private Tecnico tecnico;
    private PecaComDefeito peca;
    private OrdemPeca ordemPeca;
    private StatusServico statusServico;
    private Garantia garantia;
    private FormaDePagamento pagamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        if (dataInicio == null) {
            throw new IllegalArgumentException("dataInicio nao pode ser nulo.");
        }
        this.dataInicio = dataInicio;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        if (valorServico < 0) {
            throw new IllegalArgumentException("valorServico nao pode ser menor que zero.");
        }
        if (BigDecimal.valueOf(valorServico).scale() > 2) {
            throw new IllegalArgumentException("O valor do servico nao deve ter mais de duas casas decimais.");
        }
        this.valorServico = valorServico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        if (tecnico == null) {
            throw new IllegalArgumentException("tecnico nao pode ser nulo.");
        }
        this.tecnico = tecnico;
    }

    public PecaComDefeito getPeca() {
        return peca;
    }

    public void setPeca(PecaComDefeito peca) {
        if (peca == null) {
            throw new IllegalArgumentException("peca nao pode ser nula.");
        }
        this.peca = peca;
    }

    public StatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(StatusServico statusServico) {
        if (statusServico == null) {
            throw new IllegalArgumentException("statusServico nao pode ser nulo.");
        }
        this.statusServico = statusServico;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        if (garantia == null) {
            throw new IllegalArgumentException("garantia nao pode ser nula.");
        }
        this.garantia = garantia;
    }

    public FormaDePagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaDePagamento pagamento) {
        if (pagamento == null) {
            throw new IllegalArgumentException("pagamento nao pode ser nulo.");
        }
        this.pagamento = pagamento;
    }

    public OrdemPeca getOrdemPeca() {
        return ordemPeca;
    }

    public void setOrdemPeca(OrdemPeca ordemPeca) {
        this.ordemPeca = ordemPeca;
    }
}