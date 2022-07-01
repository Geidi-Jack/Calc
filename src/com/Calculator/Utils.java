package com.Calculator;

public class Utils {
    public static String operatorDetector(String input) {
        String[] operatorsArray = {"+", "-", "*", "/"};

        for (String element : operatorsArray) {
            if (input.indexOf(element) != -1) {
                String foundOperator = element;
                return foundOperator;
            }
            else
                throw new IllegalArgumentException("Некорректный ввод: во введенном примере не содержится арифметический оператор или он отличается от +,-,*,/");
        }
        return input;
    }

    public static int getNumberType(String input) {
        String[] arabic = new String[]{"10", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] roman = new String[] {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
        int result = 3;
        for (String element : arabic) {
            if (input.equals(element)) {
                result = 1;
            }
        }
        for (String element : roman) {
            if (input.equals(element)) {
                result = 2;
            }
        }
        return result;
    }

    public static int romanToArabic (String romanNumber) {
        return Roman.valueOf(romanNumber).toArabic();
    }

    public static String arabicToRoman (int arabicNumber) {
//        return Roman.toRoman(arabicNumber);
        switch (arabicNumber) {
            case 10:
                return "X";
            case 9:
                return "IX";
            case 8:
                return "VIII";
            case 7:
                return "VII";
            case 6:
                return "VI";
            case 5:
                return "V";
            case 4:
                return "IV";
            case 3:
                return "III";
            case 2:
                return "II";
            case 1:
                return "I";
            default:
                throw new IllegalStateException("Unexpected value: " + arabicNumber);
        }
    }

    public enum Roman {
        I(1), II(2), III(3), IV(4),  V(5), VI(6), VII(7), VIII(8), IX(9), X(10);
        private final int value;

        private Roman(int value) {
            this.value = value;
        }

        public int toArabic() {
            return value;
        }

//        public static String toRoman(int arabic) {
//            String result = "";
//            for (Roman element : Roman.values()) {
//                if (element.value == arabic) {
//                    result = element.toString();
//                }
//            }
//            return result;
//        }

        public static int getResult(int num1, int num2, String operator) {
            switch (operator) {
                case "+":
                    return num1 + num2;

                case "-":
                    return num1 - num2;

                case "*":
                    return num1 * num2;

                case "/":
                    return num1 / num2;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
        }
    }
}
