package Polynomials;

import Scalars.IntegerScalar;
import Scalars.RationalScalar;
import org.junit.Test;
import static org.junit.Assert.*;

public class PolynomialTest {

    @Test
    public void build() {
        Polynomial p1 = Polynomial.build("1 2 3");
        assertEquals("1+2x+3x^2", p1.toString());

        Polynomial p2 = Polynomial.build("1/2 0 2/3");
        assertEquals("1/2+2/3x^2", p2.toString());
    }
    @Test
    public void add() {
        Polynomial p1 = Polynomial.build("1 2");
        Polynomial p2 = Polynomial.build("0 0 3");
        assertEquals("1+2x+3x^2", p1.add(p2).toString());

        Polynomial p3 = Polynomial.build("1/2 1");
        Polynomial p4 = Polynomial.build("1/2 -1");
        assertEquals("1", p3.add(p4).toString());

        Polynomial p5 = Polynomial.build("5 5");
        Polynomial p6 = Polynomial.build("-5 -5");
        assertEquals("0", p5.add(p6).toString());
    }
    @Test
    public void mul() {
        Polynomial p1 = Polynomial.build("1 2");
        Polynomial p2 = Polynomial.build("3 4");
        assertEquals("3+10x+8x^2", p1.mul(p2).toString());

        Polynomial p3 = Polynomial.build("1/2");
        Polynomial p4 = Polynomial.build("0 2");
        assertEquals("x", p3.mul(p4).toString());

        Polynomial p5 = Polynomial.build("1 2 3");
        Polynomial zero = Polynomial.build("0");
        assertEquals("0", p5.mul(zero).toString());
    }
    @Test
    public void derivative() {
        Polynomial p1 = Polynomial.build("1 2 3");
        assertEquals("2+6x", p1.derivative().toString());

        Polynomial p2 = Polynomial.build("1/2 0 3/2");
        assertEquals("3x", p2.derivative().toString());

        Polynomial pConst = Polynomial.build("10");
        assertEquals("0", pConst.derivative().toString());
    }
    @Test
    public void evaluate() {
        Polynomial p1 = Polynomial.build("1 2 3");
        assertEquals(new IntegerScalar(17), p1.evaluate(new IntegerScalar(2)));
        assertEquals(new IntegerScalar(1), p1.evaluate(new IntegerScalar(0)));

        Polynomial p2 = Polynomial.build("0 1/2");
        assertEquals(new RationalScalar(1, 4), p2.evaluate(new RationalScalar(1, 2)));
        assertEquals("1", p2.evaluate(new IntegerScalar(2)).toString());

        assertEquals(new RationalScalar(-1, 8), Polynomial.build("0 0 0 1").evaluate(new RationalScalar(-1, 2)));
    }
    @Test
    public void testEquals() {
        Polynomial p1 = Polynomial.build("1/2 2");
        Polynomial p2 = Polynomial.build("2/4 2");
        Polynomial p3 = Polynomial.build("1 2");

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
    }
    @Test
    public void testToString() {
        assertEquals("x^2", Polynomial.build("0 0 1").toString());
        assertEquals("1-x", Polynomial.build("1 -1").toString());
        assertEquals("1/2+2/3x", Polynomial.build("1/2 2/3").toString());
        assertEquals("-1/2x", Polynomial.build("0 -1/2").toString());
        assertEquals("0", Polynomial.build("0").toString());
        assertEquals("1+2x", Polynomial.build("1 2 0 0").toString());
    }

}
