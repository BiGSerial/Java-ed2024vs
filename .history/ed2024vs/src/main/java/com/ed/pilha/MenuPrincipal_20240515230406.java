package com.ed.pilha;

import java.io.IOException;
import com.ed.dados.Item;s
import java.util.Scanner;

public class MenuPrincipal {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       
        System.out.println("Digite o tamanho máximo da pilha:");
        int quant = scan.nextInt();
        // Instancia uma nova pilha.
        PilhaContig pilha = new PilhaContig(quant);
        int valor;
        Item item;
        char opcao;
        do {
           
            mostrarPilha(pilha);
            opcao = menu();
            switch (opcao) {
                case '1':
                    System.out.println("Inserir um Valor na pilha\nDigite um valor:");
                    valor = scan.nextInt();
                    if (!pilha.empilhar(new Item(valor)))
                        System.out.println("Pilha está cheia");
                    break;
                case '2':
                    item = pilha.desempilhar();
                    if (item == null)
                        System.out.println("A pilha está vazia");
                    else
                        System.out.println("Elemento desempilhado: " + item.getChave());
                    break;
                case '3':
                    pilha.inverterPilha();
                    System.out.println("Pilha invertida");
                    break;
                case '4':
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
            }
            // Aguarda um momento para que o usuário possa ler a saída antes de limpar a tela
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (opcao != '4');
        System.exit(0);
    }

    public static char menu() {
        System.out.println("Escolha uma Opção:\n" +
                "1. Empilhar\n" +
                "2. Desempilhar\n" +
                "3. Inverter Pilha\n" +
                "4. Sair");
        return scan.next().charAt(0);
    }

    public static void mostrarPilha(PilhaContig pilha) {
        PilhaContig.mostrarPilha(pilha);
    }

   
}
