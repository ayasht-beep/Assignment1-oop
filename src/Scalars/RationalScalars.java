package Scalars;

public class RationalScalars extends Scalar{
    private int numerator;
    private int denominator;

    public RationalScalars(int num, int den){
        if (den < 0){
            this.numerator = -num;
            this.denominator = -den;
        }
        else{
            this.numerator = num;
            this.denominator = den;
        }
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    @Override
    public Scalar add(Scalar s) {
        RationalScalars newS = new
    }

    @Override
    public Scalar mul(Scalar s) {
        return null;
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
