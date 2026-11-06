package com.assistencia.persistencia.repository.impl;

import com.assistencia.config.DatabaseConfig;
import com.assistencia.entity.Garantia;
import com.assistencia.persistencia.repository.GarantiaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GarantiaRepositoryImpl implements GarantiaRepository{
    public List<Garantia> buscarTodos() {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        List<Garantia> garantias = new ArrayList<>();
        String sql = "SELECT * FROM garantia";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                Garantia garantia = new Garantia();
                garantia.setId(resultado.getInt("id_"));
                garantia.setDiasDeGarantia(resultado.getInt("dias_de_garantia"));

                garantias.add(garantia);
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar todas as garantias: " + e.getMessage());
        }
        return garantias;
    }
}
