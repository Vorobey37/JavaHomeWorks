package ru.geekbrains.api.homework4;



import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class homework4 {

    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {

        run();
    
    }

    /**
     * Пусть дан LinkedList с несколькими элементами. 
     * Реализуйте метод, который вернет “перевернутый” список.
     */
    public static void task1(){

        System.out.println();
        System.out.println("Дан следующий произвольный список: ");
        LinkedList <Integer> arrayList = makeArrayList();
        System.out.println(arrayList);
        System.out.println();
        for (int i = arrayList.size()-1; i >= 0; i--) {
            int reverseElement = arrayList.remove(i);
            arrayList.add(reverseElement);
        }
        System.out.println("Перевернутый список: ");
        System.out.println(arrayList);

    }

    /**
     * Реализуйте очередь с помощью LinkedList со следующими методами:
     * enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его,
     * first() - возвращает первый элемент из очереди, не удаляя.
     */
    public static void task2(){

        String text1 = "первое слово";
        String text2 = "второе слово";
        String text3 = "третье слово";
        String text4 = "четвертое слово";
        String text5 = "пятое слово";

        LinkedList<String> stringList = new LinkedList<>();
        stringList.add(text1);
        stringList.add(text2);
        stringList.add(text3);
        stringList.add(text4);
        stringList.add(text5);

        System.out.println();
        System.out.println("Пусть дан список: ");
        System.out.println(stringList);
        
        Queue<String> stringQueue = new Queue<>(stringList);

        stringQueue.enqueue();
        System.out.println();
        System.out.println("Перемещаем элемент в конец очереди...");
        System.out.println("Измененный список будет: ");
        System.out.println(stringList);

        System.out.println();
        System.out.println("Возвращаем первый элемент из очереди и удаляем его:");
        System.out.println(stringQueue.dequeue());
        System.out.println("Измененный список будет: ");
        System.out.println(stringList);

        System.out.println();
        System.out.println("Первый элемент списка: ");
        System.out.println(stringQueue.first());
        System.out.println("Список при этом не изменился: ");
        System.out.println(stringList);

    }

    /**
     * В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.
     */
    public static void task3(){

        Stack<Double> saveResult = new Stack<>();

        boolean flag = true;

        System.out.println("\nВведите первое число:");
        double result = getDouble();

        while (flag) {
            
            System.out.println("\nВведите второе число:");
            double secondNumber = getDouble();
        
            System.out.println("\nВведите действие (+, -, *, /):");
            boolean f3 = true;
            while(f3){
                String operation = scan.nextLine();
                switch (operation) {
                    case "+":
                        System.out.println("\nОтвет:");
                        result = result + secondNumber;
                        System.out.println(result);
                        saveResult.push(result);
                        System.out.println();
                        f3 = false;
                        break;
                
                    case "-":
                        System.out.println("\nОтвет:");
                        result = result - secondNumber;
                        System.out.println(result);
                        saveResult.push(result);
                        System.out.println();
                        f3 = false;
                        break;

                    case "*":
                        System.out.println("\nОтвет:");
                        result = result * secondNumber;
                        System.out.println(result);
                        saveResult.push(result);
                        System.out.println();
                        f3 = false;
                        break;
                
                    case "/":
                        if (secondNumber == 0) {
                            System.out.println("\nОтвет:");
                            System.out.println("На ноль делить нельзя!");
                        } else {
                            System.out.println("\nОтвет:");
                            result = result / secondNumber;
                            System.out.println(result);
                            saveResult.push(result);
                        }
                        System.out.println();
                        f3 = false;
                        break;    
                
                    default:
                        System.out.println("Такой операции нет, ещё раз:");
                        break;
                }
            }

            boolean calcFlag = true;
            while(calcFlag){
                System.out.println();
                System.out.println("Что делаем дальше?");
                System.out.println("1 - Продолжить считать");
                System.out.println("2 - Отменить последнее действие");
                System.out.println("3 - Выход из калькулятора");
                System.out.println();
                String number = scan.nextLine();

                switch(number){
                    case "1":
                        calcFlag = false;
                        break;

                    case "2":
                        if (saveResult.empty()){
                            System.out.println("Отменять больше нечего!");
                            break;
                        }
                        saveResult.pop();
                        System.out.println("Список результатов операций: ");
                        System.out.println(saveResult);
                        break;

                    case "3":
                        calcFlag = false;
                        flag = false;    
                        break;
                
                    default:
                        System.out.println("\nВы указали некорректный номер задачи!\nПовторите попытку ввода.");
                        break;
                }
            }

            if (saveResult.empty()){
                System.out.println("Список результатов операций пуст, поэтому: ");
                System.out.println("\nВведите первое число:");
                result = getDouble();
                continue;
            }

            result = saveResult.peek();
            System.out.println("Список результатов операций: ");
            System.out.println(saveResult);

        }
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
     * Создает произвольный связанный список целых чисел. 
     * @return список целых чисел.
     */
    public static LinkedList<Integer> makeArrayList(){

        Random rand = new Random();
        int size = rand.nextInt(21);
        LinkedList<Integer> randomList = new LinkedList<>();
        for (int i = 0; i < size; i++){
            randomList.add(rand.nextInt(-10, 11));
        }
        return randomList;
    }

    /**
     * метод для запроса продолжения или выхода
     * @return true или false
     */
    public static boolean askForCheck(){

        System.out.println();
        System.out.println("Продолжить проверку заданий? ");
        System.out.println("1 - продолжить");
        System.out.println("2 - выход из приложения");
        System.out.println();
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
            System.out.println();
            System.out.println("Введите номер задачи:");
            System.out.println("1 - Задача 1");
            System.out.println("2 - Задача 2");
            System.out.println("3 - Задача 3");
            System.out.println("0 - Завершение работы приложения");
            System.out.println();
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
