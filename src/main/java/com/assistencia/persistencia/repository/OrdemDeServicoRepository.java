/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.OrdemDeServico;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface OrdemDeServicoRepository {
    public OrdemDeServico criar(OrdemDeServico os);
    public boolean atualizar(OrdemDeServico os);
    public OrdemDeServico buscar(int id);
    public boolean deletar(int id);
    public List<OrdemDeServico> buscarTodos();
}
