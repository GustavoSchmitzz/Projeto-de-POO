package com.assistencia.service;

import com.assistencia.entity.StatusServico;

public interface StatusServicoService extends Service{
    public StatusServico buscaPorId(int id);
}
