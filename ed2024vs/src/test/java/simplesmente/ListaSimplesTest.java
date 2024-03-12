package simplesmente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ed.dados.Item;
import com.ed.simplesmente.ListaSimples;
import com.ed.simplesmente.No;

public class ListaSimplesTest {

    @Test
    public void testListaVaziaAoCriar() {
        ListaSimples lista = new ListaSimples();
        assertTrue(lista.eVazia());
    }

    @Test
    public void testListaNaoVaziaAposInserir() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(10));
        assertFalse(lista.eVazia());
    }

    @Test
    public void testInserirElementoNoFinalDaLista() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(20));
        assertEquals(20, lista.getUlt().getInfo().getChave());
    }

    @Test
    public void testTamanhoDaListaAumentaAposInserir() {
        ListaSimples lista = new ListaSimples();
        int tamanhoInicial = lista.getQuantNos();
        lista.inserirUltimo(new Item(30));
        assertEquals(tamanhoInicial + 1, lista.getQuantNos());
    }

    @Test
    public void testPesquisarNoRetornaNoComAChaveInformada() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(20));
        No noEncontrado = lista.pesquisarNo(20);
        assertNotNull(noEncontrado);
        assertEquals(20, noEncontrado.getInfo().getChave());
    }

    @Test
    public void testPesquisarNoRetornaNullSeChaveNaoEncontrada() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(10));
        No noNaoEncontrado = lista.pesquisarNo(40);
        assertNull(noNaoEncontrado);
    }

    @Test
    public void testRemoverNoRemoveNoComAChaveInformada() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(20));
        boolean removido = lista.removerNo(20);
        assertTrue(removido);
        assertEquals(1, lista.getQuantNos());
    }

    @Test
    public void testRemoverNoRetornaFalseSeChaveNaoEncontrada() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(10));
        boolean removido = lista.removerNo(50);
        assertFalse(removido);
        assertEquals(1, lista.getQuantNos());
    }

    @Test
    public void testToStringRetornaStringVaziaSeListaVazia() {
        ListaSimples listaVazia = new ListaSimples();
        assertEquals("", listaVazia.toString());
    }

    @Test
    public void testToStringRetornaStringComOsElementosDaLista() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(20));
        String strLista = lista.toString();
        assertTrue(strLista.contains("10"));
        assertTrue(strLista.contains("20"));
    }

}
