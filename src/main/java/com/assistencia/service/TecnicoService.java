package com.assistencia.service;

import com.assistencia.entity.Tecnico;

public interface TecnicoService {
    public Tecnico buscaPorId(int id);
    public Tecnico cadastraTecnico(Tecnico tecnico);
    public boolean deletaTecnico(int id);
    public boolean atualizaTecnico(Tecnico tecnico);
}
