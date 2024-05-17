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
            System.out.println("1. Inserir elemento no final");
            System.out.println("2. Pesquisar elemento");
            System.out.println("3. Remover elemento");
            System.out.println("4. Concatenar com outra lista");
            System.out.println("5. Partir a lista ao meio");
            System.out.println("6. Encontrar o maior elemento");
            System.out.println("7. Calcular a média dos elementos");
            System.out.println("8. Remover valores iguais a zero");
            System.out.println("9. Sair");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser inserido:");
                    int valor = scan.nextInt();
                    lista.inserirUltimo(new Item(valor));
                    break;
                case 2:
                    System.out.println("Digite a chave do elemento a ser pesquisado:");
                    int chavePesquisa = scan.nextInt();
                    NoDupla encontrado = lista.pesquisarNo(chavePesquisa);
                    if (encontrado != null) {
                        System.out.println("Elemento encontrado: " + encontrado.getInfo().getChave());
                    } else {
                        System.out.println("Elemento não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Digite a chave do elemento a ser removido:");
                    int chaveRemover = scan.nextInt();
                    if (lista.removerNo(chaveRemover)) {
                        System.out.println("Elemento removido com sucesso.");
                    } else {
                        System.out.println("Elemento não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Criando outra lista para concatenar:");
                    ListaDupla outraLista = new ListaDupla();
                    for (int i = 10; i <= 15; i++) {
                        outraLista.inserirUltimo(new Item(i));
                    }
                    System.out.println("Concatenando com outra lista:");
                    lista.concatenar(outraLista);
                    break;
                case 5:
                    System.out.println("Partindo a lista ao meio:");
                    ListaDupla segundaMetade = lista.partirAoMeio();
                    System.out.println("Primeira metade:");
                    lista.mostrarLista();
                    System.out.println("Segunda metade:");
                    segundaMetade.mostrarLista();
                    break;
                case 6:
                    int maior = lista.encontrarMaiorElemento();
                    System.out.println("O maior elemento da lista é: " + maior);
                    pause
                    break;
                case 7:
                    double media = lista.calcularMedia();
                    System.out.println("A média dos elementos da lista é: " + media);
                    break;
                case 8:
                    lista.removerValoresZero();
                    break;
                case 9:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
