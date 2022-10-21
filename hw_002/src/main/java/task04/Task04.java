/*
    К калькулятору из предыдущего дз добавить логирование.

    На вход поолучаем строку с простыой операцией,
    между цифровыми значениями и знаком операции должен быть пробел.
    Считаем введенные данные валидными, проверку верности данных и
    математическое соответствие не проводим

 */

package task04;

import java.util.Scanner;
import java.util.logging.Logger;

public class Task04 {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();

        clearScreen();

        String calcStr = readStrConsole("Введите строку расчета: ");
        logger.info(calculate(calcStr));
    }

    // очистка терминала
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // получение строкового значения с консоли
    public static String readStrConsole(String message){
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    // расчет строкового выражения
    public static String calculate(String operation){
        String[] calc = operation.split(" ");

        float op1 = Float.parseFloat(calc[0]);
        float op2 = Float.parseFloat(calc[2]);
        float result = 0;

        switch (calc[1]){
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                result = op1 / op2;
                break;
        }

        return operation + " = " + result;
    }
}
