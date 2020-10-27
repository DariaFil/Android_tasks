package tasks;


import java.io.IOException;
import java.util.Scanner;

public class Task04 {

    /**
     * Написать программу, которая играет с вами в угадай число.
     * Сначала программа печатает: "Введи нижную и верхнюю границы"
     * Пользователь вводит.
     * Программа проверяет, что нижняя граница меньше верхней.
     * Иначе выводит в консоль сообщение об ошибке и завершается.
     *
     * Далее программа пытается угадать какое число загадал пользователь
     * в введенном отрезке.
     * Тактика может быть любая: random, перебор, бин поиск.
     * Программа выводит своё предположение.
     * Пользователь должен ввести "yes", если программа угадал.
     * Программа завершается.
     * Иначе любое другое сообщение. Тогда программа продолжает угадывать.
     *
     * Пример:
     * Введи границы
     * 0 10
     * Это 1?
     * no
     * Это 3?
     * no
     * Это 5?
     * yes
     * Отличная игра(завершение)
     *
     */
    public static void main(String[] args) {
        System.out.println("Введите нижнюю и верхнюю границы");
        Scanner in = new Scanner(System.in);
        try {
            int low = in.nextInt();
            int up = in.nextInt();
            if (low >= up) {
                System.out.println("Введены некорректные границы");
                throw new IOException();
            }
            String ans = new String("processing");
            in.nextLine();
            while (!(ans.equals("yes"))) {
                System.out.println("Это "+low+"?");
                ans = in.nextLine();
                low += 1;
                if (low > up) {
                    System.out.println("Вы должны были загадать число. Вы обманули меня. " +
                            "Это грустно. Я больше никогда не смогу верить людям.");
                    throw new IOException();
                }
            }
            System.out.println("Отличная игра!");
        }
        catch (IOException e) {

        }
    }

}