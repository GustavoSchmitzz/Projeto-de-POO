package com.assistencia.persistencia.repository.impl;

import com.assistencia.config.DatabaseConfig;
import com.assistencia.entity.FormaDePagamento;
import com.assistencia.persistencia.repository.FormaDePagamentoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FormaDePagamentoRepositoryImpl implements FormaDePagamentoRepository{
    public List<FormaDePagamento> buscarTodos() {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        List<FormaDePagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM pagamentos";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                FormaDePagamento pagamento = new FormaDePagamento();
                pagamento.setId(resultado.getInt("id"));
                pagamento.setFormaPagamento(resultado.getString("forma_pagamento"));

                pagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar todas as formas de pagamento: " + e.getMessage());
        }
        return pagamentos;
    }
}
