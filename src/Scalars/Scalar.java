package Scalars;

public abstract class Scalar {
    public abstract Scalar add(Scalar s);
    public abstract Scalar mul(Scalar s);

    public abstract Scalar addInteger(IntegerScalar s);
    public abstract Scalar addRational(RationalScalar s);
    public abstract Scalar addReal(RealScalar s);

    public abstract Scalar mulInteger(IntegerScalar s);
    public abstract Scalar mulRational(RationalScalar s);
    public abstract Scalar mulReal(RealScalar s);

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
    public abstract boolean isEqualToInteger(IntegerScalar s);
    public abstract boolean isEqualToRational(RationalScalar s);
    public abstract boolean isEqualToReal(RealScalar s);
    public abstract String toString();

}
