package ru.geekbrains.api.homework1;

import java.util.Scanner;

public class homework1 {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        run();
        
    }

    /**
     * общий метод выполнения задания №1
     */
    public static void task1() {

        System.out.println("\nВычислить n-ое треугольное число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)");
        System.out.println("\nВведите число n:");

        int n = getInt();
        int sum = sum(n);
        long factorial = factorial(n);

        System.out.printf("\nn-ое треугольное число равно: %d, n!: равно %d\n", sum, factorial);
        System.out.println();

    }

    /** метод для получения числа int для первого задания
     * @return
     */
    public static int getInt(){
        int result = 0;
        boolean flag = true;
        while(flag){
            try {
                result = Integer.parseInt(scan.nextLine());
                if(result <= 0){
                    System.out.println("\nПо условиям задачи, число должно быть от 1, ещё раз:");
                    continue;
                }
                return result;
            } catch (Exception e) {
                System.out.println("\nНеверный формат ввода, ещё раз:");
            }
        }
        return result;
    }

    /**
     * метод для подсчета суммы чисел, идущих подряд от 1 до заданного числа
     * @param number - заданное число
     * @return сумму чисел от 1 до n
     */
    public static int sum(int number){
        int result = 0;
        for (int i = 1; i < number + 1; i++) {
            result += i;            
        }
        return result;
    }

    /**
     * метод для подсчета произведения чисел, идущих подряд от 1 до заданного числа
     * @param number - заданное число
     * @return произведение чисел от 1 до n 
     */
    public static long factorial(int number){
        long result = 1;
        for (int i = 1; i < number + 1; i++) {
            result *= i;            
        }
        return result;
    }

    /**
     * метод для выполнения задания №2
     */
    public static void task2(){
        System.out.println("\nВывести все простые числа от 1 до 1000\n");
        int count = 0;
        for(int i = 1; i <= 1000; i++){
            for(int j = 1; j <= i; j++){
                if (i%j == 0)
                {
                    count++;
                }
            }

            if (count <= 2 )
            {
                System.out.print(i + " ");
            }

            count = 0;
        }
        System.out.println("\n");

    }

    /**
     * метод для ввода числа для калькулятора
     * @return число типа double
     */
    public static double getDouble(){
        double result = 0;
        boolean flag = true;
        while(flag){
            try {
                result = Double.parseDouble(scan.nextLine());
                return result;
            } catch (Exception e) {
                System.out.println("\nНеверный формат ввода, ещё раз:");
            }
        }
        return result;
    }

    /**
     * метод для выполнения задания №3
     */
    public static void task3(){

        System.out.println("\nРеализовать простой калькулятор");

        System.out.println("\nВведите первое число:");
        double firstNumber = getDouble();

        System.out.println("\nВведите второе число:");
        double secondNumber = getDouble();
        
        System.out.println("\nВведите действие (+, -, *, /):");
        boolean f3 = true;
        while(f3){
            String operation = scan.nextLine();
            switch (operation) {
                case "+":
                    System.out.println("\nОтвет:");
                    System.out.println(firstNumber + secondNumber);
                    System.out.println();
                    f3 = false;
                    break;
                
                case "-":
                    System.out.println("\nОтвет:");
                    System.out.println(firstNumber - secondNumber);
                    System.out.println();
                    f3 = false;
                    break;

                case "*":
                    System.out.println("\nОтвет:");
                    double result = firstNumber * secondNumber;
                    System.out.println(result);
                    System.out.println();
                    f3 = false;
                    break;
                
                case "/":
                    if (secondNumber == 0) {
                        System.out.println("\nОтвет:");
                        System.out.println("На ноль делить нельзя!");
                    } else {
                        System.out.println("\nОтвет:");
                        result = firstNumber / secondNumber;
                        System.out.println(result);                       
                    }
                    System.out.println();
                    f3 = false;
                    break;    
                
                default:
                    System.out.println("Такой операции нет, ещё раз:");
                    break;
            }
            
        }

    }

    /**
     * метод для выполнения задания №4
     */
    public static void task4(){
        System.out.println("\nЗадано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут\n" +
                            "быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется восстановить\n" +
                            "выражение до верного равенства. Предложить решение или сообщить, что его нет.\n");
        int count = 0;
        for (int index = 0; index < 10; index++) {
            if(20 + index + index*10 + 5 == 69){
                System.out.println("Ответ: ? = " + index);
                count++;
            }           
        }
        if (count == 0) {
                System.out.println("Такого решения нет!\n");
            }                             
    }

    /**
     * метод для запроса продолжения или выхода
     * @return true или false
     */
    public static boolean askForCheck(){

        System.out.println("Продолжить проверку заданий? ");
        System.out.println("1 - продолжить");
        System.out.println("2 - выход из приложения");
        boolean f1 = true;
        while (f1) {
            String text = scan.nextLine();
            switch(text){                        
                case "1":
                    f1 = false;                    
                    return true;

                case "2":
                    f1 = false;
                    return false;

                default:
                    System.out.println("Вы указали некорректный номер задачи!\nПовторите попытку ввода.");
                    break;
            }
        }
        return true;
    }

    /**
     * метод, который запускает консольное приложение.
     */
    public static void run(){
        boolean f = true;
        while(f){
            System.out.println("Введите номер задачи:");
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("4 - Задача 4");
            System.out.println("0 - Завершение работы приложения");
            String number = scan.nextLine();

            switch(number){
                case "1":
                    task1();
                    f = askForCheck();
                    break;

                case "2":
                    task2();
                    f = askForCheck();
                    break;

                case "3":
                    task3();
                    f = askForCheck();    
                    break;
                
                case "4":
                    task4();
                    f = askForCheck();    
                    break;

                case "0":
                    System.out.println("Завершение работы приложения...");
                    f = false;
                    break;
                
                default:
                    System.out.println("\nВы указали некорректный номер задачи!\nПовторите попытку ввода.");
                break;

            }
        }
    }
}