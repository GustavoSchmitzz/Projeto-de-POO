package com.assistencia.service;

import com.assistencia.entity.Garantia;
import com.assistencia.service.dto.GarantiaDto;

public interface GarantiaService extends Service{
    public Garantia adicionaGarantia(GarantiaDto garantia);
    public Garantia buscaPorId(int id);
    public boolean removerGarantia(int id);
}

