package com.assistencia.service;

import com.assistencia.entity.Tecnico;
import com.assistencia.service.dto.TecnicoDto;

public interface TecnicoService {
    public Tecnico buscaPorId(int id);
    public Tecnico cadastraTecnico(TecnicoDto tecnico);
    public boolean deletaTecnico(int id);
    public boolean atualizaTecnico(TecnicoDto tecnico);
}

