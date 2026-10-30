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
    public Fornecedor criar(Fornecedor fornecedor);
    public boolean atualizar(Fornecedor fornecedor);
    public Fornecedor buscar(int id);
    public boolean deletar(int id);
    public List<Fornecedor> buscarTodos();
}
