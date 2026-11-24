package com.assistencia.persistencia.repository.impl;

import com.assistencia.config.DatabaseConfig;
import com.assistencia.entity.Fornecedor;
import com.assistencia.persistencia.repository.FornecedorRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FornecedorRepositoryImpl implements FornecedorRepository {
    public Fornecedor criar(Fornecedor fornecedor) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "INSERT INTO fornecedores (nome, telefone) VALUES (?, ?)";
        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getTelefone());

            comando.executeUpdate();

            try(ResultSet resultado = comando.getGeneratedKeys()) {
                if (resultado.next()) {
                    fornecedor.setId(resultado.getInt(1));
                }
            }
            return fornecedor;
        }catch (SQLException e) {
            System.err.println("Erro ao criar Fornecedor: " + e.getMessage());
        }
        return null;
    }
    public Fornecedor buscar(int id) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "SELECT * FROM fornecedores WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);
            try (ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setId(id);
                    fornecedor.setNome(resultado.getString("nome"));
                    fornecedor.setTelefone(resultado.getString("telefone"));

                    return fornecedor;
                }
            }
        }catch (SQLException e) {
            System.err.println("Erro ao buscar Fornecedor: " + e.getMessage());
        }
        return null;
    }
    public boolean deletar(int id) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "DELETE FROM fornecedores WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            int linhasAfetadas = comando.executeUpdate();

            return linhasAfetadas > 0;

        }catch (SQLException e) {
            System.err.println("Erro ao deletar Fornecedor: " + e.getMessage());
        }
        return false;
    }
    public boolean atualizar(Fornecedor fornecedor) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "UPDATE fornecedores SET nome = ?, telefone = ? WHERE id = ?";
        try (Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, fornecedor.getNome());
            comando.setString(2, fornecedor.getTelefone());
            comando.setInt(3, fornecedor.getId());

            int linhasAtualizadas = comando.executeUpdate();

            return linhasAtualizadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Fornecedor: " + e.getMessage());
        }
        return false;
    }
    public List<Fornecedor> buscarTodos() {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedores";
        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(resultado.getInt("id"));
                fornecedor.setNome(resultado.getString("nome"));
                fornecedor.setTelefone(resultado.getString("telefone"));

                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os fornecedores: " + e.getMessage());
        }
        return fornecedores;
    }
}
