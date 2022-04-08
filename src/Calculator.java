import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Input: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                exitCalc();
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Ошибка");

                Number firstNumber = NumberAction.parseAndValidate(symbols[0]);
                Number secondNumber = NumberAction.parseAndValidate(symbols[2], firstNumber.getType());
                String result = CalcOperations.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        scanner.close();
    }

    private static void startCalc() {
        System.out.println("Введите число и знак нужной вам операции");
        System.out.println("Сложение(+), Вычитание(-), Умножение(*), Деление(/)");
        System.out.println("Для выхода введите 'exit'");
    }

    private static void exitCalc() {

        System.out.println("Всего доброго");

    }
}