/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assistencia.persistencia.repository;

import com.assistencia.persistencia.repository.impl.ClienteRepositoryImpl;
import com.assistencia.persistencia.repository.impl.EntregaOrdemDeServicoRepositoryImpl;
import com.assistencia.persistencia.repository.impl.FormaDePagamentoRepositoryImpl;
import com.assistencia.persistencia.repository.impl.FornecedorRepositoryImpl;
import com.assistencia.persistencia.repository.impl.GarantiaRepositoryImpl;
import com.assistencia.persistencia.repository.impl.OrdemDeServicoRepositoryImpl;
import com.assistencia.persistencia.repository.impl.OrdemPecaRepositoryImpl;
import com.assistencia.persistencia.repository.impl.PecaComDefeitoRepositoryImpl;
import com.assistencia.persistencia.repository.impl.PecaRepositoryImpl;
import com.assistencia.persistencia.repository.impl.StatusServicoRepositoryImpl;
import com.assistencia.persistencia.repository.impl.TecnicoRepositoryImpl;

/**
 *
 * @author gustavoaes
 */
public class RepositoryAbstractFactory {

    public static ClienteRepository criarClienteRepository() {
        return new ClienteRepositoryImpl();
    }

    public static EntregaOrdemDeServicoRepository criarEntregaOrdemDeServicoRepository() {
        return new EntregaOrdemDeServicoRepositoryImpl();
    }

    public static FormaDePagamentoRepository criarFormaDePagamentoRepository() {
        return new FormaDePagamentoRepositoryImpl();
    }

    public static FornecedorRepository criarFornecedorRepository() {
        return new FornecedorRepositoryImpl();
    }

    public static GarantiaRepository criarGarantiaRepository() {
        return new GarantiaRepositoryImpl();
    }

    public static OrdemDeServicoRepository criarOrdemDeServicoRepository() {
        return new OrdemDeServicoRepositoryImpl();
    }

    public static OrdemPecaRepository criarOrdemPecaRepository() {
        return new OrdemPecaRepositoryImpl();
    }

    public static PecaComDefeitoRepository criarPecaComDefeitoRepository() {
        return new PecaComDefeitoRepositoryImpl();
    }

    public static PecaRepository criarPecaRepository() {
        return new PecaRepositoryImpl();
    }

    public static StatusServicoRepository criarStatusServicoRepository() {
        return new StatusServicoRepositoryImpl();
    }

    public static TecnicoRepository criarTecnicoRepository() {
        return new TecnicoRepositoryImpl();
    }
}
