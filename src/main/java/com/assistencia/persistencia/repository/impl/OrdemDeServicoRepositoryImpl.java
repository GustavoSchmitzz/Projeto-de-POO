package com.assistencia.persistencia.repository.impl;

import com.assistencia.config.DatabaseConfig;
import com.assistencia.entity.*;
import com.assistencia.persistencia.repository.OrdemDeServicoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static java.sql.Date.valueOf;

public class OrdemDeServicoRepositoryImpl implements OrdemDeServicoRepository{
    public OrdemDeServico criar(OrdemDeServico ordemDeServico) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");
        String sql = "INSERT INTO ordens_de_servico (valor_servico, id_garantia, id_pagamento," +
                "data_inicio, tecnico, peca, status_servico) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            comando.setDouble(1, ordemDeServico.getValorServico());
            comando.setInt(2, ordemDeServico.getGarantia().getId());
            comando.setInt(3, ordemDeServico.getPagamento().getId());
            comando.setDate(4, valueOf(ordemDeServico.getDataInicio()));
            comando.setInt(5, ordemDeServico.getTecnico().getId());
            comando.setInt(6, ordemDeServico.getPeca().getId());
            comando.setInt(7, ordemDeServico.getStatusServico().getId());

            comando.executeUpdate();

            try (ResultSet resultado = comando.getGeneratedKeys()) {
                if(resultado.next()) {
                    ordemDeServico.setId(resultado.getInt(1));
                    return ordemDeServico;
                }
            }
        }catch (SQLException e) {
            System.err.println("Erro ao criar ordem de servico: " + e.getMessage());
        }
        return null;
    }
    public OrdemDeServico buscar(int id) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");
        String sql = "SELECT * FROM ordens_de_servico WHERE id = ?";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            try(ResultSet resultado = comando.executeQuery()) {
                if (resultado.next()) {
                    OrdemDeServico os = new OrdemDeServico();
                    os.setId(resultado.getInt("id"));
                    os.setDataInicio(resultado.getDate("data_inicio").toLocalDate());

                    Tecnico tecnico = new Tecnico();
                    tecnico.setId(resultado.getInt("id_tecnico"));
                    os.setTecnico(tecnico);

                    PecaComDefeito peca = new PecaComDefeito();
                    peca.setId(resultado.getInt("id_peca"));
                    os.setPeca(peca);

                    StatusServico status = new StatusServico();
                    status.setId(resultado.getInt("id_status"));
                    os.setStatusServico(status);

                    Garantia garantia = new Garantia();
                    garantia.setId(resultado.getInt("id_garantia"));
                    os.setGarantia(garantia);

                    FormaDePagamento pagamento = new FormaDePagamento();
                    pagamento.setId(resultado.getInt("id_pagamento"));
                    os.setPagamento(pagamento);

                    return os;
                }
            }
        }catch (SQLException e) {
            System.err.println("Erro ao buscar ordem de servico: " + e.getMessage());
        }
        return null;
    }
    public boolean deletar(int id) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");
        String sql = "DELETE FROM ordens_de_servico WHERE id = ?";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setInt(1, id);

            int resultado = comando.executeUpdate();

            return resultado > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar ordem de servico: " + e.getMessage());
        }
        return false;
    }
    public boolean atualizar(OrdemDeServico ordemDeServico) {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");
        String sql = "UPDATE ordens_de_servico SET valor_servico = ?, id_garantia = ?, id_pagamento = ?," +
                "data_inicio = ?, tecnico = ?, id_peca = ?, id_status = ? WHERE id = ?";

        try (Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setDouble(1, ordemDeServico.getValorServico());
            comando.setInt(2, ordemDeServico.getGarantia().getId());
            comando.setInt(3, ordemDeServico.getGarantia().getId());
            comando.setDate(4, valueOf(ordemDeServico.getDataInicio()));
            comando.setInt(5, ordemDeServico.getTecnico().getId());
            comando.setInt(6, ordemDeServico.getPeca().getId());
            comando.setInt(7, ordemDeServico.getStatusServico().getId());
            comando.setInt(8, ordemDeServico.getId());

            int resultado = comando.executeUpdate();

            return resultado > 0;

        }catch (SQLException e) {
            System.err.println("Erro ao atualizar ordem de servico: " + e.getMessage());
        }
        return false;
    }
    public List<OrdemDeServico> buscarTodos() {
        Properties credenciais = DatabaseConfig.getCredenciais();
        String url = credenciais.getProperty("db.url");
        String user = credenciais.getProperty("db.usuario");
        String password = credenciais.getProperty("db.senha");
        String sql = "SELECT * FROM ordens_de_servico";

        List<OrdemDeServico> ordens = new ArrayList<>();
        try (Connection conexao = DriverManager.getConnection(url, user, password);
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                OrdemDeServico os = new OrdemDeServico();
                os.setId(resultado.getInt("id"));
                Date dataInicio = resultado.getDate("data_inicio");
                if (dataInicio != null) {
                    os.setDataInicio(dataInicio.toLocalDate());
                }

                Tecnico tecnico = new Tecnico();
                tecnico.setId(resultado.getInt("id_tecnico"));
                os.setTecnico(tecnico);

                PecaComDefeito peca = new PecaComDefeito();
                peca.setId(resultado.getInt("id_peca"));
                os.setPeca(peca);

                StatusServico status = new StatusServico();
                status.setId(resultado.getInt("id_status"));
                os.setStatusServico(status);

                Garantia garantia = new Garantia();
                garantia.setId(resultado.getInt("id_garantia"));
                os.setGarantia(garantia);

                FormaDePagamento pagamento = new FormaDePagamento();
                pagamento.setId(resultado.getInt("id_pagamento"));
                os.setPagamento(pagamento);

                ordens.add(os);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar todas as ordens de servico: " + e.getMessage());
        }
        return ordens;
    }
}