public class Calculation {
    public static double calc(double num1, double num2, char operation){
        double result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Нет такой операции. Попробуйте ввести один из символов, например +, -, *, /.");
                result = calc(num1, num2, Operations.getOperation());
        }
        return result;
    }
}
