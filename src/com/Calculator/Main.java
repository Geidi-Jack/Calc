package com.Calculator;

import java.util.Scanner;

import static com.Calculator.Utils.*;
import static com.Calculator.Utils.Roman.getResult;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример для вычисления (допустим ввод двух целых чисел от 1 до 10 включительно, римские или арабские цифры, возможные операции +, -, *, /):");
        String wholeInput = in.nextLine().replaceAll("\\s", "");
        String operator = operatorDetector(wholeInput);
        String firstOperand = wholeInput.substring(0, wholeInput.indexOf(operator));
        String secondOperand = wholeInput.substring(wholeInput.indexOf(operator) + 1);
// TODO: 01.07.2022 добавить проверку на 3 операции
        if (getNumberType(firstOperand) == 3 || getNumberType(secondOperand) == 3 )
            throw new IllegalStateException("Вы ввели недопустимое число, возможен только ввод римских или арабских цифр от 1 до 10");

        if (getNumberType(firstOperand) == 1 && getNumberType(secondOperand) == 1)
            System.out.println("Результат: " + getResult(Integer.parseInt(firstOperand), Integer.parseInt(secondOperand), operator));

        if (getNumberType(firstOperand) == 2 && getNumberType(secondOperand) == 2) {
            int num1 = romanToArabic(firstOperand);
            int num2 = romanToArabic(secondOperand);
            var testResult = getResult(num1, num2, operator);
            var convert = arabicToRoman(testResult);
            System.out.println("Результат: " + arabicToRoman(getResult(num1, num2, operator)));
        }
    }
}
