import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lines extends Calculation {
    public void readLine() throws IOException
    {
        System.out.println("Введите с клавиатуры выражение, которое необходимо вычислить или напишите слово \"exit\" для выхода");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String exprString = null;
            while(!(exprString = reader.readLine()).equals("exit"))
            {
                Calculation.calculate(exprString);
                if (Calculation.PlusSign == true) {
                    System.out.println("Результат: "+Calculation.cstring);
                } else
                {
                    Calculation.cstring.insert(0, '-');
                    System.out.println("Результат: "+Calculation.cstring);
                }
                Calculation.PlusSign = true;
                System.out.println("Введите другое выражение или напишите слово \"exit\" для выхода:");
                }
            }
        }