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
				System.out.print("X=[");
			} else {
				System.out.print(">=[");
			}
			for (int i = pilha.getTopo() - 1; i >= 0; i--) {
				System.out.print(" " + pilha.info[i].getChave());
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
