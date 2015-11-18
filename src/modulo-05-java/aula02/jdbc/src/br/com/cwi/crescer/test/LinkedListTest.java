package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;


public class LinkedListTest {

    @Test
    public void adicionarPrimeiroNaLista() {
        LinkedList likedList = new LinkedList();
        likedList.addFirst("primeiro");
        assertEquals(likedList.getFirst(), "primeiro");
        assertEquals(likedList.getLast(), "primeiro");
    }

}
