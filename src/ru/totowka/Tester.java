package ru.totowka;

public class Tester {
    /**
     * Метод для проверки работоспособности двусвязного списка.
     * @param args
     */
    public static void main(String[] args) {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(new Integer[]{1,2,3,4,5});

        /**
         * Проверка на корректный вывод данных после считывания массива.
         */
        System.out.println("\nList output:");
        list.printList();

        /**
         * Проверка на корректное удаление элемента по значению.
         */
        System.out.println("\n\nList with 3 deleted -> output:");
        list.deleteAt(3);
        list.printList();

        /**
         * Проверка на корректную вставку.
         */
        System.out.println("\n\nList with 3 inserted to 2 index -> output:");
        list.insert(3, 2);
        list.printList();

        /**
         * Проверка на корректное получение элемента в индексе.
         */
        System.out.println("\n\nElement at index 3 in list is:");
        System.out.println(list.getAt(3));

        /**
         * Проверка на корректную работу Pop'ов.
         */
        System.out.println("\nPopTail and PopHead in list -> output");
        list.popHead();
        list.popTail();
        list.printList();

        /**
         * Проверка на получение корректного размера.
         */
        System.out.println("\n\nCurrently list's size is "+list.getSize() + " elements.");
    }
}
