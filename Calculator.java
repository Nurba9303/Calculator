import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Калькулятор умеет выполнять операции: +, -, *, /");
            System.out.println("Введите выражение (например, 2 + 3):");

            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат ввода");
            }

            int a = Integer.parseInt(parts[0]);
            String operator = parts[1];
            int b = Integer.parseInt(parts[2]);

            if (a < 1  a > 10  b < 1 || b > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10");
            }

            int result;
            switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Недопустимая операция: " + operator);
            }

            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неправильный формат числа");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
