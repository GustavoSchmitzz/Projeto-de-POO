package com.assistencia.service.dto;

public class OrdemPecaDto {
    private String id;
    private String quantidade;
    private String ordemDeServico;
    private String peca;

    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id; 
    }
    
    public String getQuantidade() {
        return quantidade; 
    }
    
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    
    public String getOrdemDeServico() {
        return ordemDeServico; 
    }
    
    public void setOrdemDeServico(String ordemDeServico) {
        this.ordemDeServico = ordemDeServico; 
    }
    
    public String getPeca() {
        return peca; 
    }
    public void setPeca(String peca) {
        this.peca = peca; 
    }
}
