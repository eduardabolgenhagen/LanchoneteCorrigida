package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.factory.ConexaoFactory;
import br.senai.sc.lanchonete.model.factory.LancheFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LancheDAO {
    private Connection conn;
    private static Collection<Lanche> listaLanches = new HashSet<>();

    public LancheDAO() {
        this.conn = new ConexaoFactory().connectDB();
    }

    /**
     * Recebe o objeto para inserir dentro do banco de dados
     *
     * @param lanche
     * @throws SQLException
     */
    public void inserirLanche(Lanche lanche) throws SQLException {
        String comandoSQL = "INSERT INTO LANCHES (codigoLanche, descricao, preco, peso) values (?,?,?,?)";

        try (PreparedStatement pstm = conn.prepareStatement(comandoSQL)) {
            pstm.setInt(1, lanche.getCodigo());
            pstm.setString(2, lanche.getDescricao());
            pstm.setDouble(3, lanche.getPreco());
            pstm.setDouble(4, lanche.getPeso());
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("AQUI GERA O ERRO 001 EM LANCHEDAO");
            }
        } catch (Exception e) {
            throw new RuntimeException("AQUI GERA O ERRO 002 EM LANCHEDAO");
        }
        System.out.println("CADASTRO DE LANCHE CHEGOU AO FIM");
    }

    /**
     * Lista todos os lnches exitentes
     *
     * @return
     * @throws SQLException
     */
    public Collection<Lanche> buscarTodosLanches() throws SQLException {
        String comandoSQL = "SELECT * FROM LANCHES";
        PreparedStatement prtm = conn.prepareStatement(comandoSQL);

        try (ResultSet resultSet = prtm.executeQuery()) {
            while (resultSet.next()) {
                listaLanches.add(extrairObjetoLanche(resultSet));
            }
            return listaLanches;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("AQUI GERA O ERRO 003 NO LANCHEDAO");
        }
    }

    /**
     * Recebe o código do Lanche para remove-lo
     *
     * @param codigo
     */
    public void removerLanche(Integer codigo) throws SQLException {
        String comandoSQL = "DELETE FROM LANCHES WHERE codigoLanche = ?";
        try (PreparedStatement pstm = conn.prepareStatement(comandoSQL)) {
            pstm.setInt(1, codigo);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("AQUI GERA O ERRO 1 AO REMOVER LANCHE");
            }
        } catch (Exception e) {
            throw new RuntimeException("AQUI GERA O ERRO 2 AO REMOVER LANCHE");
        }
    }

    public void editarLanche(Integer codigo, double novoPreco) throws SQLException {
        String comandoSQL = "ALTER TABLE LANCHES WHERE codigoLanche = codigo";

        try (PreparedStatement pstm = conn.prepareStatement(comandoSQL)) {
            pstm.setDouble(codigo, novoPreco);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("ERRO AO EDITAR O LANCHE 001");
            }
        } catch (Exception e) {
            throw new RuntimeException("ERRO AO EDITAR O LANCHE 002");
        }
    }

    private Lanche extrairObjetoLanche(ResultSet resultSet) {
        try {
            return new LancheFactory().getLanche(
                    resultSet.getInt("codigoLanche"),
                    resultSet.getString("descricao"),
                    resultSet.getDouble("preco"),
                    resultSet.getDouble("peso"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair o objeto.");
        }
    }
}
