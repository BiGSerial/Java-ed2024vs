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
                    + "4. Calcular soma dos valores da lista\n"
                    + "5. Calcular média dos valores da lista\n"
                    + "6. Mostrar apenas valores pares da lista\n"
                    + "7. Verificar se duas listas são idênticas\n"
                    + "8. Procurar e alterar valor na lista\n"
                    + "9. Procurar, inserir ou contar valor na lista\n"
                    + "10. Remover último elemento da lista\n"
                    + "11. Somar apenas valores pares e adicionar ao final da lista\n"
                    + "12. Sair do programa");
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
                    System.out.println("A soma dos valores da lista é: " + lista.calcularSoma());
                    pausa();
                    break;
                case '5':
                    System.out.println("A média dos valores da lista é: " + lista.calcularMedia());
                    pausa();
                    break;
                case '6':
                    System.out.println("Mostrando apenas os valores pares da lista:");
                    int[] pares = lista.mostrarApenasPares();
                    for (int num : pares) {
                        if (num != 0) {
                            System.out.print(num + " ");
                        }
                    }
                    System.out.println();
                    pausa();
                    break;
                case '7':
                    // Criar e preencher uma segunda lista para teste de identidade
                    ListaSimples lista2 = new ListaSimples();
                    lista2.inserirUltimo(new Item(1));
                    lista2.inserirUltimo(new Item(2));
                    lista2.inserirUltimo(new Item(3));
                    lista2.inserirUltimo(new Item(4));
                    lista2.inserirUltimo(new Item(5));
                    System.out.println("Verificando se as duas listas são idênticas...");
                    if (lista.verificarListaIdentica(lista2)) {
                        System.out.println("As listas são idênticas");
                    } else {
                        System.out.println("As listas não são idênticas");
                    }
                    pausa();
                    break;
                case '8':
                    System.out.println("Digite o valor a ser procurado:");
                    int valorProcurado = scan.nextInt();
                    System.out.println("Digite o novo valor:");
                    int novoValor = scan.nextInt();
                    int resultado = lista.procurarEAlterar(valorProcurado, novoValor);
                    if (resultado == -1) {
                        System.out.println("A lista está vazia.");
                    } else if (resultado == 0) {
                        System.out.println("Valor não encontrado. Nenhuma alteração feita na lista.");
                    } else {
                        System.out.println("Valor encontrado e alterado com sucesso.");
                    }
                    pausa();
                    break;
                case '9':
                    System.out.println("Digite o valor a ser procurado:");
                    int valorParaInserir = scan.nextInt();
                    int contador = lista.procurarInserirOuContar(valorParaInserir);
                    if (contador == 0) {
                        System.out.println("Valor inserido no final da lista.");
                    } else {
                        System.out.println("Valor encontrado " + contador + " vezes na lista.");
                    }
                    pausa();
                    break;
                case 10:
                    if (lista.removerUltimo() == 1) {
                        System.out.println("Último elemento removido com sucesso.");
                    } else {
                        System.out.println("A lista está vazia. Nada a remover.");
                    }
                    pausa();
                    break;
                case 11:
                    lista.somarApenasPares();
                    System.out.println("A soma dos valores pares foi adicionada ao final da lista.");
                    pausa();
                    break;
                case 12:
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    pausa();
            }
        } while (opcao != '12');
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
