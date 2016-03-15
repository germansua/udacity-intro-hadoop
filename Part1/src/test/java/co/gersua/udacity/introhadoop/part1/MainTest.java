package co.gersua.udacity.introhadoop.part1;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

public class MainTest {

    @Test
    public void someTest() {
        BigDecimal bd = new BigDecimal("12345678901234567890.12345678");
        System.out.println(bd.toString());

        bd = BigDecimal.ZERO;
        bd = bd.add(new BigDecimal(10.1), MathContext.DECIMAL64);
        bd = bd.add(new BigDecimal("0.1"), MathContext.DECIMAL64);

        System.out.println(bd.toString());
    }
}
