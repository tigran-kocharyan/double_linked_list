package ru.totowka;

/**
 * Обобщенный класс, который использует обобщенный интерфейс и хранящий обобщенные Node'ы.
 * @param <T>
 */
public class DoubleLinkedList<T> implements IDoubleListable<T> {
    Node head;
    Node tail;
    int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DoubleLinkedList(T[] array) {
        for (T element : array) {
            pushTail(element);
        }
    }

    /**
     * Свойство получение размера списка.
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Метод для получения значения в определенной Node'е.
     * @param index
     * @return
     */
    @Override
    public T getAt(int index) {
        if(head == null) {
            throw new IllegalArgumentException ("Empty list:(");
        }
        if(index > 0 || index < size) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNext();
            }
            return (T)node.getInfo();
        }
        throw new IllegalArgumentException("Illegal index :(");
    }

    /**
     * Метод для вставки Node'ы со значением в начало списка.
     * Также происходит проверка на наличие начало и конца.
     * @param element
     */
    @Override
    public void pushHead(T element) {
        Node node = new Node<T>(null, this.head, element);
        if (head != null) {
            if (element != null) {
                head = node;
            } else {
                throw new NullPointerException();
            }
        } else {
            head = node;
        }
        size++;
    }

    /**
     * Метод для вставки Node'ы со значением в конец списка.
     * Также происходит проверка на наличие начало и конца.
     * @param element
     */
    @Override
    public void pushTail(T element) {
        Node node = new Node<T>(this.tail, null, element);
        if (head != null) {
            if (element != null) {
                tail = node;
            } else {
                throw new NullPointerException();
            }
        } else {
            head = node;
            tail = node;
        }
        size++;
    }

    /**
     * Метод для удаления Node'ы начала с проверкой на ее наличие.
     */
    @Override
    public void popHead() {
        if(head == null){
            throw new NullPointerException("There is no head :(");
        }
        head.getNext().setPrevious(null);
        head = head.getNext();
        size--;
    }

    /**
     * Метод для удаления Node'ы конца с проверкой на ее наличие.
     */
    @Override
    public void popTail() {
        if(tail == null){
            throw new NullPointerException("There is no tail :(");
        }
        tail.getPrevious().setNext(null);
        tail = tail.getPrevious();
        size--;
    }

    /**
     * Метод для вставки Node'ы со значением element по индексу index.
     * Также происходит проверка на корректность введенного index.
     * @param element
     * @param index
     */
    @Override
    public void insert(T element, int index) {
        if(index == size) {
            pushTail(element);
        } else if(index == 0) {
            pushHead(element);
        } else if(index < size && index > 0) {
            Node node = head;
            for (int i=0;i<index-1;i++) {
                node = node.getNext();
            }
            Node temp = new Node(node, node.getNext(),element);
            size++;
        } else {
            throw new IllegalArgumentException("Index should be >= 0 and <= size-1!");
        }

    }

    /**
     * Метод для поиска конкретного значения во всех Node'ах. В случае наличия, Node'а удаляется.
     * @param element
     */
    @Override
    public void deleteAt(T element) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if(node.getInfo().equals(element)){
                node.getPrevious().setNext(node.getNext());
                node.getNext().setPrevious(node.getPrevious());
                size--;
                return;
            }
            node = node.getNext();
        }
        throw new IllegalArgumentException("There is no element like this in the list :(");
    }

    /**
     * Проверка на наличие в списке Node'ы со значением element.
     * @param element
     * @return
     */
    @Override
    public boolean contains(T element) {
        if(head == null) {
            throw new IllegalArgumentException
                    ("There is no such element in list cause its emptiness :(");
        }
        Node node = head;
        for (int i = 0; i < size; i++) {
            if(head.getInfo().equals(element)){
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    /**
     * Метод для полного удаления списка.
     */
    @Override
    public void deleteAll() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Методя для вывода в консоль значений всех Node по порядку из хранения в списке.
     */
    public void printList() {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            System.out.print(node.getInfo() + " ");
            node = node.getNext();
        }
    }
}
