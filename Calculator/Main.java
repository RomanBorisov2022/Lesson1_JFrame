package Calculator;

import java.util.Scanner;

import static Calculator.Calculator.divide;
import static Calculator.Calculator.sum;
import static Calculator.Calculator.multiply;
import static Calculator.Calculator.subtract;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueCalculations = true;

        while (continueCalculations) {
            System.out.println("Введите первое число:");
            double num1 = scanner.nextDouble();

            System.out.println("Введите второе число:");
            double num2 = scanner.nextDouble();

            System.out.println("Выберите операцию:");
            System.out.println("1. Сложение");
            System.out.println("2. Умножение");
            System.out.println("3. Деление");
            System.out.println("4. Вычитание");
            System.out.println("5. Завершить работу");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Результат сложения: " + sum(num1, num2));
                    break;
                case 2:
                    System.out.println("Результат умножения: " + multiply(num1, num2));
                    break;
                case 3:
                    try {
                        System.out.println("Результат деления: " + divide(num1, num2));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Результат вычитания: " + subtract(num1, num2));
                    break;
                case 5:
                    continueCalculations = false;
                    break;
                default:
                    System.out.println("Некорректный выбор операции.");
            }
        }

        System.out.println("Работа программы завершена.");
        scanner.close();
    }
}
