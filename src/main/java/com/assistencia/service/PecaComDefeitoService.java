package com.assistencia.service;

import com.assistencia.entity.PecaComDefeito;

public interface PecaComDefeitoService {
    public PecaComDefeito buscaPorID(int id);
    public PecaComDefeito adicionaPeca(PecaComDefeito pecaComDefeito);
    public boolean atualizaPecaComDefeito(PecaComDefeito pecaComDefeito);
}
