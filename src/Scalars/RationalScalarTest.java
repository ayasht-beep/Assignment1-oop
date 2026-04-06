package Scalars;

import org.junit.Test;

import static org.junit.Assert.*;

public class RationalScalarTest {

    @Test
    public void getDenominator() {
        assertEquals(4, new RationalScalar(3, 4).getDenominator());
    }

    @Test
    public void getNumerator() {
        assertEquals(3, new RationalScalar(3, 4).getNumerator());
    }

    @Test
    public void add() {
        RationalScalar s1 = new RationalScalar(1, 2);
        RationalScalar s2 = new RationalScalar(1, 3);
        assertEquals(new RationalScalar(5, 6).toString(), s1.add(s2).toString());
    }

    @Test
    public void mul() {
        RationalScalar s1 = new RationalScalar(1, 2);
        RationalScalar s2 = new RationalScalar(2, 3);
        assertEquals(new RationalScalar(1, 3).toString(), s1.mul(s2).toString());
    }

    @Test
    public void neg() {
        RationalScalar s1 = new RationalScalar(1, 2);
        RationalScalar s2 = new RationalScalar(-3, 4);
        assertEquals(new RationalScalar(-1, 2).toString(), s1.neg().toString());
        assertEquals(new RationalScalar(3, 4).toString(), s2.neg().toString());
    }

    @Test
    public void sign() {
        assertEquals(1, new RationalScalar(3, 4).sign());
        assertEquals(-1, new RationalScalar(-3, 4).sign());
        assertEquals(-1, new RationalScalar(3, -4).sign());
        assertEquals(0, new RationalScalar(0, 4).sign());
    }

    @Test
    public void testEquals() {
        RationalScalar s1 = new RationalScalar(1, 2);
        RationalScalar s2 = new RationalScalar(2, 4);
        RationalScalar s3 = new RationalScalar(1, 3);
        assertEquals(s1.reduce(), s2.reduce());
        assertNotEquals(s1.reduce(), s3.reduce());
    }

    @Test
    public void testToString() {
        assertEquals("-3", new RationalScalar(12, -4).reduce().toString());
        assertEquals("12/5", new RationalScalar(-12, -5).reduce().toString());
        assertEquals("-3/2", new RationalScalar(12, -8).reduce().toString());
    }

    @Test
    public void reduce() {
        assertEquals("-3", new RationalScalar(12, -4).reduce().toString());
        assertEquals(new RationalScalar(1, 2).toString(), new RationalScalar(2, 4).reduce().toString());
    }
}