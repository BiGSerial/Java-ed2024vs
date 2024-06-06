package com.ed.pilha;

import java.io.IOException;
import com.ed.dados.Item;
import java.util.Scanner;

public class MenuPrincipal {

	private static final String RESET = "\033[0m";
	private static final String GREEN = "\033[0;32m"; // Cor verde para indicar algo positivo
	private static final String RED = "\033[0;31m"; // Cor vermelha para indicar algo negativo
	private static final String YELLOW = "\033[0;33m"; // Cor amarela para avisos

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Digite o tamanho máximo da pilha:");
		int quant = scan.nextInt();
		PilhaContig pilha = new PilhaContig(quant);
		int valor;
		Item item;
		char opcao;
		do {
			limparTerminal();
			pilha.mostrarPilha();
			opcao = menu();
			switch (opcao) {
				case '1':
					System.out.println("Inserir um Valor na pilha\nDigite um valor:");
					valor = scan.nextInt();
					if (!pilha.empilhar(new Item(valor)))
						System.out.println("Pilha está cheia");
					break;
				case '2':
					item = pilha.desempilhar();
					if (item == null)
						System.out.println("A pilha está vazia");
					else
						System.out.println("Elemento desempilhado: " + item.getChave());
					break;
				case '3':
					pilha.inverterPilha();
					System.out.println("Pilha invertida");
					pausa();
					break;
				case '4':
					System.out.println("Fim do programa");
					break;
				default:
					System.out.println("Opção inválida, tente novamente");
			}

		} while (opcao != '4');
		System.exit(0);
	}

	public static char menu() {
		System.out.println("\n\nEscolha uma Opção:\n" +
				"1. Empilhar\n" +
				"2. Desempilhar\n" +
				"3. Inverter Pilha\n" +
				"4. Sair");
		return scan.next().charAt(0);
	}

	public static void pausa() {
		System.out.println("Pressione Enter para continuar...");
		scan.nextLine();
		scan.nextLine();
	}

	private static void limparTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
