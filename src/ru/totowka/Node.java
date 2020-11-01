package ru.totowka;

/**
 * Класс, который хранит ссылку на следующий и предыдущий объект, а также
 * значение.
 * @param <T>
 */
public class Node<T> {
    private Node next;
    private Node previous;
    private T info;

    /**
     * Setter для объявления следующей Node'ы.
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Setter для объявления предыдущей Node'ы.
     * @param previous
     */
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    /**
     * Получение следующей Node'ы
     * @return
     */
    public Node getNext() {
        return next;
    }

    /**
     * Получение предыдущей Node'ы
     * @return
     */
    public Node getPrevious() {
        return previous;
    }

    /**
     * Получение значения в данной Node'е.
     * @return
     */
    public T getInfo() {
        return info;
    }

    /**
     * Конструктор, принимающий на вход ссылку следующую и предыдушую Node'ы для текущей и ее значение.
     * @param previous
     * @param next
     * @param info
     */
    public Node(Node previous, Node next, T info) {
        this.info = info;
        this.previous = previous;
        this.next = next;

        if (previous != null) {
            previous.setNext(this);
        }
        if (next != null) {
            next.setPrevious(this);
        }
    }
}
