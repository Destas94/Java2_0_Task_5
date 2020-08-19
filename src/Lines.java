import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lines extends Calculation {
    public void readLine() //user string reader
    {
        System.out.println("Введите с клавиатуры выражение, которое необходимо вычислить или напишите слово \"exit\" для выхода");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String exprString = null;
        try {
            while (!(exprString = reader.readLine()).equals("exit")) {
                calculate(exprString);
                if (PlusSign == true) {
                    System.out.println("Результат: " + cstring);
                } else {
                    cstring.insert(0, '-');
                    System.out.println("Результат: " + cstring);
                }
                PlusSign = true;
                System.out.println("Введите новое выражение:");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException a) {
            System.out.println("ERROR!");
            System.out.println("Введите с клавиатуры выражение, которое необходимо вычислить или напишите слово \"exit\" для выхода");
            try {
                while (!(exprString = reader.readLine()).equals("exit")) {
                    calculate(exprString);
                    if (PlusSign == true) {
                        System.out.println("Результат: " + cstring);
                    } else {
                        cstring.insert(0, '-');
                        System.out.println("Результат: " + cstring);
                    }
                    PlusSign = true;
                    System.out.println("Введите другое выражение или напишите слово \"exit\" для выхода:");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}