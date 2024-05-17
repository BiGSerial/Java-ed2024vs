package duplamente;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.ed.dados.Item;
import com.ed.duplamente.NoDupla;


public class ListaDuplaTest {

    @Test
    public void testConcatenar() {
        // Criar lista1 com elementos
        ListaDupla lista1 = new ListaDupla();
        lista1.inserirUltimo(new Item(1));
        lista1.inserirUltimo(new Item(2));

        // Criar lista2 com elementos
        ListaDupla lista2 = new ListaDupla();
        lista2.inserirUltimo(new Item(3));
        lista2.inserirUltimo(new Item(4));

        // Concatenar lista1 e lista2
        NoDupla resultado = lista1.concatenar(lista2);

        // Verificar se o resultado é o primeiro nó da lista1
        assertEquals(lista1.getPrim(), resultado);
        // Verificar se a lista1 agora tem todos os elementos da lista2 concatenados
        assertEquals(4, lista1.getQuantNos());
    }

    @Test
    public void testPartirAoMeio() {
        // Criar lista com elementos
        ListaDupla lista = new ListaDupla();
        lista.inserirUltimo(new Item(1));
        lista.inserirUltimo(new Item(2));
        lista.inserirUltimo(new Item(3));
        lista.inserirUltimo(new Item(4));

        // Partir a lista ao meio
        ListaDupla segundaMetade = lista.partirAoMeio();

        // Verificar se a lista original foi dividida corretamente
        assertEquals(2, lista.getQuantNos());
        assertEquals(2, segundaMetade.getQuantNos());
    }

    @Test
    public void testEncontrarMaiorElemento() {
        // Criar lista com elementos
        ListaDupla lista = new ListaDupla();
        lista.inserirUltimo(new Item(5));
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(3));

        // Encontrar o maior elemento
        int maiorElemento = lista.encontrarMaiorElemento();

        // Verificar se o maior elemento é o esperado
        assertEquals(10, maiorElemento);
    }

    @Test
    public void testCalcularMedia() {
        // Criar lista com elementos
        ListaDupla lista = new ListaDupla();
        lista.inserirUltimo(new Item(5));
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(15));

        // Calcular a média
        double media = lista.calcularMedia();

        // Verificar se a média é a esperada
        assertEquals(10.0, media, 0.001);
    }

    @Test
    public void testRemoverValoresZero() {
        // Criar lista com elementos, incluindo zeros
        ListaDupla lista = new ListaDupla();
        lista.inserirUltimo(new Item(5));
        lista.inserirUltimo(new Item(0));
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(0));

        // Remover valores zero da lista
        lista.removerValoresZero();

        // Verificar se os valores zero foram removidos corretamente
        assertEquals(2, lista.getQuantNos());
    }
}
