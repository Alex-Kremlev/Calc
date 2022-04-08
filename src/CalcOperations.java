public class CalcOperations {
    public static String calculate(Number first, Number second, String action) throws Exception {

        int result;

        switch (action) {
            case "+":
                result = first.getValue() + second.getValue();
                break;
            case "-":
                result = first.getValue() - second.getValue();
                break;
            case "*":
                result = first.getValue() * second.getValue();
                break;
            case "/":
                result = first.getValue() / second.getValue();
                break;
            default:
                throw new Exception("Неверная операция,возможно только сложение,вычитание,умножение и деление");
        }

        if (first.getType() == NumberType.ROMANIAN) {
            return NumberAction.toRomanNumber(result);
        } else return String.valueOf(result);
    }
}

