import java.util.Scanner;

public class Homework {

    public static void main(String[] args) {
        String userInput = readOut("Введите дробное число:");
        System.out.println(floaty(userInput));

        System.out.println(mirror());
    }
    public static String readOut(String msg){
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static float floaty(String input) {
        float result = 0;
        boolean flag = true;
        while (flag){
            try{
            result = Float.parseFloat(input);
            if ((Float) result instanceof Float)
                flag = false;
            } catch (Exception exc){
                exc.printStackTrace();
                System.out.println("Хм... что-то пошло не так, пробуем ещё разок");
                input = readOut("Введите дробное число: ");
            }
        }
        return result;
    }

    public static void task2(int[] intArray){
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
        // Данный метод не нуждается в правках с точки зрения синтаксиса (будет уходить в ошибку из-за деления на ноль),
        // но с точки зрения логики скорее да чем нет. можно добавить печать стэктрейса и дать возможность пользователю
        // вводить значение d. cм. метод task2Revised
    }

    public static void task2Revised(int[] intArray){
        try {
            int d = Integer.parseInt(readOut("Введите целое число: "));
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }catch (NumberFormatException nfE) {
            System.out.println("Catching exception: NumberFormat:");
            nfE.printStackTrace();
        }catch (ClassCastException ccE){
            System.out.println("Catching exception: ClassCast");
            ccE.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: Arithmetic");
            e.printStackTrace();
        }
    }

    public static void Task3a() throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }
    public static void printSum(int a, int b){
        System.out.println(a + b);
    }

    //Правки: 2 лишних catch блока, в которые программа в любом случае не уйдёт.
    // в методе принтсум заменил классы обёртки примитивами и убрал лишнее throws выражение, ибо с файлами не работаем

    public static String mirror () throws NullPointerException{
        String userInput = readOut("Введите чтто-нибудь: ");
        if (userInput.isEmpty())
            throw new NullPointerException("Нельзя вводиить пустые строки");
        return userInput;
    }
}
