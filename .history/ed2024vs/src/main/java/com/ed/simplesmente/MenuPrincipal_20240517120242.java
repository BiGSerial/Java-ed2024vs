package com.ed.simplesmente;

import java.io.IOException;
import java.util.Scanner;

import com.ed.dados.Item;

public class MenuPrincipal {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // instancia a lista vazia
        ListaSimples lista = new ListaSimples();
        char opcao;
        int valor;
        Item item;
        do {
            limparTerminal();
            exibirLista(lista);
            System.out.println("Escolha uma opção:\n"
                    + "1. Inserir nó no final da lista\n"
                    + "2. Pesquisar se um determinado valor está na lista\n"
                    + "3. Remover um determinado nó da lista\n"
                    + "4. Sair do programa\n"
                    + "5. Mostrar a lista");
            opcao = scan.next().charAt(0);
            switch (opcao) {
                case '1':
                    System.out.println("Digite um valor inteiro:");
                    valor = scan.nextInt();
                    item = new Item(valor);
                    lista.inserirUltimo(item);
                   
                    break;
                case '2':
                    System.out.println("Digite o valor inteiro a ser procurado na lista:");
                    valor = scan.nextInt();
                    if (lista.pesquisarNo(valor) != null) {
                        System.out.println("O valor está na lista");
                    } else {
                        System.out.println("O valor não está na lista");
                    }
                    pausa();
                    break;
                case '3':
                    System.out.println("Digite o valor inteiro a ser removido da lista:");
                    valor = scan.nextInt();
                    if (lista.removerN(valor)) {
                        System.out.println("O valor foi removido com sucesso!");
                    } else {
                        System.out.println("O valor não está na lista");
                    }
                    pausa();
                    break;
                case '4':
                    System.out.println("Fim");
                    break;
                case '5':
                    exibirLista(lista);
                    pausa();
                    break;
                default:
                    System.out.println("Opção inválida");
                    pausa();
            }
        } while (opcao != '4');
    }

    public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pausa() {
        System.out.println("Pressione Enter para continuar...");
        scan.nextLine();
        scan.nextLine();
    }

    public static void exibirLista(ListaSimples lista) {
        limparTerminal();
        System.out.println("Mostrar a lista:\n" + lista.toString());
    }
}
