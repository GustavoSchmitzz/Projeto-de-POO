/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assistencia.service;

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
import com.assistencia.service.impl.ClienteServiceImpl;
import com.assistencia.service.impl.EntregaOrdemDeServicoServiceImpl;
import com.assistencia.service.impl.FormaDePagamentoServiceImpl;
import com.assistencia.service.impl.FornecedorServiceImpl;
import com.assistencia.service.impl.GarantiaServiceImpl;
import com.assistencia.service.impl.OrdemDeServicoServiceImpl;
import com.assistencia.service.impl.OrdemPecaServiceImpl;
import com.assistencia.service.impl.PecaComDefeitoServiceImpl;
import com.assistencia.service.impl.PecaServiceImpl;
import com.assistencia.service.impl.StatusServicoServiceImpl;
import com.assistencia.service.impl.TecnicoServiceImpl;

/**
 *
 * @author gustavoaes
 */
public class ServiceAbstractFactory {

    public static ClienteService criarClienteService() {
        return new ClienteServiceImpl(new ClienteRepositoryImpl());
    }

    public static EntregaOrdemDeServicoService criarEntregaOrdemDeServicoService() {
        return new EntregaOrdemDeServicoServiceImpl(new OrdemDeServicoRepositoryImpl(), new EntregaOrdemDeServicoRepositoryImpl());
    }

    public static FormaDePagamentoService criarFormaDePagamentoService() {
        return new FormaDePagamentoServiceImpl(new FormaDePagamentoRepositoryImpl());
    }

    public static FornecedorService criarFornecedorService() {
        return new FornecedorServiceImpl(new FornecedorRepositoryImpl());
    }

    public static GarantiaService criarGarantiaService() {
        return new GarantiaServiceImpl(new GarantiaRepositoryImpl(), new OrdemDeServicoRepositoryImpl());
    }

    public static OrdemDeServicoService criarOrdemDeServicoService() {
        return new OrdemDeServicoServiceImpl(new FornecedorRepositoryImpl());
    }

    public static OrdemPecaService criarOrdemPecaService() {
        return new OrdemPecaServiceImpl(new OrdemPecaRepositoryImpl());
    }

    public static PecaComDefeitoService criarPecaComDefeitoService() {
        return new PecaComDefeitoServiceImpl(new PecaComDefeitoRepositoryImpl());
    }

    public static PecaService criarPecaService() {
        return new PecaServiceImpl(new PecaRepositoryImpl());
    }

    public static StatusServicoService criarStatusServicoService() {
        return new StatusServicoServiceImpl(new StatusServicoRepositoryImpl());
    }

    public static TecnicoService criarTecnicoService() {
        return new TecnicoServiceImpl(new TecnicoRepositoryImpl());
    }
}
