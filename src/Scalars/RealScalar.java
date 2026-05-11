package Scalars;

public class RealScalar extends Scalar {
    private double number;

    public RealScalar(double number) {
        this.number = number;
    }

    public double getRealValue() {
        return this.number;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addReal(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulReal(this);
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        return new RealScalar(this.number + s.getNumber());
    }

    @Override
    public Scalar addRational(RationalScalar s) {
        double rationalValue = (double) s.getNumerator() / s.getDenominator();
        return  new RealScalar(this.number + rationalValue);
    }

    @Override
    public Scalar addReal(RealScalar s) {
        return new RealScalar(this.number + s.getRealValue());
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        return new RealScalar(this.number * s.getNumber());
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        double rationalValue = (double) s.getNumerator() / s.getDenominator();
        return new RealScalar(this.number * rationalValue);
    }

    @Override
    public Scalar mulReal(RealScalar s) {
        return new RealScalar (this.number * s.getRealValue());
    }

    @Override
    public Scalar neg() {
        return new RealScalar(-this.number);
    }

    @Override
    public int sign() {
        if (this.number < 0) return -1;
        if (this.number > 0) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Scalar) {
            return ((Scalar) o).isEqualToReal(this);
        }
        return false;
    }

    @Override
    public boolean isEqualToInteger(IntegerScalar s) {
        return Double.compare(this.number, (double) s.getNumber()) == 0;
    }

    @Override
    public boolean isEqualToRational(RationalScalar s) {
        double rationalValue = (double) s.getNumerator() / s.getDenominator();
        return Double.compare(this.number, rationalValue) == 0;
    }

    @Override
    public boolean isEqualToReal(RealScalar s) {
        return Double.compare(this.number, s.getRealValue()) == 0;
    }

    @Override
    public String toString() {
        double rounded = Math.round(this.number * 1000000.0) / 1000000.0;
        return Double.toString(rounded);
    }
}