package com.assistencia.entity;

import java.time.LocalDate;

public class OrdemDeServico {
    private int id;
    private LocalDate dataInicio;
    private double valorServico;
    private Tecnico tecnico;
    private PecaComDefeito peca;
    private StatusServico statusServico;
    private Garantia garantia;
    private FormaDePagamento  pagamento;

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
        this.dataInicio = dataInicio;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public PecaComDefeito getPeca() {
        return peca;
    }

    public void setPeca(PecaComDefeito peca) {
        this.peca = peca;
    }

    public StatusServico getStatusServico() {
        return statusServico;
    }

    public void setStatusServico(StatusServico statusServico) {
        this.statusServico = statusServico;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public FormaDePagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaDePagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    
}