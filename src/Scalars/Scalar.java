package Scalars;

public abstract class Scalar {
    public abstract Scalar add(Scalar s);
    public abstract Scalar mul(Scalar s);
    public abstract Scalar neg();
    public Scalar power(int exponent){
        if (exponent==0){
            return new IntegerScalar(1);
        }
        if (exponent == 1) {
            return this;
        }
        return this.mul(power(exponent - 1));
    }
    public abstract int sign();
    public abstract boolean equals(Object o);
    public abstract String toString();
    public abstract int getNumerator();
    public abstract int getDenominator();


}
