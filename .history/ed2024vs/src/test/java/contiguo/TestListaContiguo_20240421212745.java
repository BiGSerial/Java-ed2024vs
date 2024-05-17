package contiguo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ed.contiguo.ListaContiguo;
import com.ed.dados.Item;

public class TestListaContiguo {

    @Test
    public void testInserirUltimo() {
        ListaContiguo lista = new ListaContiguo(5);
        assertTrue(lista.eVazia());

        assertTrue(lista.inserirUltimo(new Item(1)));
        assertFalse(lista.eVazia());
        assertEquals(1, lista.getFim());

        assertTrue(lista.inserirUltimo(new Item(2)));
        assertEquals(2, lista.getFim());

        // Teste inserção em uma lista cheia
        assertTrue(lista.inserirUltimo(new Item(3)));
        assertTrue(lista.inserirUltimo(new Item(4)));
        assertTrue(lista.inserirUltimo(new Item(5)));
        assertFalse(lista.inserirUltimo(new Item(6))); // Lista cheia, não pode inserir
    }

    @Test
    public void testRemoverNo() {
        ListaContiguo lista = new ListaContiguo(5);

        // Adiciona alguns itens.
        lista.inserirUltimo(new Item(1));
        lista.inserirUltimo(new Item(2));
        lista.inserirUltimo(new Item(3));

        assertTrue(lista.removerNo(2)); // Remove o item com chave 2
        assertEquals(2, lista.getFim());
        assertFalse(lista.removerNo(4)); // Tenta remover um item que não existe
        assertTrue(lista.removerNo(1)); // Remove o primeiro item
        assertTrue(lista.removerNo(3)); // Remove o último item
        assertTrue(lista.eVazia()); // A lista deve estar vazia agora
    }

    @Test
    public void testPesquisarNo() {
        ListaContiguo lista = new ListaContiguo(5);

        // Adiciona alguns itens à lista
        lista.inserirUltimo(new Item(1));
        lista.inserirUltimo(new Item(2));
        lista.inserirUltimo(new Item(3));
        lista.inserirUltimo(new Item(4));

        // Pesquisa por itens existentes na lista
        assertEquals(0, lista.pesquisarNo(1)); // Item na primeira posição
        assertEquals(2, lista.pesquisarNo(3)); // Item na terceira posição
        assertEquals(3, lista.pesquisarNo(4)); // Item na última posição

        // Pesquisa por item que não existe na lista
        assertEquals(4, lista.pesquisarNo(5)); // Item não existe na lista, retorna o fim da lista
    }

    @Test
    public void testInserirAposElemento() {
        // Criar uma lista com elementos
        ListaContiguo lista = new ListaContiguo(10);
        lista.inserirUltimo(new Item(1));
        lista.inserirUltimo(new Item(3));
        lista.inserirUltimo(new Item(5));

        // Testar inserção após elemento existente
        assertEquals(1, lista.inserirAposElemento(3, 4)); // Inserir 4 após o 3
        assertEquals(4, lista.getInfo(2).getChave()); // Verificar se 4 foi inserido corretamente

        // Popula a lista
        lista.inserirUltimo(new Item(11));
        lista.inserirUltimo(new Item(7));
        lista.inserirUltimo(new Item(8));
        lista.inserirUltimo(new Item(9));
        lista.inserirUltimo(new Item(10));

        // Testar inserção em lista cheia
        assertEquals(-1, lista.inserirAposElemento(3, 6)); // Tentar inserir 6 após o 3 em uma lista cheia

        // Testar inserção após elemento não encontrado
        assertEquals(-2, lista.inserirAposElemento(2, 7)); // Tentar inserir 7 após o 2, que não existe na lista
    }

   public void testEncontrarPosicao() {
        // Criar Lista
        ListaContiguo lista = new ListaContiguo(5);

        // Popula a lista
        lista.inserirUltimo(new Item(11));
        lista.inserirUltimo(new Item(7));
        lista.inserirUltimo(new Item(8));
        lista.inserirUltimo(new Item(9));
        lista.inserirUltimo(new Item(10));

        assertEquals(2, lista.encontrarPosicao(8));
        assertEquals(-1, lista.encontrarPosicao(3));
    }

    @Test
    public void testRemoverElemento() {
        // Criar Lista
        ListaContiguo lista = new ListaContiguo(5);

        // Popula a lista
        lista.inserirUltimo(new Item(11));
        lista.inserirUltimo(new Item(7));
        lista.inserirUltimo(new Item(8));
        lista.inserirUltimo(new Item(9));
        lista.inserirUltimo(new Item(10));

        assertEquals(1, lista.removerElemento(8));
        assertEquals(-1, lista.removerElemento(3));
    }

}
