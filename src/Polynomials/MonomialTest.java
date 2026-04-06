package Polynomials;

import Scalars.IntegerScalar;
import Scalars.RationalScalar;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonomialTest {

    @Test
    public void getExponent() {
        Monomial m = new Monomial(3, new IntegerScalar(4));
        assertEquals(3, m.getExponent());
    }

    @Test
    public void getCoefficient() {
        Monomial m = new Monomial(3, new IntegerScalar(4));
        assertEquals(new IntegerScalar(4), m.getCoefficient());

        Monomial m2 = new Monomial(2, new RationalScalar(1, 2));
        assertEquals(new RationalScalar(1, 2), m2.getCoefficient());
    }

    @Test
    public void add() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(4));
        Monomial m3 = new Monomial(3, new IntegerScalar(4));

        assertEquals("7x^2", m1.add(m2).toString());
        assertNull(m1.add(m3));

        Monomial m4 = new Monomial(2, new RationalScalar(1, 2));
        Monomial m5 = new Monomial(2, new RationalScalar(1, 3));
        assertEquals("5/6x^2", m4.add(m5).toString());

        Monomial mCancel1 = new Monomial(2, new IntegerScalar(3));
        Monomial mCancel2 = new Monomial(2, new IntegerScalar(-3));
        assertEquals("0", mCancel1.add(mCancel2).toString());
    }

    @Test
    public void mul() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(3, new IntegerScalar(4));

        assertEquals("12x^5", m1.mul(m2).toString());

        Monomial m3 = new Monomial(2, new RationalScalar(1, 2));
        Monomial m4 = new Monomial(3, new RationalScalar(2, 3));

        assertEquals("1/3x^5", m3.mul(m4).toString());

        Monomial mZeroCoef = new Monomial(3, new IntegerScalar(0));
        assertEquals("0", m1.mul(mZeroCoef).toString());
    }

    @Test
    public void evaluate() {
        Monomial m = new Monomial(3, new IntegerScalar(2));
        assertEquals(new IntegerScalar(54), m.evaluate(new IntegerScalar(3)));

        Monomial m2 = new Monomial(2, new RationalScalar(1, 2));
        assertEquals("2", m2.evaluate(new IntegerScalar(2)).toString());

        Monomial mEvalZero = new Monomial(3, new IntegerScalar(5));
        assertEquals("0", mEvalZero.evaluate(new IntegerScalar(0)).toString());
    }

    @Test
    public void derivative() {
        Monomial m1 = new Monomial(3, new IntegerScalar(4));
        Monomial m2 = new Monomial(0, new IntegerScalar(5));

        assertEquals("12x^2", m1.derivative().toString());
        assertEquals("0", m2.derivative().toString());

        Monomial m3 = new Monomial(3, new RationalScalar(1, 2));
        assertEquals("3/2x^2", m3.derivative().toString());
    }

    @Test
    public void sign() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(-4));
        Monomial m3 = new Monomial(2, new RationalScalar(0, 5));

        assertEquals(1, m1.sign());
        assertEquals(-1, m2.sign());
        assertEquals(0, m3.sign());
    }

    @Test
    public void testEquals() {
        Monomial m1 = new Monomial(2, new IntegerScalar(3));
        Monomial m2 = new Monomial(2, new IntegerScalar(3));
        Monomial m3 = new Monomial(3, new IntegerScalar(3));

        assertEquals(m1, m2);
        assertNotEquals(m1, m3);
    }

    @Test
    public void testToString() {
        assertEquals("x^3", new Monomial(3, new IntegerScalar(1)).toString());
        assertEquals("4x", new Monomial(1, new IntegerScalar(4)).toString());
        assertEquals("-x^7", new Monomial(7, new IntegerScalar(-1)).toString());
        assertEquals("5", new Monomial(0, new IntegerScalar(5)).toString());
        assertEquals("1/2x^2", new Monomial(2, new RationalScalar(1, 2)).toString());

        assertEquals("x", new Monomial(1, new IntegerScalar(1)).toString());
        assertEquals("-x", new Monomial(1, new IntegerScalar(-1)).toString());
        assertEquals("0", new Monomial(5, new IntegerScalar(0)).toString());
    }
}