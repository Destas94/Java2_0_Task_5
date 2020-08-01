import java.util.Scanner;

public class Number extends Calculation{
    private static final Scanner scanner = new Scanner(System.in);
    public static double getDub(){
        System.out.println("Введите число:");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Ошибка при вводе числа. Попробуйте снова.");
            scanner.next();
            num = getDub();
        }
        return num;
    }
}
