package Scalars;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerScalarTest {

    @Test
    public void getNumerator() {
    }

    @Test
    public void getDenominator() {
    }

    @Test
    public void add() {
        IntegerScalar s1 = new IntegerScalar(5);
        IntegerScalar s2 = new IntegerScalar(3);

        Scalar actual = s1.add(s2);
        Scalar expected = new IntegerScalar(8);
        assertEquals(expected, actual);
    }

    @Test
    public void mul() {
        IntegerScalar s1 = new IntegerScalar(4);
        IntegerScalar s2 = new IntegerScalar(2);
        IntegerScalar zero = new IntegerScalar(0);

        Scalar expected = new IntegerScalar(8);

        assertEquals(expected, s1.mul(s2));
        assertEquals(new IntegerScalar(0), s1.mul(zero));
    }
    @Test
    public void testPower() {
        IntegerScalar s = new IntegerScalar(2);

        assertEquals(new IntegerScalar(8), s.power(3));
        assertEquals(new IntegerScalar(1), s.power(0));
    }

    @Test
    public void neg() {
        IntegerScalar positive = new IntegerScalar(5);
        IntegerScalar negative = new IntegerScalar(-3);

        assertEquals(new IntegerScalar(-5), positive.neg());
        assertEquals(new IntegerScalar(3), negative.neg());
    }

    @Test
    public void sign() {
        assertEquals(1, new IntegerScalar(5).sign());
        assertEquals(-1, new IntegerScalar(-7).sign());
        assertEquals(0, new IntegerScalar(0).sign());
    }

    @Test
    public void testEquals() {
        IntegerScalar s1 = new IntegerScalar(5);
        IntegerScalar s2 = new IntegerScalar(5);
        IntegerScalar s3 = new IntegerScalar(3);

        assertEquals(s1, s2);
        assertNotEquals(s1, s3);
    }

    @Test
    public void testToString() {
        assertEquals("5", new IntegerScalar(5).toString());
        assertEquals("-3", new IntegerScalar(-3).toString());
    }
}