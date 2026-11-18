package com.assistencia.service.dto;

public class EntregaOrdemDeServicoDto {
    private String id;
    private String dataEntrega;
    private String ordemDeServico;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(String ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }
}
