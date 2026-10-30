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
    public PecaComDefeito criar();
    public boolean atualizar();
    public PecaComDefeito buscar();
    public boolean deletar();
    public List<PecaComDefeito> buscarTodos();
}
