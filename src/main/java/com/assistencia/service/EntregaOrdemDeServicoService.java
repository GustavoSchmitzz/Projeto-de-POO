package com.assistencia.service;

import com.assistencia.entity.EntregaOrdemDeServico;

public interface EntregaOrdemDeServicoService {
    public EntregaOrdemDeServico entregaAOrdemDeServico(int idOS);
    public boolean reverteAEntrega(int idEntrega);
}
