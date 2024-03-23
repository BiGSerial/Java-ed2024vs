package com.ed.simplesmente;

import com.ed.dados.Item;

public class ListaSimples {
	private No prim;
	private No ult;
	private int quantNos;

	// construtor da classe
	public ListaSimples() {
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public No getPrim() {
		return this.prim;
	}

	public No getUlt() {
		return this.ult;
	}

	public void setQuantNos(int novoValor) {
		this.quantNos = novoValor;
	}

	public void setPrim(No novoNo) {
		this.prim = novoNo;
	}

	public void setUlt(No novoNo) {
		this.ult = novoNo;
	}

	public boolean eVazia() {
		return (this.prim == null);
	}

	// insere um novo n� no final da lista ou se a lista estiver vazia, insere o
	// primeiro n� na lista
	public void inserirUltimo(Item elem) {
		No novoNo = new No(elem);
		if (this.eVazia()) {
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	// retorna o endere�o do n� que est� contendo o valor a ser procurado.
	public No pesquisarNo(int chave) {
		No atual = this.prim;
		while ((atual != null) && (atual.getInfo().getChave() != chave)) {
			atual = atual.getProx();
		}
		return atual;
	}

	// remove um determinado n� em qualquer posi��o na lista.
	public boolean removerNo(int chave) {
		No atual = this.prim;
		No ant = null;
		if (eVazia()) {
			return false;
		} else {
			while ((atual != null) && (atual.getInfo().getChave() != chave)) {
				ant = atual;
				atual = atual.getProx();
			}
			if (atual == null) {
				return false;
			} else {
				if (atual == this.prim) {
					if (this.prim == this.ult) {
						this.ult = null;
					}
					this.prim = this.prim.getProx();
				} else {
					if (atual == this.ult) {
						this.ult = ant;
					}
					ant.setProx(atual.getProx());
				}
				this.quantNos--;
				return true;
			}
		}
	}

	// outra forma de escrever o m�todo para remover determinado N�
	public boolean removerN(int x) {
		if (this.eVazia()) {
			return false;
		} else {
			if (this.prim.getInfo().getChave() == x) {
				if (this.prim.getProx() == null) {// se for �nico n� da lista
					this.ult = null;
				}
				// remover o primeiro n� da lista
				this.prim = this.prim.getProx();
			} else {
				No atual = this.prim;
				while ((atual.getProx() != null) &&
						(atual.getProx().getInfo().getChave() != x)) {
					atual = atual.getProx();
				}
				if (atual.getProx() == null) {// n�o achou o valor na lista
					return false;
				} else {
					if (atual.getProx() == this.ult) {// se for o �ltimo n�
						atual.setProx(null);
						this.ult = atual;
					} else { // remove o n� no meio da lista
						atual.setProx(atual.getProx().getProx());
					}
				}
			}
			this.quantNos--;
			return true;

		}
	}

	// mostra todo o conte�do da lista
	public String toString() {
		String msg = "";
		No atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().getChave() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}

	// Atividade 02 Questão 7 - Soma Todos os valores da lista.
	public int calcularSoma() {
		int soma = 0;
		No atual = this.prim;
		while (atual != null) {
			soma += atual.getInfo().getChave();
			atual = atual.getProx();
		}

		return soma;
	}

	// Atividade 02 Questão 8 - Média dos valores da lista
	public double calcularMedia() {
		double soma = 0;
		No atual = this.prim;
		while (atual != null) {
			soma += atual.getInfo().getChave();
			atual = atual.getProx();
		}

		return soma / this.quantNos;
	}

	// Atividade 02 Questão 9 - Média dos valores da lista
	public int[] mostrarApenasPares() {
		int[] v = new int[this.quantNos];
		No atual = this.prim;
		int i = 0;

		while (atual != null) {
			if (atual.getInfo().getChave() % 2 == 0) {
				v[i] = atual.getInfo().getChave();
				i++;
			}

			atual = atual.getProx();
		}

		return v;
	}

	// Atividade 02 Questão 10 - Verificar se as listas sao identicas
	public boolean verificarListaIdentica(ListaSimples lista2) {

		No atual = this.prim;
		No atual2 = lista2.prim;

		if (this.quantNos != lista2.quantNos) {
			return false;
		} else {

			while (atual != null) {
				if (atual.getInfo().getChave() == atual2.getInfo().getChave()) {
					atual = atual.getProx();
					atual2 = atual2.getProx();
				} else {
					return false;
				}
			}

		}

		return true;
	}

	// Atividade 02 Questão 11 - VBuscar Valor e alterar por um novo
	public int procurarEAlterar(int valorProcurado, int novoValor) {

		if (this.eVazia()) {

			return -1;
		} else {
			No atual = this.prim;

			while (atual != null) {
				if (atual.getInfo().getChave() == valorProcurado) {

					atual.getInfo().setChave(novoValor);
					return 1;
				}
				atual = atual.getProx();
			}

			return 0;
		}
	}

	// Atividade 02 Questão 12 - Procura valor, se nao encontrar insere, caso contrário, conta quantas vezes aparece.
	public int procurarInserirOuContar(int valor) {
		if (this.eVazia()) {
			this.inserirUltimo(new Item(valor));
			return 0;
		} else {
			int contador = 0;
			No atual = this.prim;
			while (atual != null) {
				if (atual.getInfo().getChave() == valor) {
					contador++;
				}
				if (atual.getProx() == null) {
					if (contador == 0) {
						this.inserirUltimo(new Item(valor));
					}
					break;
				}
				atual = atual.getProx();
			}
			return contador;
		}
	} 
	

}
