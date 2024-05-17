package com.ed.simplesmente;

import java.util.Scanner;

import com.ed.dados.Item;

public class MenuPrincipal {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// instancia a lista vazia
		ListaSimples lista = new ListaSimples();
		char opcao;
		int valor;
		Item item;
		do {
			System.out.println("escolha uma op��o:\n"
					+ "1. inserir n� no final da lista\n"
					+ "2. pesquisar se um determinado valor\n"
					+ "3. remover um determinado n� da lista\n"
					+ "4. sair do programa\n"
					+ "5. mostrar a lista");
			opcao = scan.next().charAt(0);
			switch (opcao) {
				case '1':
					System.out.println("digite um valor inteiro:");
					valor = scan.nextInt();
					item = new Item(valor);
					lista.inserirUltimo(item);
					System.out.println("opera��o realizada com sucesso!");
					break;
				case '2':
					System.out.println("digite o valor inteiro a"
							+ " ser procurado na lista:");
					valor = scan.nextInt();
					if (lista.pesquisarNo(valor) != null) {
						System.out.println("o valor est� na lista");
					} else {
						System.out.println("o valor n�o est� na lista");
					}
					break;
				case '3':
					System.out.println("digite o valor inteiro a"
							+ " ser removido da lista:");
					valor = scan.nextInt();
					if (lista.removerN(valor)) {
						System.out.println("o valor foi removido com sucesso!");
					} else {
						System.out.println("o valor n�o est� na lista");
					}
					break;
				case '4':
					System.out.println("fim");
					break;
				case '5':
					System.out.println("Mostrar a lista:\n" + lista.toString());
					break;
				default:
					System.out.println("op��o inv�lida");
			}
		} while (opcao != '4');
	}

}
