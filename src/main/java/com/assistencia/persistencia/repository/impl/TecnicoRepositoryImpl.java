package com.assistencia.persistencia.repository.impl;

import com.assistencia.config.DatabaseConfig;
import com.assistencia.entity.Tecnico;
import com.assistencia.persistencia.repository.TecnicoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TecnicoRepositoryImpl implements TecnicoRepository{
    public Tecnico criar(Tecnico tecnico) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "INSERT INTO tecnicos (nome, telefone, especialidade) VALUES (?, ?, ?)";
        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            comando.setString(1, tecnico.getNome());
            comando.setString(2, tecnico.getTelefone());
            comando.setString(3, tecnico.getEspecialidade());

            comando.executeUpdate();

            try(ResultSet chaveGerada = comando.getGeneratedKeys()){
                if (chaveGerada.next()) {
                    int id = chaveGerada.getInt(1);
                    tecnico.setId(id);
                }
            }
            return tecnico;
        }catch (SQLException e) {
            System.err.println("Erro ao criar tecnico: " + e.getMessage());
        }
        return null;
    }
    public Tecnico buscar(int id) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "SELECT * FROM tecnicos WHERE id = ? ";
        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            comando.executeQuery();

            try (ResultSet resultado = comando.getResultSet()) {
                if (resultado.next()) {
                    Tecnico tecnico = new Tecnico();

                    tecnico.setId(id);
                    tecnico.setNome(resultado.getString("nome"));
                    tecnico.setTelefone(resultado.getString("telefone"));
                    tecnico.setEspecialidade(resultado.getString("especialidade"));

                    return tecnico;
                }
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar tecnico: " + e.getMessage());
        }
        return null;
    }
    public boolean deletar(int id) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "DELETE FROM tecnicos WHERE id = ? ";

        try(Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            int linhasDeletada = comando.executeUpdate();

            return linhasDeletada > 0;

        }catch (SQLException e) {
            System.err.println("Erro ao deletar tecnico: " + e.getMessage());
        }
        return false;
    }
    public boolean atualizar(Tecnico tecnico) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "UPDATE tecnicos SET nome = ?, telefone = ?, especialidade = ? WHERE id = ? ";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, tecnico.getNome());
            comando.setString(2, tecnico.getTelefone());
            comando.setString(3, tecnico.getEspecialidade());
            comando.setInt(4, tecnico.getId());

            int linhasAtualizada = comando.executeUpdate();

            return linhasAtualizada > 0;

        }catch (SQLException e) {
            System.err.println("Erro ao atualizar tecnico: " + e.getMessage());
        }
        return false;
    }
    public List<Tecnico> buscarTodos() {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        List<Tecnico> tecnicos = new ArrayList<>();
        String sql = "SELECT * FROM tecnicos";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                Tecnico tecnico = new Tecnico();

                tecnico.setId(resultado.getInt("id"));
                tecnico.setNome(resultado.getString("nome"));
                tecnico.setTelefone(resultado.getString("telefone"));
                tecnico.setEspecialidade(resultado.getString("especialidade"));

                tecnicos.add(tecnico);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os tecnicos: " + e.getMessage());
        }
        return tecnicos;
    }
}
