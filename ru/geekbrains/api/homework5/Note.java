package ru.geekbrains.api.homework5;

public class Note {

    private String name;
    private String phoneNumber;
    
    /**
     * Конструктор, я уж сеттеры не стал делать, значения занесем сразу при создании элемента класса.
     * @param name
     * @param phoneNumber
     */
    public Note(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " " + phoneNumber;
    }

    
}
