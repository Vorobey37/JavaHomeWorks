package ru.geekbrains.api.homework5;

public class homework5 {
    
    public static void main(String[] args) {
        
        task();

    }

    /**
     * Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
     * В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
     * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
     * тогда при запросе такой фамилии должны выводиться все телефоны.
     * ***Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
     * взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.
     */
    public static void task(){

        Note note1 = new Note("Иванов", "8 921 254 54 65");
        Note note2 = new Note("Петров", "+7-911-222-58-85");
        Note note3 = new Note("Сидоров", "89316889878");
        Note note4 = new Note("Иванов", "54-86-95");
        Note note5 = new Note("Иванов", "8(8202)5667912");
        Note note6 = new Note("Петров", "8-921-254-00-01");
        Note note7 = new Note("Смирнов", "+7 964 782 13 26");

        PhoneBook book = new PhoneBook();
        book.add(note1);
        book.add(note2);
        book.add(note3);
        book.add(note4);
        book.add(note5);
        book.add(note6);
        book.add(note7);

        book.get("Иванов");
        book.get("Петров");
        book.get("Сидоров");
        book.get("Варежкин");

    }
}