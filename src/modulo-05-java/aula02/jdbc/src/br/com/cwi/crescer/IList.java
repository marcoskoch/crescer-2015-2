package br.com.cwi.crescer;

import java.util.List;

public interface IList<T> {

    public void addFirst(T value);

    public T getFirst();

    public T getLast();

    public List<T> list();

    public void removeFirst();

    public void add(int index, T value);

    public void remove(int index);

    public void add(T value);

    public void addLast(T value);
}
