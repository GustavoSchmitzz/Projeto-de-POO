/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.Tecnico;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface TecnicoRepository {
    public Tecnico criar();
    public boolean atualizar();
    public Tecnico buscar();
    public boolean deletar();
    public List<Tecnico> buscarTodos();
}
