package com.ed.duplamente;

import java.util.Scanner;

import com.ed.dados.Item;

public class PrincipaListaDupla {
    static Scanner scan = new Scanner(System.in);
    static ListaDupla lista = new ListaDupla();

    public static void main(String[] args) {
        int opcao;
        do {
            limparTela();
            lista.mostrarLista();
            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Remover elemento");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Sair");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser inserido:");
                    int valor = scan.nextInt();
                    lista.inserirUltimo(new Item(valor));
                    break;
                case 2:
                    System.out.println("Digite o valor a ser removido:");
                    int chave = scan.nextInt();
                    if (lista.removerNo(chave)) {
                        System.out.println("Elemento removido com sucesso.");
                    } else {
                        System.out.println("Elemento não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Conteúdo da lista:");
                    lista.mostrarLista();
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            pausa();
        } while (opcao != 4);
    }

    public static void limparTela() {
        for (int i = 0; i < 50; ++i)
            System.out.println();
    }

    public static void pausa() {
        System.out.println("Pressione Enter para continuar...");
        scan.nextLine();
        scan.nextLine();
    }
}
