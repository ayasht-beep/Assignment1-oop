package Scalars;

public abstract class Scalar {
    public abstract Scalar add(Scalar s);
    public abstract Scalar mul(Scalar s);
    public abstract Scalar neg();
    public abstract Scalar power(int exponent);
    public abstract int sign();
    public abstract boolean equals(Object o);
    public abstract String toString();

    protected abstract Scalar addInteger(IntegerScalar s);


}
