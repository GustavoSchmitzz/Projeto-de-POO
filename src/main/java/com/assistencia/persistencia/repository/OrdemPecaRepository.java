/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.OrdemPeca;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface OrdemPecaRepository {
    public OrdemPeca criar(OrdemPeca ordem);
    public boolean atualizar(OrdemPeca ordem);
    public OrdemPeca buscar(int id);
    public boolean deletar(int id);
    public List<OrdemPeca> buscarTodos();
}
