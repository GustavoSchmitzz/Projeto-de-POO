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
    public OrdemPeca criar();
    public boolean atualizar();
    public OrdemPeca buscar();
    public boolean deletar();
    public List<OrdemPeca> buscarTodos();
}
