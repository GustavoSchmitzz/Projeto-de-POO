package com.assistencia.service;

import com.assistencia.entity.Garantia;

public interface GarantiaService {
    public Garantia adicionaGarantia(Garantia garantia);
    public Garantia buscaPorId(int id);
    public boolean removerGarantia(int id);
}
