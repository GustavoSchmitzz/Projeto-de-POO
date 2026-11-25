package com.assistencia.service;

import com.assistencia.entity.OrdemDeServico;
import com.assistencia.service.dto.OrdemDeServicoDto;

public interface OrdemDeServicoService extends Service{
    public OrdemDeServico abrirOrdem(OrdemDeServicoDto ordemDeServico);
}

