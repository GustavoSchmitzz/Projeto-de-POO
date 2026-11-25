package com.assistencia.service;

import com.assistencia.entity.EntregaOrdemDeServico;

public interface EntregaOrdemDeServicoService extends Service{
    public EntregaOrdemDeServico entregaAOrdemDeServico(int idOS);
    public boolean reverteAEntrega(int idEntrega);
}
