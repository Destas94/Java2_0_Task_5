import java.util.Scanner;
public class Operations extends Calculation{
    private static final Scanner scanner = new Scanner(System.in);
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ошибка при вводе операции. Попробуйте снова.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
}
