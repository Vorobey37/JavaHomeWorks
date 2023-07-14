package ru.geekbrains.api.homework6;

import java.util.Objects;

public class Cat {
    
    private String name;
    private int age;
    private String color;
    private boolean isOwner;
    
    public Cat(String name, int age, String color, boolean isOwner) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.isOwner = isOwner;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }
    
    public boolean isOwner() {
        return isOwner;
    }

    @Override
    public boolean equals(Object o){

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return name == cat.getName() && age == cat.getAge() && color == cat.getColor() && isOwner == cat.isOwner();       
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age, color, isOwner);
    }

    @Override
    public String toString() {
        return "Cat: name = " + name + ", age = " + age + ", color = " + color + ", isOwner = " + isOwner;
    }    
}
