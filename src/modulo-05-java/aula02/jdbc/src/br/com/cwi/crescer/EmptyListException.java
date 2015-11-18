package br.com.cwi.crescer;


public class EmptyListException extends Exception {

    public EmptyListException(String msg) {
        super(msg);
    }

    public EmptyListException() {
        super();
    }
}