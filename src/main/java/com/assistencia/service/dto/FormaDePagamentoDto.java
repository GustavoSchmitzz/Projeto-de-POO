package com.assistencia.service.dto;

public class FormaDePagamentoDto {
    private String id;
    private String formaPagamento;

    public String getId() {
        return id; 
    }
    
    public void setId(String id) { 
        this.id = id; 
    }
    
    public String getFormaPagamento() {
        return formaPagamento;
    }
    
    public void setFormaPagamento(String formaPagamento) { 
        this.formaPagamento = formaPagamento; 
    }
}
