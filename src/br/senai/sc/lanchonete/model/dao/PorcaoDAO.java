package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Porcao;
import br.senai.sc.lanchonete.model.factory.ConexaoFactory;
import br.senai.sc.lanchonete.model.factory.PorcaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

public class PorcaoDAO {
    private Connection conn;
    private static Collection<Porcao> listaPorcoes = new HashSet<>();

    public PorcaoDAO() {
        this.conn = new ConexaoFactory().connectDB();
    }

    /**
     * Recebe o objeto para inserir dentro do banco de dados
     *
     * @param porcao
     * @throws SQLException
     */
    public void inserirPorcao(Porcao porcao) throws SQLException {
        String comandoSQL = "INSERT INTO PORCOES (codigoPorcao, descricao, preco, tamanho) values (?,?,?,?)";

        try (PreparedStatement pstm = conn.prepareStatement(comandoSQL)) {
            pstm.setInt(1, porcao.getCodigo());
            pstm.setString(2, porcao.getDescricao());
            pstm.setDouble(3, porcao.getPreco());
            pstm.setString(4, porcao.getTamanho());
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("AQUI GERA O ERRO 005 EM PORCAODAO");
            }
        } catch (Exception e) {
            throw new RuntimeException("AQUI GERA O ERRO 006 EM PORCAODAO");
        }

        System.out.println("CADASTRO DE PORCAO CHEGOU AO FIM");
    }

    public Collection<Porcao> buscarPorcoes() throws SQLException {
        String comandoSQL = "SELECT * FROM PORCOES";
        PreparedStatement prtm = conn.prepareStatement(comandoSQL);

        try (ResultSet resultSet = prtm.executeQuery()) {
            while (resultSet.next()) {
                listaPorcoes.add(extrairObjetoPorcao(resultSet));
            }
            return listaPorcoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("AQUI GERA O ERRO 003 NO LANCHEDAO");
        }
    }

    public void removerPorcao(Integer codigo) throws SQLException {
        String sqlCommand = "DELETE FROM PORCOES WHERE codigoPorcao = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setInt(1, codigo);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("AQUI GERA O ERRO 1 AO REMOVER PORCAO");
            }
        } catch (Exception e) {
            throw new RuntimeException("AQUI GERA O ERRO 2 AO REMOVER PORCAO");
        }
    }

    private Porcao extrairObjetoPorcao(ResultSet resultSet) {
        try {
            return new PorcaoFactory().getPorcao(
                    resultSet.getInt("codigoPorcoes"),
                    resultSet.getString("descricao"),
                    resultSet.getDouble("preco"),
                    resultSet.getString("tamanho"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair o objeto.");
        }
    }

    public void editarPorcao(Integer codigo, double novoPreco) {
        String comandoSQL = "ALTER TABLE PORCOES WHERE codigoPorcao = codigo";

        try (PreparedStatement pstm = conn.prepareStatement(comandoSQL)) {
            pstm.setDouble(codigo, novoPreco);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("ERRO AO EDITAR O PORCOES 001");
            }
        } catch (Exception e) {
            throw new RuntimeException("ERRO AO EDITAR O PORCOES 002");
        }
    }
}
