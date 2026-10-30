/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.entity.Garantia;
import java.util.List;

/**
 *
 * @author gustavoaes
 */
public interface GarantiaRepository {
    public List<Garantia> buscarTodos();
}
