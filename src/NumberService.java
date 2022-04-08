import java.util.Map;
import java.util.TreeMap;

class NumberAction {

    private final static TreeMap < Integer, String > romanNumber = new TreeMap<>();

    static {
        romanNumber.put(1, "I");
        romanNumber.put(4, "IV");
        romanNumber.put(5, "V");
        romanNumber.put(9, "IX");
        romanNumber.put(10, "X");
        romanNumber.put(40, "XL");
        romanNumber.put(50, "L");
        romanNumber.put(90, "XC");
        romanNumber.put(100, "C");
    }

    static Number parseAndValidate(String symbol) throws Exception {

        int value;
        NumberType type;

        try {
            value = Integer.parseInt(symbol);
            type = NumberType.ARABIAN;
        }catch (NumberFormatException e) {
            value = toArabicNumber(symbol);
            type = NumberType.ROMANIAN;
        }

        if (value < 1 || value > 10) {
            throw new Exception("Необходимы числа от 1 до 10");
        }

        return new Number(value, type);
    }

    static Number parseAndValidate(String symbol, NumberType type) throws Exception {

        Number number = parseAndValidate(symbol);
        if (number.getType() != type) {
            throw new Exception("Тип числа не совпадает,нужен одинаковый тип");
        }

        return number;
    }

    private static int letterToNumber(char letter) {

        int result = -1;

        for (Map.Entry < Integer, String > entry: romanNumber.entrySet()) {
            if (entry.getValue().equals(String.valueOf(letter))) result = entry.getKey();
        }
        return result;
    }

    static String toRomanNumber(int number) {

        int i = romanNumber.floorKey(number);

        if (number == i) {
            return romanNumber.get(number);
        }
        return romanNumber.get(i) + toRomanNumber(number - i);
    }

    static int toArabicNumber(String roman) throws Exception {
        int result = 0;

        int i = 0;
        while (i < roman.length()) {
            char letter = roman.charAt(i);
            int num = letterToNumber(letter);

            if (num < 0) throw new Exception("Неверное римское число");

            i++;
            if (i == roman.length()) {
                result += num;
            }else {
                int nextNum = letterToNumber(roman.charAt(i));
                if(nextNum > num) {
                    result += (nextNum - num);
                    i++;
                }
                else result += num;
            }
        }
        return result;
    }
}