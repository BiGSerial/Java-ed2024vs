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

    @Test
    public void testToRetornarSomaDosValoresDaLista() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(20));
        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(30));
        assertEquals(70, lista.calcularSoma());
    }

    @Test
    public void testRetornarApenasPares() {
        ListaSimples lista = new ListaSimples();
        lista.inserirUltimo(new Item(1));
        lista.inserirUltimo(new Item(2));
        lista.inserirUltimo(new Item(3));
        lista.inserirUltimo(new Item(4));
        // assertEquals(17.5, lista.calcularMedia());

        int[] expected = {2, 4, 0, 0};
        int[] actual = lista.mostrarApenasPares();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void testCompararListas() {
        ListaSimples lista = new ListaSimples();
        ListaSimples lista2 = new ListaSimples();


        lista.inserirUltimo(new Item(10));
        lista.inserirUltimo(new Item(20));
        lista.inserirUltimo(new Item(14));
        lista.inserirUltimo(new Item(16));

        lista2.inserirUltimo(new Item(10));
        lista2.inserirUltimo(new Item(20));
        lista2.inserirUltimo(new Item(14));
        lista2.inserirUltimo(new Item(16));
      
        assertTrue(lista.verificarListaIdentica(lista2));

        lista2.removerN(20);

        assertFalse(lista.verificarListaIdentica(lista2));

        lista2.inserirUltimo(new Item(20));

        assertFalse(lista.verificarListaIdentica(lista2));
        

        
       
     
    }

}
