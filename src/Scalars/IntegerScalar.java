package Scalars;

public class IntegerScalar extends Scalar {
    private int number;

    public IntegerScalar(int number){
        this.number = number;
    }

    @Override
    public int getNumerator() {
        return this.number;
    }

    @Override
    public int getDenominator() {
        return 1;
    }

    @Override
    public Scalar add(Scalar s) {
        return new RationalScalars((this.number *  s.getDenominator()) + s.getNumerator(),
                s.getDenominator()).reduce();
    }

    @Override
    public Scalar mul(Scalar s) {
        return  new RationalScalars(this.number * s.getNumerator(), s.getDenominator()).reduce();
    }

    @Override
    public Scalar neg() {
        return null;
    }

    @Override
    public Scalar power(int exponent) {
        return null;
    }

    @Override
    public int sign() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }
}
