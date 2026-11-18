/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assistencia.service;

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
        return new ClienteServiceImpl();
    }

    public static EntregaOrdemDeServicoService criarEntregaOrdemDeServicoService() {
        return new EntregaOrdemDeServicoServiceImpl();
    }

    public static FormaDePagamentoService criarFormaDePagamentoService() {
        return new FormaDePagamentoServiceImpl();
    }

    public static FornecedorService criarFornecedorService() {
        return new FornecedorServiceImpl();
    }

    public static GarantiaService criarGarantiaService() {
        return new GarantiaServiceImpl();
    }

    public static OrdemDeServicoService criarOrdemDeServicoService() {
        return new OrdemDeServicoServiceImpl();
    }

    public static OrdemPecaService criarOrdemPecaService() {
        return new OrdemPecaServiceImpl();
    }

    public static PecaComDefeitoService criarPecaComDefeitoService() {
        return new PecaComDefeitoServiceImpl();
    }

    public static PecaService criarPecaService() {
        return new PecaServiceImpl();
    }

    public static StatusServicoService criarStatusServicoService() {
        return new StatusServicoServiceImpl();
    }

    public static TecnicoService criarTecnicoService() {
        return new TecnicoServiceImpl();
    }
}
