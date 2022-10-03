package br.senai.sc.lanchonete.view;

import br.senai.sc.lanchonete.controller.PedidoController;
import br.senai.sc.lanchonete.model.entities.Bebida;
import br.senai.sc.lanchonete.model.entities.Lanche;
import br.senai.sc.lanchonete.model.entities.Pedido;
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
            case 1:
                listar(selecionaTipo("listar"));
                break;
            case 2:
                cadastrarPedido(selecionaTipo("cadastrar"));
                break;

            case 3:
                editar(selecionaTipo("editar"));
                break;

            case 4:
                remover(selecionaTipo("remover"));
                break;

            case 5:
                System.exit(0);
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

    private static int valida(int tipo, int codigo) {
//
//		switch (tipo) {
//		case 1:
//			for (int i = 0; i < listaLanches.size(); i++) {
//				if (codigo == listaLanches.get(i).getCodigo()) {
//					return i;
//				}
//			}
//			break;
//		case 2:
//			for (int i = 0; i < listaBebidas.size(); i++) {
//				if (codigo == listaBebidas.get(i).getCodigo()) {
//					return i;
//				}
//			}
//			break;
//		case 3:
//			for (int i = 0; i < listaPorcoes.size(); i++) {
//				if (codigo == listaPorcoes.get(i).getCodigo()) {
//					return i;
//				}
//			}
//			break;
//		}
        return -1;
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
    }

    private static void cadastrarPedido(int tipo) throws SQLException {
        Pedido pedido = new Pedido();
        System.out.println("Código: ");
        Integer codigo = sc.nextInt();
        int posicao = valida(tipo, pedido.getCodigo());
        if (posicao != -1) {
            System.out.println("Código inválido!");
        } else {
            System.out.println("Descrição: ");
            String descricao = sc.next();
            System.out.println("Preço: ");
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
        }
    }

    private static void editar(int tipo) throws SQLException {
        System.out.println("Insira o codigo do item a ser editado: ");
        Integer codigo = sc.nextInt();
        System.out.println("Qual o novo preço? ");
        Double novoPreco = sc.nextDouble();
        new PedidoController().editarPedido(tipo, codigo, novoPreco);
    }

    private static void remover(int tipo) throws SQLException {
        System.out.println("Insira o codigo do item a ser removido: ");
        Integer codigoPedido = sc.nextInt();
        new PedidoController().removerPedido(tipo, codigoPedido);
    }

}