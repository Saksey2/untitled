import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int num1;
        int num2;
        char mainOperation;
        int ans;

        Scanner userInput = new Scanner(System.in);
        System.out.println("\nВведите выражение:");

        String mainInput = userInput.nextLine();
        String[] arr = mainInput.split(" ", 3);

        String firstValue = arr[0];
        String operation = arr[1];
        String thirdValue = arr[2];
        mainOperation = operation.charAt(0);
        int operationLength = operation.length();
        if (operationLength > 1) {
            throw new IOException("Ошибка! Формат математической операции не удовлетворяет заданию. ");
        }

        if ((firstValue.contains("I") || (firstValue.contains("V")) || (firstValue.contains("X"))) &&
                ((thirdValue.contains("I") || (thirdValue.contains("V")) || (thirdValue.contains("X"))))) {
            num1 = convert(firstValue);
            num2 = convert(thirdValue);
            if ( num1 == 0 || num1 > 10 || num2 == 0 || num2 > 10) {
                throw new IOException("Ошибка! Введенные числа должны быть от I до X.");}
            ans = calculated(num1, num2, mainOperation);
            if ( ans <= 0 ) {
                throw new IOException("Ошибка! Результат не может быть отрицательным или 0."); }
            String resultRoman = NumToRoman(ans);
            System.out.println(resultRoman); System.exit(0);

        } else
            num1 = Integer.parseInt(firstValue);
        num2 = Integer.parseInt(thirdValue);
        if (num1 > 10 || num1 <= 0 || num2 <= 0 || num2>10) {
            throw new IOException("Ошибка! Введенные числа должны быть от 1 до 10.");}
        ans = calculated(num1, num2, mainOperation);
        System.out.println(ans); System.exit(0);
    }

    public static int convert(String a) {
        if (a.equals("I")) return 1;
        if (a.equals("II")) return 2;
        if (a.equals("III")) return 3;
        if (a.equals("IV")) return 4;
        if (a.equals("V")) return 5;
        if (a.equals("VI")) return 6;
        if (a.equals("VII")) return 7;
        if (a.equals("VIII")) return 8;
        if (a.equals("IX")) return 9;
        if (a.equals("X")) return 10;
        return 0;
    }


    public static int calculated(int num1, int num2, char mainOperation) throws IOException {
        int ans = 0;
        switch (mainOperation) {
            case '+' -> ans = num1 + num2;
            case '-' -> ans = num1 - num2;
            case '*' -> ans = num1 * num2;
            case '/' -> ans = num1 / num2;
            default -> throw new IOException("Ошибка! Формат математической операции не удовлетворяет заданию. ");

        }
        return ans;
    }

    private static String NumToRoman (int numArabian) {
        String[] roman = {"N", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV",
                "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
                "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI",
                "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
}