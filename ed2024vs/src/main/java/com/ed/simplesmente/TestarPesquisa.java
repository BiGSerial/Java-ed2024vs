package com.ed.simplesmente;

import java.util.Scanner;

import com.ed.dados.Item;

public class TestarPesquisa {

	public static void main(String[] args) {
		ListaSimples lista = new ListaSimples();
		int valor;
		Scanner scan = new Scanner(System.in);
		
		lista.inserirUltimo(new Item(10));
		lista.inserirUltimo(new Item(20));
		lista.inserirUltimo(new Item(30));
		lista.inserirUltimo(new Item(40));
		System.out.println("lista antes:\n"+lista.toString());
		
		System.out.println("digite o valor a ser pesquisado:");
		valor = scan.nextInt();
		if (lista.pesquisarNo(valor)!= null) {
			System.out.println("achou");
		}else {
			System.out.println("n�o achou o valor");
		}
		
		System.out.println("lista depois da pesquisa:\n"+lista.toString());
		

	}

}
