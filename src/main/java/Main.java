import java.util.Scanner;

public class Main {
    static final String ARAB_NUMBER = "ArabNumber";
    static final String ROMAN_NUMBER = "RomanNumber";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение: ");
        String str = scanner.nextLine().trim();
        try {
            if (str.isEmpty() || str.isBlank()) throw new InputException("Пустой ввод");

            String[] words = str.split(" ", 0);

            if (words.length < 3) throw new InputException("Строка не является математической операцией");

            if (words.length > 3)
                throw new InputException("Формат математической операции не удовлетворяет заданию - два операнда и один " +
                        "оператор (+, -, /, *)");
            DefineTypeNumber definetypeNumber = new DefineTypeNumber();
            String typeNumber = definetypeNumber.checkWords(words);

            if (typeNumber.equals(ARAB_NUMBER)){
                double number0 = Double.parseDouble(words[0]);
                double number2 = Double.parseDouble(words[2]);
                if (definetypeNumber.checkInteger(number0) && definetypeNumber.checkInteger(number2))
                    throw new InputException("Не целые числа!");
                System.out.println(
                        Calculator.calculate(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2])));
            }

            if (typeNumber.equals(ROMAN_NUMBER)) {
                int number0 = ConvertNumber.romanToArabic(words[0]);
                int number2 = ConvertNumber.romanToArabic(words[2]);
                int result = Calculator.calculate(number0, words[1], number2);

                if (result < 0) throw new InputException("В римской системе нет отрицательных чисел");

                System.out.println(ConvertNumber.arabicToRoman(result));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

}
