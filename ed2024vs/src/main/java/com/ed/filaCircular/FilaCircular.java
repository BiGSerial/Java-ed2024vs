package com.ed.filaCircular;

import com.ed.dados.*;
import com.ed.pilha.PilhaContigChar;

public class FilaCircular {
	private Item[] info;
	private int frente;
	private int tras;
	private int tamanho;

	public FilaCircular(int qte) {
		this.frente = 0;
		this.tras = 0;
		this.tamanho = 0;
		this.info = new Item[qte];
	}

	public Item getInfo() {
		return this.info[this.frente];
	}

	public int getFrente() {
		return this.frente;
	}

	public int getTras() {
		return this.tras;
	}

	public int getTamanho() {
		return this.tamanho;
	}

	public boolean eVazia() {
		return (this.tamanho == 0);
	}

	public boolean eCheia() {
		return (this.tamanho == this.info.length);
	}

	public boolean enfileirar(Item elem) {
		if (this.eCheia())
			return false;
		else {
			this.info[this.tras] = elem;
			this.tras = ++this.tras % this.info.length;
			this.tamanho++;
			return true;
		}
	}

	public Item desenfileirar() {
		Item no;
		if (this.eVazia())
			return null;
		else {
			no = this.info[this.frente];
			this.frente = ++this.frente % this.info.length;
			this.tamanho--;
			return no;
		}
	}

	public String toString() {
		String msg = "";
		int aux = this.frente;
		for (int i = 1; i <= this.tamanho; i++) {
			msg += this.info[aux].getChave() + " ";
			aux = ++aux % this.info.length;
		}
		return msg;
	}

	// Atividade 6: Ex 1
	public FilaCircular removerNegativos() {
    FilaCircular novaFila = new FilaCircular(this.tamanho);
    int qtdRemovidos = 0;

    for (int i = 0; i < this.tamanho; i++) {
        Item itemAtual = this.desenfileirar();
        if (itemAtual.getChave() >= 0) {
            novaFila.enfileirar(itemAtual);
        } else {
            qtdRemovidos++;
        }
    }

    this.info = novaFila.info;
    this.frente = novaFila.frente;
    this.tras = novaFila.tras;
    this.tamanho = novaFila.tamanho;

    return novaFila;
}


	// Atividade 6: Ex 2
	public int somaElementos() {
		int soma = 0;
		int tamanhoOriginal = tamanho;
		while (!eVazia()) {
			soma += desenfileirar().getChave();
		}
		tamanho = tamanhoOriginal;
		return soma;
	}

	// Atividade 6: Ex 3
	public FilaCircular transferirDaPilha(PilhaContigChar pilha) {
		FilaCircular novaFila = new FilaCircular(pilha.getTopo());
		while (!pilha.eVazia()) {
			novaFila.enfileirar(new Item(pilha.desempilhar().getChave()));

		}
		return novaFila;
	}

}
