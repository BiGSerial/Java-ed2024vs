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

    // Atv. 4 Questao 6
    public NoDupla concatenar(ListaDupla lista2) {
        if (eVazia() || lista2.eVazia()) {
            return null;
        }

        ult.setProx(lista2.prim);
        lista2.prim.setAnt(ult);

        ult = lista2.ult;

        quantNos += lista2.quantNos;

        lista2.setPrim(null);
        lista2.setUlt(null);
        lista2.setQuantNos(0);

        return prim;
    }

     // Atv. 4 Questao 7
    public ListaDupla partirAoMeio() {
        if (eVazia() || prim.getProx() == null) {
            return new ListaDupla();
        }

        NoDupla lento = prim;
        NoDupla rapido = prim.getProx();

        while (rapido != null && rapido.getProx() != null) {
            lento = lento.getProx();
            rapido = rapido.getProx().getProx();
        }

        ListaDupla segundaMetade = new ListaDupla();

        segundaMetade.setPrim(lento.getProx());
        segundaMetade.setUlt(ult);
        segundaMetade.setQuantNos(quantNos - getQuantNos());

        lento.setProx(null);
        ult = lento;
        setQuantNos(getQuantNos() - segundaMetade.getQuantNos());

        return segundaMetade;
    }

     // Atv. 4 Questao 8
    public int encontrarMaiorElemento() {
        if (eVazia()) {
            throw new IllegalStateException("A lista está vazia.");
        }

        int maiorElemento = prim.getInfo().getChave();

        NoDupla atual = prim.getProx();
        while (atual != null) {
            if (atual.getInfo().getChave() > maiorElemento) {
                maiorElemento = atual.getInfo().getChave();
            }
            atual = atual.getProx();
        }

        return maiorElemento;
    }

     // Atv. 4 Questao 9
    public double calcularMedia() {
        if (eVazia()) {
            throw new IllegalStateException("A lista está vazia.");
        }

        double soma = 0;
        int contador = 0;

        NoDupla atual = prim;
        while (atual != null) {
            soma += atual.getInfo().getChave();
            contador++;
            atual = atual.getProx();
        }

        return soma / contador;
    }
    
    public void removerValoresZero() {
        if (eVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }

        NoDupla atual = prim;
        while (atual != null) {
            if (atual.getInfo().getChave() == 0) {
                if (atual == prim) {
                    prim = prim.getProx();
                    if (prim != null) {
                        prim.setAnt(null);
                    }
                } else if (atual == ult) {
                    ult = ult.getAnt();
                    if (ult != null) {
                        ult.setProx(null);
                    }
                } else {
                    atual.getAnt().setProx(atual.getProx());
                    atual.getProx().setAnt(atual.getAnt());
                }
                quantNos--;
            }
            atual = atual.getProx();
        }
        if (quantNos == 0) {
            System.out.println("Não foram encontrados valores iguais a 0 na lista.");
        }
    }

}
