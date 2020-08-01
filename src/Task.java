public class Task {
    public static void main(String[] args) {
        double num1 = Number.getDub();
        double num2 = Number.getDub();
        char operation = Operations.getOperation();
        double result = Calculation.calc(num1,num2,operation);
        System.out.println("Результат: " + result);
    }
}
