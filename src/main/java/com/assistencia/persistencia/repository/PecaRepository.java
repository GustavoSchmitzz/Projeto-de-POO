/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.Peca;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface PecaRepository {
    public Peca criar(Peca peca);
    public boolean atualizar(Peca peca);
    public Peca buscar(int id);
    public boolean deletar(int id);
    public List<Peca> buscarTodos();
}
