package com.assistencia.service;

import com.assistencia.entity.Peca;

public interface PecaService {
    public Peca buscaPorId(int id);
    public boolean deletarPeca(int id);
    public boolean adicionarAoEstoque(int id, int quant);
}
