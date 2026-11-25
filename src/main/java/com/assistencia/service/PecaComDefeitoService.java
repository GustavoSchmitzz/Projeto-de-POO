package com.assistencia.service;

import com.assistencia.entity.PecaComDefeito;
import com.assistencia.service.dto.PecaComDefeitoDto;

public interface PecaComDefeitoService extends Service{
    public PecaComDefeito buscaPorID(int id);
    public PecaComDefeito adicionaPeca(PecaComDefeitoDto pecaComDefeito);
    public boolean atualizaPecaComDefeito(PecaComDefeitoDto pecaComDefeito);
}

