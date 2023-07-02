package ru.geekbrains.api.homework2;




import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class homework2 {
    
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        
        run();

    }

    /**
     * Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
     * Данные для фильтрации приведены ниже в виде json-строки.
     * Если значение null, то параметр не должен попадать в запрос.
     * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     */
    public static void task1(){

        System.out.println();
        StringBuilder text = new StringBuilder("select * from students where ");
        
        String textWhere = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String newTextWhere = textWhere.replace('{', ' ').replace('}', ' ')
                                        .replace('"', ' ').replace(' ', '\0');
        
        String [] resultText = newTextWhere.split(","); 
        for (int i = 0; i < resultText.length; i++) {
            String []partOfResultText = resultText[i].split(":");

            if (partOfResultText[1].equals("null")) { //почему-то эта часть кода не работает(не может сравнить с null)
                continue;
            }
            text.append(partOfResultText[0]).append(" ").append("=").append(" ")
                .append(partOfResultText[1]).append(" ").append("AND").append(" ");
            
        }
        String result = text.substring(0, text.length()-4);
        System.out.println(result);
        System.out.println();
    }

    /**
     * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
     */
    public static void task2(){

        Logger sortLogger = makeLogger("sort.txt");

        sortLogger.log(Level.INFO, "Начало логирования:");
        int[]array = makeRandomArray();
        sortLogger.log(Level.INFO, "Создаем массив случайного размера из случайных чисел:");
        sortLogger.log(Level.INFO, Arrays.toString(array));
        sortLogger.log(Level.INFO, "Приступаем к сортировке:");

        int temp = 0;
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
                sortLogger.log(Level.INFO, "Действие " + count + ": " + Arrays.toString(array));
                count++;
            }
        }
        sortLogger.log(Level.WARNING, "Сортировка окончена!!!");
        sortLogger.log(Level.INFO, "Отсортированный массив: " + Arrays.toString(array));
        System.out.println();
        
        closeHandlers(sortLogger);
                
    }

    /**
     * К калькулятору из предыдущего ДЗ добавить логирование.
     * Метод взят за основу из предыдущего домашнего, добавлено логирование
     */
    public static void task4(){

        Logger calcLogger = makeLogger("calculator.txt");
        calcLogger.log(Level.INFO, "Начало логирования:");

        System.out.println("\nВведите первое число:");
        double firstNumber = getDouble();
        calcLogger.log(Level.INFO, "Пользователь ввел первое число: " + firstNumber);


        System.out.println("\nВведите второе число:");
        double secondNumber = getDouble();
        calcLogger.log(Level.INFO, "Пользователь ввел второе число: " + secondNumber);
        
        System.out.println("\nВведите действие (+, -, *, /):");
        boolean f3 = true;
        while(f3){
            String operation = scan.nextLine();
            switch (operation) {
                case "+":
                    calcLogger.log(Level.INFO, "Производится сложение чесел:");
                    System.out.println("\nОтвет:");                    
                    System.out.println(firstNumber + secondNumber);
                    System.out.println();
                    calcLogger.log(Level.INFO, "Сложение выполнено, ответ: " + (firstNumber + secondNumber));
                    f3 = false;
                    break;
                
                case "-":
                    calcLogger.log(Level.INFO, "Производится вычитание чесел:");
                    System.out.println("\nОтвет:");
                    System.out.println(firstNumber - secondNumber);
                    System.out.println();
                    calcLogger.log(Level.INFO, "Вычитание выполнено, ответ: " + (firstNumber - secondNumber));
                    f3 = false;
                    break;

                case "*":
                    calcLogger.log(Level.INFO, "Производится умножение чесел:");
                    System.out.println("\nОтвет:");
                    double result = firstNumber * secondNumber;
                    System.out.println(result);
                    System.out.println();
                    calcLogger.log(Level.INFO, "Умножение выполнено, ответ: " + result);
                    f3 = false;
                    break;
                
                case "/":
                    calcLogger.log(Level.INFO, "Производится деление чесел:");
                    if (secondNumber == 0) {
                        System.out.println("\nОтвет:");
                        System.out.println("На ноль делить нельзя!");
                        calcLogger.log(Level.WARNING, "ОШИБКА!!! На ноль делить нельзя!");
                    } else {
                        System.out.println("\nОтвет:");
                        result = firstNumber / secondNumber;
                        System.out.println(result);
                        calcLogger.log(Level.INFO, "Деление выполнено, ответ: " + result);                       
                    }
                    System.out.println();
                    f3 = false;
                    break;    
                
                default:
                    System.out.println("Такой операции нет, ещё раз:");
                    break;
            }
            
        }
        System.out.println();

        closeHandlers(calcLogger);

    }

    /**
     * Метод закрывает хэндлеры.
     * Нужен, чтобы при выполнении других заданий файлы не дополнялись,
     * например: произошло логированние второго задания, 
     * началась проверка четвертого и логирование.
     * Чтобы в файл второго задания не логировалось четвертое задание.
     * @param logger
     */
    public static void closeHandlers(Logger logger){
        for (Handler element : logger.getHandlers()) {
            element.close();
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
     * метод создает случайный массив для второго задания
     * @return массив случайного размера из случайных чисел
     */
    public static int[] makeRandomArray(){
        Random random = new Random();
        int size = random.nextInt(21);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-20, 21);
        }
        return array;
    }

    /**
     * метод создает нужный мне логер
     * @param text - имя файла для логирования.
     * @return логер
     */
    public static Logger makeLogger(String text){

        Logger logger = Logger.getLogger(homework2.class.getName());
        
        try {
            FileHandler fh = new FileHandler(text);              
            logger.addHandler(fh);       
            SimpleFormatter sFormat = new SimpleFormatter();       
            fh.setFormatter(sFormat);
        
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return logger;
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
                    System.out.println("\nК сожалению, не успел пока сделать...\n");
                    //task3();
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
