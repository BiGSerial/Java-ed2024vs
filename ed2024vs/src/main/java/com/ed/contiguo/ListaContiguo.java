package com.ed.contiguo;

import com.ed.dados.Item;

public class ListaContiguo {

  private int fim;
  private Item[] info;

  public ListaContiguo(int qte) {
    this.fim = 0;
    this.info = new Item[qte];
  }

  public Item getInfo(int i) {
    return this.info[i];
  }

  public void setInfo(int i, Item elem) {
    this.info[i] = elem;
  }

  public int getFim() {
    return this.fim;
  }

  public void setFim(int _fim) {
    this.fim = _fim;
  }

  public boolean eVazia() {
    return (this.fim == 0);
  }

  public boolean eCheia() {
    return (this.fim == this.info.length);
  }

  // retorna verdadeiro se conseguiu inserir o novo nó no final na lista.
  public boolean inserirUltimo(Item elem) {
    if (this.eCheia()) {
      return false;
    } else {
      this.info[this.fim] = elem;
      this.fim++;
      return true;
    }
  }

  // retorna a posição do nó caso ele seja encontrado, caso contrário, retorna
  // o valor do this.fim simbolizando que não foi encontrado.
  public int pesquisarNo(int chave) {
    int i = 0;
    while ((i < this.fim) && (this.info[i].getChave() != chave)) {
      i++;
    }
    return i;
  }

  // retorna verdadeiro se conseguiu remover um nó especifico.
  public boolean removerNo(int chave) {
    int i = 0;
    while ((i < this.fim) && (this.info[i].getChave() != chave)) {
      i++;
    }
    if (i == this.fim) {
      return false;
    } else {
      for (int j = i; j < this.fim - 1; j++) {
        this.info[j] = this.info[j + 1];
      }
      this.fim--;
      return true;
    }
  }

  // retorna uma String com todo o conteúdo da lista.
  public String toString() {
    String msg = "";
    for (int i = 0; i < this.fim; i++) {
      msg += this.info[i].getChave() + "\n";
    }
    return msg;
  }

  // Atividade 3 - Questao 2B
  public int encontrarPosicao(int valor) {
    for (int i = 0; i < fim; i++) {
      if (this.info[i].getChave() == valor) {
        return i;
      }
    }
    return -1;
  }

  // Atividade 3 - Questao 2C
  public int inserirAposElemento(int elemento, int novoElemento) {
    int posicaoElemento = encontrarPosicao(elemento);

    if (posicaoElemento != -1) {

      if (fim < this.info.length - 1) {
        // Desloca os elementos à direita para abrir espaço para o novo elemento
        for (int i = fim; i > posicaoElemento + 1; i--) {
          info[i] = info[i - 1];
        }
        // Insere o novo elemento após o elemento de número 8
        this.info[posicaoElemento + 1].setChave(novoElemento);
        fim++; // Incrementa o contador de elementos da lista
        return 1; // Operação bem-sucedida
      } else {
        return -1; // Não há espaço na lista para inserir o novo elemento
      }
    } else {
      return -2; // Elemento não encontrado na lista
    }
  }

  // Atividade 3 - Questao 2D
  public int removerElemento(int valor) {

    boolean removido = false;

    for (int i = 0; i < fim; i++) {
      if (this.info[i].getChave() == valor) {
        // Desloca os elementos à esquerda para preencher o espaço deixado pelo valor
        // removido
        for (int j = i; j < fim - 1; j++) {
          info[j] = info[j + 1];
        }
        fim--; // Decrementa o contador de elementos da lista
        removido = true;
      }
    }

    if (removido) {

      return 1;

    } else {

      return -1;

    }

  }

}
