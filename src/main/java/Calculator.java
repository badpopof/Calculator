public class Calculator {

    private Calculator() {
    }

    public static int calculate(int number0, String operation, int number2) throws InputException {
        int result = 0;
        switch (operation) {
            case "+":
                result = number0 + number2;
                break;
            case "-":
                result = number0 - number2;
                break;
            case "*":
                result = number0 * number2;
                break;
            case "/":
                if(number2 == 0) throw new InputException("Деление на ноль запрещено");
                result = number0 / number2;
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }

}