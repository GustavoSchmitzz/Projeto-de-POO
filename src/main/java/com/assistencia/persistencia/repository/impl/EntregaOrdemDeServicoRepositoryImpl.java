package com.assistencia.persistencia.repository.impl;

import com.assistencia.config.DatabaseConfig;

import com.assistencia.entity.EntregaOrdemDeServico;
import com.assistencia.entity.OrdemDeServico;
import com.assistencia.persistencia.repository.EntregaOrdemDeServicoRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static java.sql.Date.valueOf;

public class EntregaOrdemDeServicoRepositoryImpl implements EntregaOrdemDeServicoRepository{
    public EntregaOrdemDeServico criar(EntregaOrdemDeServico entregaOS) {
        Properties credenciais = DatabaseConfig.getCredenciais();

        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "INSERT INTO entrega_ordens_de_servico (data_entrega, id_ordem_servico) VALUES (?, ?)";

        try(Connection conexao = DriverManager.getConnection(url, user,password);
            PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setDate(1, valueOf(entregaOS.getDataEntrega()));
            comando.setInt(2, entregaOS.getOrdemDeServico().getId());

            comando.executeUpdate();

            try (ResultSet chaveGerada = comando.getGeneratedKeys()) {
                if (chaveGerada.next()) {
                    entregaOS.setId(chaveGerada.getInt(1));
                }
            }
            return entregaOS;
        }catch(SQLException e){
            System.err.println("Erro ao salvar a entrega: " + e.getMessage());
        }
        return null;
    }
    public EntregaOrdemDeServico buscar(int id) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "SELECT * FROM entrega_ordens_de_servico WHERE id = ?";

        try(Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)){

            comando.setInt(1, id);

            try(ResultSet resultado = comando.executeQuery()){
                if(resultado.next()) {
                    EntregaOrdemDeServico entregaOS = new EntregaOrdemDeServico();

                    entregaOS.setId(id);
                    entregaOS.setDataEntrega(resultado.getDate("data_entrega").toLocalDate());

                    OrdemDeServico ordemDeServico = new OrdemDeServico();
                    ordemDeServico.setId(resultado.getInt("id_ordem_servico"));

                    entregaOS.setOrdemDeServico(ordemDeServico);

                    return entregaOS;
                }
            }
        }catch(SQLException e){
            System.err.println("Erro ao buscar a entrega: " + e.getMessage());
        }
        return null;
    }
    public boolean deletar(int id) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "DELETE FROM entrega_ordens_de_servico WHERE id = ?";
        try(Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            int linhasDeletadas = comando.executeUpdate();

            return linhasDeletadas > 0;

        }catch(SQLException e){
            System.err.println("Erro ao deletar a entrega: " + e.getMessage());
        }
        return false;
    }
    public boolean atualizar(EntregaOrdemDeServico entregaOS) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        String sql = "UPDATE entrega_ordens_de_servico SET data_entrega = ?, id_ordem_servico = ? WHERE id = ?";

        try(Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setDate(1,  valueOf(entregaOS.getDataEntrega()));
            comando.setInt(2, entregaOS.getOrdemDeServico().getId());
            comando.setInt(3, entregaOS.getId());

            int linhasAtualizadas = comando.executeUpdate();

            return linhasAtualizadas > 0;
        }catch(SQLException e){
            System.err.println("Erro ao atualizar a entrega: " + e.getMessage());
        }
        return false;
    }
    public List<EntregaOrdemDeServico> buscarTodos() {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");

        List<EntregaOrdemDeServico> entregas = new ArrayList<>();
        String sql = "SELECT * FROM entrega_ordens_de_servico";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                EntregaOrdemDeServico entregaOS = new EntregaOrdemDeServico();
                entregaOS.setId(resultado.getInt("id"));
                Date dataEntrega = resultado.getDate("data_entrega");
                if (dataEntrega != null) {
                    entregaOS.setDataEntrega(dataEntrega.toLocalDate());
                }

                OrdemDeServico ordemDeServico = new OrdemDeServico();
                ordemDeServico.setId(resultado.getInt("id_ordem_servico"));
                entregaOS.setOrdemDeServico(ordemDeServico);

                entregas.add(entregaOS);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar todas as entregas: " + e.getMessage());
        }
        return entregas;
    }
}