/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.Cliente;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface ClienteRepository {
    public Cliente criar(Cliente cliente);
    public boolean atualizar(Cliente cliente);
    public Cliente buscar(int id);
    public boolean deletar(int id);
    public List<Cliente> buscarTodos();
}
