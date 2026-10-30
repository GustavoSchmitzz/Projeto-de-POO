/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.EntregaOrdemDeServico;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface EntregaOrdemDeServicoRepository {
    public EntregaOrdemDeServico criar();
    public boolean atualizar();
    public EntregaOrdemDeServico buscar();
    public boolean deletar();
    public List<EntregaOrdemDeServico> buscarTodos();
    
}
