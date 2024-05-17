package com.ed.duplamente;

import com.ed.dados.Item;

public class ListaDupla {
    private NoDupla prim;
    private NoDupla ult;
    private int quantNos;

    public ListaDupla() {
        this.prim = null;
        this.ult = null;
        this.quantNos = 0;
    }

    public int getQuantNos() {
        return this.quantNos;
    }

    public NoDupla getPrim() {
        return this.prim;
    }

    public NoDupla getUlt() {
        return this.ult;
    }

    public void setQuantNos(int valorNovo) {
        this.quantNos = valorNovo;
    }

    public void setPrim(NoDupla novoNo) {
        this.prim = novoNo;
    }

    public void setUlt(NoDupla novoNo) {
        this.ult = novoNo;
    }

    public boolean eVazia() {
        return (this.prim == null);
    }

    public void inserirUltimo(Item elem) {
        NoDupla novoNo = new NoDupla(elem);

        if (this.eVazia()) {
            this.prim = novoNo;
        } else {
            novoNo.setAnt(this.ult);
            this.ult.setProx(novoNo);
        }
        this.ult = novoNo;
        this.quantNos++;
    }

    public NoDupla pesquisarNo(int chave) {
        NoDupla atual = this.prim;
        while ((atual != null) && (atual.getInfo().getChave() != chave)) {
            atual = atual.getProx();
        }

        return atual;
    }

    public boolean removerNo(int chave) {
        NoDupla atual = this.prim;

        while ((atual != null) && (atual.getInfo().getChave() != chave)) {

            atual = atual.getProx();

        }

        if (atual == null) {

            return false;

        } else {

            if (atual == this.prim) {

                this.prim = prim.getProx();

                if (this.prim == null) {

                    this.ult = null;

                } else {

                    this.prim.setAnt(null);

                }

            } else {

                if (atual == this.ult) {
                    this.ult = this.ult.getAnt();
                    this.ult.setProx(null);
                } else {
                    atual.getProx().setAnt(atual.getAnt());
                    atual.getAnt().setProx(atual.getProx());
                }
            }
        }

        this.quantNos--;
        return true;
    }

    public String toString() {

        String msg = "";
        NoDupla atual = this.prim;

        while (atual != null) {

            msg += atual.getInfo().getChave() + "\n";
            atual = atual.getProx();

        }

        return msg;

    }

    public NoDupla concatenar(ListaDupla lista2) {
        if (eVazia() || lista2.eVazia()) {
            return null;
        }

        ult.setProx(lista2.prim);
        lista2.prim.setAnt(ult);

        // Atualizar o ponteiro "último" da lista concatenada
        ult = lista2.ult;

        // Atualizar a quantidade de nós da lista concatenada
        quantNos += lista2.quantNos;

        // Esvaziar a segunda lista
        lista2.setPrim(null);
        lista2.setUlt(null);
        lista2.setQuantNos(0);

        return prim;
    }

}
