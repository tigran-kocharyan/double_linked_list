package ru.totowka;

/**
 * Интерфейс, реализующий методы двусвязного списка.
 * @param <T>
 */
public interface IDoubleListable<T> {
    int getSize();
    T getAt(int index);
    void pushHead(T element);
    void pushTail(T element);
    void popHead();
    void popTail();
    void insert(T element, int index);
    void deleteAt(T element);
    void deleteAll();
    boolean contains(T element);
}
