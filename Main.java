import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static class Converts {
        static String[] roman = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};

        public static int romanToInt(String s) {
            int result = 0;
            for (int i = 0; i <= 10; i++) {
                if (Objects.equals(roman[i], s)) {
                    result = i + 1;
                }
            }
            return result;


        }

        public static String intToRoman(int d) {
            String result;
            result = roman[d - 1];
            return result;
        }
    }

        public static String calc(String input) {
            String[] arr = input.split(" ");
            if (arr.length > 3) {
                throw new IllegalArgumentException();
            }
            int a;
            int b;
            boolean isRoman = false;
            try {
                a = Integer.parseInt(arr[0]);
                b = Integer.parseInt(arr[2]);
            } catch (NumberFormatException e) {
                isRoman = true;
                a = Converts.romanToInt(arr[0]);
                b = Converts.romanToInt(arr[2]);
            }
            if ((a < 1 || a > 10 || b < 1 || b > 10)) {
                throw new IllegalArgumentException();
            }
            int res = switch (arr[1]) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> a / b;
                default -> throw new IllegalArgumentException();
            };
            if (isRoman) {
                if (res < 1) {
                    throw new IllegalArgumentException();
                }
                return Converts.intToRoman(res);
            } else {
                return String.valueOf(res);
            }

        }
    }
