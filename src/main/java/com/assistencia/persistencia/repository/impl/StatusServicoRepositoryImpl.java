package com.assistencia.persistencia.repository.impl;

import com.assistencia.config.DatabaseConfig;
import com.assistencia.entity.StatusServico;
import com.assistencia.persistencia.repository.StatusServicoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StatusServicoRepositoryImpl implements StatusServicoRepository{
    public List<StatusServico> buscarTodos() {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        List<StatusServico> statusList = new ArrayList<>();
        String sql = "SELECT * FROM StatusServico";
        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                StatusServico statusServico = new StatusServico();
                statusServico.setId(resultado.getInt("id"));
                statusServico.setStatus(resultado.getString("status"));

                statusList.add(statusServico);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os StatusServico: " + e.getMessage());
        }
        return statusList;
    }
}