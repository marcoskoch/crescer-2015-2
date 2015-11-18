package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<T> implements IList<T> {

    protected Node<T> last, first;

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first);
        if (first == null) {
            last = node;
        }
        first = node;

    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return first.getValue();
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return last.getValue();
    }

    private boolean isEmpty() {
        return first == null;
    }

    @Override
    public List<T> list() {
        ArrayList<T> lista = new ArrayList<T>();
        Node<T> node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        first = first.getNext();
    }

    @Override
    public void add(int index, T value) {
        if (index == 0) {
            this.addFirst(value);
        } else {
            Node<T> nodeAdd = new Node<T>(value);
            Node<T> contador = this.getNode(index - 1);
            nodeAdd.setNext(contador.getNext());
            contador.setNext(nodeAdd);
        }
    }

    @Override
    public void remove(int index) {
        Node<T> tmp = getNode(index - 1);
        Node<T> removido = tmp.getNext();
        tmp.setNext(removido.getNext());
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<T>(value);
        if (first == null) {
            first = node;
        }
        last.setNext(node);
        last = node;
    }

    private Node<T> getNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    protected class Node<I> {

        private I value;

        private Node<I> next;

        public Node(I value, Node<I> next) {
            this.value = value;
            this.next = next;
        }

        public Node(I value) {
            this.value = value;
        }

        public I getValue() {
            return value;
        }

        public void setValue(I value) {
            this.value = value;
        }

        public Node<I> getNext() {
            return next;
        }

        public void setNext(Node<I> next) {
            this.next = next;
        }

    }
}
