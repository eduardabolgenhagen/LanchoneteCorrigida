//package br.senai.sc.lanchonete.model.entities;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//
//	static private Scanner sc = new Scanner(System.in);
//	static private ArrayList<Pedido> listaLanches = new ArrayList<>();
//	static private ArrayList<Pedido> listaBebidas = new ArrayList<>();
//	static private ArrayList<Pedido> listaPorcoes = new ArrayList<>();
//
//	public static void main(String[] args) {
//		addPadrao();
//		menu();
//	}
//
//	private static void menu() {
//		System.out.print("" + "----------MENU----------\n" + "1 - Listar\n" + "2 - Cadastrar\n" + "3 - Editar\n"
//				+ "4 - Remover\n" + "5 - Encerrar\n" + "> ");
//		switch (sc.nextInt()) {
//		case 1:
//			lista(selecionaTipo("listar"));
//			break;
//		case 2:
//			cadastrar(selecionaTipo("cadastrar"));
//			break;
//
//		case 3:
//			editar(selecionaTipo("editar"));
//			break;
//
//		case 4:
//			remover(selecionaTipo("remover"));
//			break;
//
//		case 5:
//			System.exit(0);
//		}
//	}
//
//	private static void editar(int tipo) {
//		System.out.println("Insira o codigo do item a ser editado: ");
//		int posicao = valida(tipo, sc.nextInt());
//		if (posicao == -1) {
//			System.out.println("Item não encontrado!");
//			editar(tipo);
//		}
//		System.out.println("Qual o novo preço? ");
//		switch (tipo) {
//		case 1:
//			listaLanches.get(posicao).setPreco(sc.nextDouble());
//			break;
//
//		case 2:
//			listaBebidas.get(posicao).setPreco(sc.nextDouble());
//			break;
//
//		case 3:
//			listaPorcoes.get(posicao).setPreco(sc.nextDouble());
//			break;
//
//		}
//		menu();
//	}
//
//	private static void remover(int tipo) {
//		System.out.println("Insira o codigo do item a ser removido: ");
//		int posicao = valida(tipo, sc.nextInt());
//		if (posicao == -1) {
//			System.out.println("Item não encontrado!");
//			remover(tipo);
//		}
//		switch (tipo) {
//		case 1:
//			listaLanches.remove(posicao);
//			break;
//
//		case 2:
//			listaBebidas.remove(posicao);
//			break;
//
//		case 3:
//			listaPorcoes.remove(posicao);
//			break;
//
//		}
//		menu();
//	}
//
//	private static int selecionaTipo(String operacao) {
//		System.out.println(
//				"" + "Selecione o que deseja " + operacao + ":\n" + "1 - Lanche\n" + "2 - Bebida\n" + "3 - Porcao");
//		int tipo = sc.nextInt();
//		if (tipo < 1 || tipo > 3) {
//			selecionaTipo(operacao);
//		}
//		return tipo;
//	}
//
//	private static void cadastrar(int tipo) {
//		switch (tipo) {
//		case 1:
//			listaLanches.add(coletaDadosLanche(tipo));
//			break;
//
//		case 2:
//			listaBebidas.add(coletaDadosBebida(tipo));
//			break;
//
//		case 3:
//			listaPorcoes.add(coletaDadosPorcao(tipo));
//			break;
//
//		}
//		menu();
//	}
//
//	private static Pedido coletaDadosPedido(int tipo) {
//		Pedido pedido = new Pedido();
//		System.out.println("Código: ");
//		pedido.setCodigo(sc.nextInt());
//		int posicao = valida(tipo, pedido.getCodigo());
//		if (posicao != -1) {
//			System.out.println("Código inválido!");
//			coletaDadosPedido(tipo);
//		}
//		System.out.println("Descrição: ");
//		pedido.setDescricao(sc.next());
//		System.out.println("Preço: ");
//		pedido.setPreco(sc.nextDouble());
//		return pedido;
//	}
//
//	private static Lanche coletaDadosLanche(int tipo) {
//		Pedido pedido = coletaDadosPedido(tipo);
//		double peso = sc.nextDouble();
//		return new Lanche(pedido.getCodigo(), pedido.getPreco(), pedido.getDescricao(), peso);
//	}
//
//	private static Bebida coletaDadosBebida(int tipo) {
//		Pedido pedido = coletaDadosPedido(tipo);
//		Bebida bebida = new Bebida();
//		bebida.setCodigo(pedido.getCodigo());
//		bebida.setDescricao(pedido.getDescricao());
//		bebida.setPreco(pedido.getPreco());
//		System.out.println("Volume: ");
//		bebida.setVolume(sc.nextDouble());
//		return bebida;
//	}
//
//	private static Porcao coletaDadosPorcao(int tipo) {
//		Pedido pedido = coletaDadosPedido(tipo);
//		Porcao porcao = new Porcao();
//		porcao.setCodigo(pedido.getCodigo());
//		porcao.setDescricao(pedido.getDescricao());
//		porcao.setPreco(pedido.getPreco());
//		System.out.println("Tamanho: ");
//		porcao.setTamanho(sc.next());
//		return porcao;
//	}
//
//	private static int valida(int tipo, int codigo) {
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
//		return -1;
//	}
//
//	private static void lista(int tipo) {
//		switch (tipo) {
//		case 1:
//			for (Pedido opcao : listaLanches) {
//				System.out.println(opcao.toString());
//			}
//			break;
//		case 2:
//			for (Pedido opcao : listaBebidas) {
//				System.out.println(opcao.toString());
//			}
//			break;
//		case 3:
//			for (Pedido opcao : listaPorcoes) {
//				System.out.println(opcao.toString());
//			}
//			break;
//		}
//		menu();
//	}
//
//	private static void addPadrao() {
//		Lanche xsalada = new Lanche(1, 12.0, "X-Salada", 0.8);
//		Lanche xtudo = new Lanche(2, 18.0, "X-Tudo", 1.2);
//		Lanche xburger = new Lanche(3, 10.0, "X-Burger", 0.6);
//		Lanche xbacon = new Lanche(4, 15.0, "X-Bacon", 1.0);
//		listaLanches.add(xsalada);
//		listaLanches.add(xtudo);
//		listaLanches.add(xburger);
//		listaLanches.add(xbacon);
//
//		Bebida refri200 = new Bebida();
//		refri200.setCodigo(1);
//		refri200.setPreco(5.0);
//		refri200.setDescricao("Refrigerante");
//		refri200.setVolume(0.35);
//
//		Bebida refri500 = new Bebida();
//		refri500.setCodigo(2);
//		refri500.setPreco(10.0);
//		refri500.setDescricao("Refrigerante");
//		refri500.setVolume(0.6);
//
//		Bebida suco200 = new Bebida();
//		suco200.setCodigo(3);
//		suco200.setPreco(6.0);
//		suco200.setDescricao("Suco");
//		suco200.setVolume(0.35);
//
//		Bebida suco500 = new Bebida();
//		suco500.setCodigo(4);
//		suco500.setPreco(12.0);
//		suco500.setDescricao("Suco");
//		suco500.setVolume(0.6);
//
//		listaBebidas.add(refri200);
//		listaBebidas.add(refri500);
//		listaBebidas.add(suco200);
//		listaBebidas.add(suco500);
//
//		Porcao fritasP = new Porcao();
//		fritasP.setCodigo(1);
//		fritasP.setPreco(3.5);
//		fritasP.setTamanho("Pequena");
//		fritasP.setDescricao("Batata Frita");
//
//		Porcao fritasM = new Porcao();
//		fritasM.setCodigo(2);
//		fritasM.setPreco(4.5);
//		fritasM.setTamanho("Média");
//		fritasM.setDescricao("Batata Frita");
//
//		Porcao fritasG = new Porcao();
//		fritasG.setCodigo(3);
//		fritasG.setPreco(5.5);
//		fritasG.setTamanho("Grande");
//		fritasG.setDescricao("Batata Frita");
//
//		Porcao salada = new Porcao();
//		salada.setCodigo(4);
//		salada.setPreco(8.0);
//		salada.setTamanho("Média");
//		salada.setDescricao("Salada");
//
//		listaPorcoes.add(fritasP);
//		listaPorcoes.add(fritasM);
//		listaPorcoes.add(fritasG);
//		listaPorcoes.add(salada);
//	}
//}