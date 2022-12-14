package br.senai.sc.lanchonete.view;

import br.senai.sc.lanchonete.controller.PedidoController;
import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.entities.Porcao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPoli {

    static private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        menu();
    }

    private static void menu() throws SQLException {
        System.out.print("" + "----------MENU----------\n" + "1 - Listar\n" + "2 - Cadastrar\n" + "3 - Editar\n"
                + "4 - Remover\n" + "5 - Encerrar\n" + "> ");
        switch (sc.nextInt()) {
            case 1 -> {
                listar(selecionaTipo("listar"));
            }
            case 2 -> {
                cadastrarPedido(selecionaTipo("cadastrar"));
            }
            case 3 -> {
                editar(selecionaTipo("editar"));
            }
            case 4 -> {
                remover(selecionaTipo("remover"));
            }
            case 5 -> {
                System.exit(0);
            }
        }
    }

    private static int selecionaTipo(String operacao) {
        System.out.println(
                "" + "Selecione o que deseja " + operacao + ":\n" + "1 - Lanche\n" + "2 - Bebida\n" + "3 - Porcao");
        int tipo = sc.nextInt();
        if (tipo < 1 || tipo > 3) {
            selecionaTipo(operacao);
        }
        return tipo;
    }

    private static void listar(int tipo) throws SQLException {
        switch (tipo) {
            case 1 -> {
                ArrayList<Lanche> pedidos = new ArrayList<>(new PedidoController().buscarPedidosLanche());
                System.out.println(pedidos);
            }
            case 2 -> {
                ArrayList<Bebida> pedidos = new ArrayList<>(new PedidoController().buscarPedidosBebidas());
                System.out.println(pedidos);
            }
            case 3 -> {
                ArrayList<Porcao> pedidos = new ArrayList<>(new PedidoController().buscarPedidosPorcoes());
                System.out.println(pedidos);
            }
        }
        menu();
    }

    private static void cadastrarPedido(int tipo) throws SQLException {
        System.out.println("C?digo: ");
        Integer codigo = sc.nextInt();
        System.out.println("Descri??o: ");
        String descricao = sc.next();
        System.out.println("Pre?o: ");
        double preco = sc.nextDouble();
        String adicional = null;
        switch (tipo) {
            case 1 -> {
                System.out.println("Peso: ");
                adicional = sc.next();
            }
            case 2 -> {
                System.out.println("Volume: ");
                adicional = sc.next();
            }
            case 3 -> {
                System.out.println("Tamanho: ");
                adicional = sc.next();
            }
        }
        PedidoController.cadastrarPedido(codigo, descricao, preco, adicional, tipo);
        menu();
    }

    private static void editar(int tipo) throws SQLException {
        System.out.println("Insira o codigo do item a ser editado: ");
        Integer codigo = sc.nextInt();
        System.out.println("Qual o novo pre?o? ");
        Double novoPreco = sc.nextDouble();
        new PedidoController().editarPedido(tipo, codigo, novoPreco);
        menu();
    }

    private static void remover(int tipo) throws SQLException {
        System.out.println("Insira o codigo do item a ser removido: ");
        Integer codigoPedido = sc.nextInt();
        new PedidoController().removerPedido(tipo, codigoPedido);
        menu();
    }

}