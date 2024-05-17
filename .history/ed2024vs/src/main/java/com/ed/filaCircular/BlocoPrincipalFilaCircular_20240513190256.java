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

    public Item get(int index) {
        if (index < 0 || index >= this.tamanho)
            throw new IndexOutOfBoundsException("Index fora dos limites da fila");
        int posicao = (this.frente + index) % this.info.length;
        return this.info[posicao];
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String toString() {
        String msg = "";
        for (int i = 0; i < this.tamanho; i++) {
            msg += this.get(i).getChave() + " ";
        }
        return msg;
    }

    public FilaCircular removerNegativos() {
        FilaCircular novaFila = new FilaCircular(this.tamanho);

        while (!this.eVazia()) {
            Item itemAtual = this.desenfileirar();
            if (itemAtual.getChave() >= 0) {
                novaFila.enfileirar(itemAtual);
            }
        }

        this.info = novaFila.info;
        this.frente = novaFila.frente;
        this.tras = novaFila.tras;
        this.tamanho = novaFila.tamanho;

        return this;
    }

    public int somaElementos() {
        int soma = 0;
        int tamanhoOriginal = tamanho;
        while (!eVazia()) {
            soma += desenfileirar().getChave();
        }
        tamanho = tamanhoOriginal;
        return soma;
    }

    public FilaCircular transferirDaPilha(PilhaContigChar pilha) {
        FilaCircular novaFila = new FilaCircular(pilha.getTopo());
        while (!pilha.eVazia()) {
            novaFila.enfileirar(new Item(pilha.desempilhar().getChave()));

        }
        return novaFila;
    }
}
