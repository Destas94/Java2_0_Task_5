import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void test1 (){
            Calculation calc = new Calculation();
        Assertions.assertSame(0, calc.valueCalc(""), "Неверное значение");
    }

}
