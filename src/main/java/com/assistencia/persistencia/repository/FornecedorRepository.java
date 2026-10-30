/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.Fornecedor;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface FornecedorRepository {
    public Fornecedor criar();
    public boolean atualizar();
    public Fornecedor buscar();
    public boolean deletar();
    public List<Fornecedor> buscarTodos();
}
