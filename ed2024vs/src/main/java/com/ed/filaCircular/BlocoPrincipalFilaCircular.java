package com.ed.filaCircular;

import com.ed.dados.Item;

import java.util.Scanner;


public class BlocoPrincipalFilaCircular {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Digite o tamanho máximo da fila");
		int tam = scan.nextInt();
		FilaCircular fila = new FilaCircular(tam);
		int valor;
		Item item;
		char opcao;

		do {
			exibirMenu();
			opcao = scan.next().charAt(0);

			switch (opcao) {
				case '1':
					System.out.println("Inserir um Valor no final da fila\nDigite um valor");
					valor = scan.nextInt();
					if (!fila.enfileirar(new Item(valor))) {
						System.out.println("Fila está cheia");
					}
					break;
				case '2':
					item = fila.desenfileirar();
					if (item == null) {
						System.out.println("A fila está vazia");
					} else {
						System.out.println("O " + item.getChave() + " foi removido da fila");
					}
					break;
				case '3':
					if (!fila.eVazia()) {
						System.out.println("A fila: " + fila.toString());
					} else {
						System.out.println("A fila está vazia");
					}
					break;
				case '4':
					int removidos = fila.removerNegativos();
					System.out.println("Números negativos removidos da fila: " + removidos);
					break;
				case '0':
					System.out.println("Fim do programa");
					break;
				default:
					System.out.println("Opção inválida, tente novamente");
			}
		} while (opcao != '0');
	}

	private static void exibirMenu() {
		System.out.println("Escolha uma Opção:\n" +
				"1. Enfileirar\n" +
				"2. Desenfileirar\n" +
				"3. Imprimir Fila\n" +
				"4. Remover Negativos da Fila\n" +
				"0. Sair");
	}
}
