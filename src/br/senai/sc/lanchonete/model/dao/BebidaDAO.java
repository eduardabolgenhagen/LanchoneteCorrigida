package br.senai.sc.lanchonete.model.dao;

import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.factory.BebidaFactory;
import br.senai.sc.lanchonete.model.factory.ConexaoFactory;
import br.senai.sc.lanchonete.model.factory.LancheFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

public class BebidaDAO {
    private Connection conn;
    private static Collection<Bebida> listaBebidas = new HashSet<>();

    public BebidaDAO() {
        this.conn = new ConexaoFactory().connectDB();
    }

    /**
     * Recebe o objeto para inserir dentro do banco de dados
     *
     * @param bebida
     * @throws SQLException
     */
    public void inserirBebida(Bebida bebida) throws SQLException {
        String comandoSQL = "INSERT INTO BEBIDAS (codigoBebida, descricao, preco, volume) values (?,?,?,?)";

        try (PreparedStatement pstm = conn.prepareStatement(comandoSQL)) {
            pstm.setInt(1, bebida.getCodigo());
            pstm.setString(2, bebida.getDescricao());
            pstm.setDouble(3, bebida.getPreco());
            pstm.setDouble(4, bebida.getVolume());
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("AQUI GERA O ERRO 003 EM BEBIDADAO");
            }
        } catch (Exception e) {
            throw new RuntimeException("AQUI GERA O ERRO 004 EM BEBIDADAO");
        }

        System.out.println("CADASTRO DE BEBIDA CHEGOU AO FIM");
    }

    public Collection<Bebida> buscarTodasBebidas() throws SQLException {
        String comandoSQL = "SELECT * FROM BEBIDAS";
        PreparedStatement prtm = conn.prepareStatement(comandoSQL);

        try (ResultSet resultSet = prtm.executeQuery()) {
            while (resultSet.next()) {
                listaBebidas.add(extrairObjetoBebida(resultSet));
            }
            return listaBebidas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("AQUI GERA O ERRO 003 NO BEBIDADAO");
        }
    }

    public void removerBebida(Integer codigo) throws SQLException {
        String sqlCommand = "DELETE FROM BEBIDAS WHERE codigoBebida = ?";
        try (PreparedStatement pstm = conn.prepareStatement(sqlCommand)) {
            pstm.setInt(1, codigo);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("AQUI GERA O ERRO 1 AO REMOVER BEBIDA");
            }
        } catch (Exception e) {
            throw new RuntimeException("AQUI GERA O ERRO 2 AO REMOVER BEBIDA");
        }
    }

    private Bebida extrairObjetoBebida(ResultSet resultSet) {
        try {
            return new BebidaFactory().getBebida(
                    resultSet.getInt("codigoBebida"),
                    resultSet.getString("descricao"),
                    resultSet.getDouble("preco"),
                    resultSet.getDouble("volume"));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair o objeto.");
        }
    }

    public void editarBebida(Integer codigo, double novoPreco) {
        String comandoSQL = "ALTER TABLE BEBIDAS WHERE codigoBebida = codigo";

        try (PreparedStatement pstm = conn.prepareStatement(comandoSQL)) {
            pstm.setDouble(codigo, novoPreco);
            try {
                pstm.execute();
            } catch (Exception e) {
                throw new RuntimeException("ERRO AO EDITAR O BEBIDA 001");
            }
        } catch (Exception e) {
            throw new RuntimeException("ERRO AO EDITAR O BEBIDA 002");
        }
    }
}
