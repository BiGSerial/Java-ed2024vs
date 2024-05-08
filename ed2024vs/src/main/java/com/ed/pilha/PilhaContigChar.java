package pilha;

import dados.ItemChar;

public class PilhaContigChar {
	private ItemChar[] info;
	private int topo;

	public PilhaContigChar(int qte) {
		this.topo = 0;
		this.info = new ItemChar[qte];
	}

	public ItemChar getInfo() {
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
	public boolean empilhar(ItemChar elem) {
		if (this.eCheia()) {
			return false;
		}
		this.info[this.topo] = elem;
		this.topo++;
		return true;
	}

	// Remove o dado que está no topo da pilha (somente um dado)
	public ItemChar desempilhar() {
		if (this.eVazia()) {
			return null;
		}
		this.topo--;
		ItemChar itemRemovido = this.info[this.topo];
		this.info[this.topo] = null; // Remover referência para o item desempilhado
		return itemRemovido;
	}

	// Inverte uma string usando uma pilha
	public String inverterString(String frase) {
		PilhaContigChar pilha = new PilhaContigChar(frase.length());
		StringBuilder resposta = new StringBuilder();

		for (int i = 0; i < frase.length(); i++) {
			pilha.empilhar(new ItemChar(frase.charAt(i)));
		}

		while (!pilha.eVazia()) {
			resposta.append(pilha.desempilhar().getChave());
		}

		return resposta.toString();
	}
}
