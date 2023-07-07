package ru.geekbrains.api.homework4;

import java.util.LinkedList;
import java.util.Scanner;

public class Queue<ChooseType> {

    static Scanner input = new Scanner(System.in);

    private LinkedList<ChooseType> elements;

    /**
     * Я всё-таки решил сделать класс обобщенного типа
     * @param elements - связанный список обобщенного типа
     */
    public Queue(LinkedList<ChooseType> elements) {
        this.elements = elements;
    }

    /**
     * метод для ввода индекса элемента списка
     * @return число типа int
     */
    public int getInt(){

        int result = 0;
        boolean flag = true;
        while(flag){
            try {
                result = Integer.parseInt(input.nextLine());
                if (result < 0 || result >= elements.size()){
                    System.out.println();
                    System.out.println("Такого индекса в данном списке нет! Ещё раз: ");                   
                } else {
                return result;
                }
            } catch (Exception e) {
                System.out.println();
                System.out.println("Неверный формат ввода, ещё раз: ");
                
            }
        }
        return result;
    }

    /**
     * помещает элемент в конец очереди
     */
    public void enqueue(){

        System.out.println();
        System.out.println("Введите индекс элемента для перемещения в конец очереди: ");
        int index = getInt();
        ChooseType element = elements.remove(index);
        elements.add(element);

    }

    /**
     * возвращает первый элемент из очереди и удаляет его,
     */
    public ChooseType dequeue(){

        return elements.removeFirst();
    }

    /**
     * возвращает первый элемент из очереди, не удаляя.
     */
    public ChooseType first(){

        return elements.getFirst();

    }   
}
