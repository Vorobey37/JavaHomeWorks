package ru.geekbrains.api.homework6;

import java.util.HashSet;

public class homework6 {
    
    public static void main(String[] args) {
        
        task();

    }

    /**
     * Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>. Поместите в него некоторое количество объектов.
     * Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество. Убедитесь, что все они сохранились во множество.
     * Создайте метод public boolean equals(Object o). Пропишите в нём логику сравнения котов по параметрам, хранимым в полях.
     * То есть, метод должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
     * Создайте метод public int hashCode(). который будет возвращать hash, вычисленный на основе полей класса Cat. 
     * (Можно использовать Objects.hash(...)). Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.
     */
    public static void task(){

        Cat cat1 = new Cat("Барсик", 2, "рыжий", true);
        Cat cat2 = new Cat("Мурзик", 3, "черный", true);
        Cat cat3 = new Cat("Маруся", 1, "серый", false);
        Cat cat4 = new Cat("Барсик", 2, "рыжий", true);
        Cat cat5 = new Cat("Мурзик", 3, "черный", true);

        HashSet<Cat> cats = new HashSet<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);

        System.out.println(cats);
        System.out.println(cat1.equals(cat2));
        System.out.println(cat1.equals(cat4));
    }
}
