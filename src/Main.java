import java.util.Scanner;

class MyProgram {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String[] arr =input.split(" ");
        if (arr.length != 3)
            throw new Exception("Неверная форма выражения");
        String a = arr[0], b = arr[2], op = arr[1];
        int num1, num2, romanNum1 = -1, romanNum2 = -1, resultRoman, test1 = -1, test2 = -1;
        String result;

        String [] roman = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        if (Character.isDigit(a.charAt(0)) && Character.isDigit(b.charAt(0))) {
            num1 = Integer.parseInt(a);
            num2 = Integer.parseInt(b);
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10)
                throw new Exception("Введены неверные значения");
            else {
                switch (op) {
                    case "+":
                        result = Integer.toString(num1 + num2);
                        break;
                    case "-":
                        result = Integer.toString(num1 - num2);
                        break;
                    case "/":
                        result = Integer.toString(num1 / num2);
                        break;
                    case "*":
                        result = Integer.toString(num1 * num2);
                        break;
                    default:
                        throw new Exception("Нет верной операции");
                }
            }
        } else if ((Character.isDigit(a.charAt(0)) && Character.isLetter(b.charAt(0))) || (Character.isLetter(a.charAt(0)) && Character.isDigit(b.charAt(0))))
            throw new Exception ("Введены неверные значения");
        else {
            for (int i = 0; i<roman.length; i++) {
                if (a.equals(roman[i])) {
                    romanNum1 = i + 1;
                    test1 = 1;
                }
                if (b.equals(roman[i])) {
                    romanNum2 = i + 1;
                    test2 = 1;
                }
            }
            if(romanNum1 > 10 || romanNum2 > 10 || test1 == -1 || test2 == -1)
                throw new Exception("Введены неверные значения");
            else {
                switch (op) {
                    case "+":
                        resultRoman = romanNum1 + romanNum2;
                        break;
                    case "-":
                        resultRoman = romanNum1 - romanNum2;
                        break;
                    case "/":
                        resultRoman = romanNum1 / romanNum2;
                        break;
                    case "*":
                        resultRoman = romanNum1 * romanNum2;
                        break;
                    default:
                        throw new Exception("Нет подходящей операции");
                }
            }
            if (resultRoman<=0)
                throw new RuntimeException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            else
                result = roman[resultRoman-1];
        }
        return result;
    }
}