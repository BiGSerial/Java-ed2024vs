package com.ed.pilha;

import com.ed.dados.Item;

public class PilhaContig {
	private Item[] info;
	private int topo;

	public PilhaContig(int qte) {
		this.topo = 0;
		this.info = new Item[qte];
	}

	public Item getInfo() {
		if (this.topo == 0) {
			return null; // Retorna null se a pilha estiver vazia
		}
		return this.info[this.topo - 1];
	}

	public int getTopo() {
		return this.topo;
	}

	public boolean eVazia() {
		return (this.topo == 0);
	}

	public boolean eCheia() {
		return (this.topo == this.info.length);
	}

	// Inserir um novo dado no topo da pilha
	public boolean empilhar(Item elem) {
		if (this.eCheia()) {
			return false;
		}
		this.info[this.topo] = elem;
		this.topo++;
		return true;
	}

	// Remove o dado que está no topo da pilha (somente um dado)
	public Item desempilhar() {
		if (this.eVazia()) {
			return null;
		}
		this.topo--;
		Item itemRemovido = this.info[this.topo];
		this.info[this.topo] = null; // Remover referência para o item desempilhado
		return itemRemovido;
	}

	public static void mostrarPilha(PilhaContig pilha) {
		if (pilha.eVazia()) {
			System.out.println(">= [ empty ]");
		} else {
			if(pilha.eCheia()) {
				package com.ed.pilha;

import java.io.IOException;
import com.ed.dados.Item;
import java.util.Scanner;

public class MenuPrincipal {
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
			mostrarPilha(pilha);
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
		System.out.println("Escolha uma Opção:\n" +
				"1. Empilhar\n" +
				"2. Desempilhar\n" +
				"3. Inverter Pilha\n" +
				"4. Sair");
		return scan.next().charAt(0);
	}

	public static void mostrarPilha(PilhaContig pilha) {
		PilhaContig.mostrarPilha(pilha);
	}

	private static void limparTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}

			}
			for (int i = pilha.getTopo() - 1; i >= 0; i--) {
				System.out.print("[" + pilha.info[i].getChave() + "]");
			}
			System.out.println();
		}
	}

	public PilhaContig inverterPilha() {
		if (eVazia() || topo == 1) {
			return null;
		}

		PilhaContig auxiliar = new PilhaContig(this.info.length);

		while (!eVazia()) {
			auxiliar.empilhar(desempilhar());
		}

		this.topo = auxiliar.topo;
		this.info = auxiliar.info;

		return this;
	}
}
