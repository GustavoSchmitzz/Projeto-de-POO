/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.PecaComDefeito;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface PecaComDefeitoRepository {
    public PecaComDefeito criar(PecaComDefeito peca);
    public boolean atualizar(PecaComDefeito peca);
    public PecaComDefeito buscar(int id);
    public boolean deletar(int id);
    public List<PecaComDefeito> buscarTodos();
}
