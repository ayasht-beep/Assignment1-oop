package Scalars;

public class IntegerScalar extends Scalar {
    private int number;

    public IntegerScalar(int number){
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }


    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }
    @Override
    public Scalar addInteger(IntegerScalar s) {
        return new IntegerScalar(this.number + s.getNumber());
    }
    @Override
    public Scalar addRational (RationalScalar s) {
        return new RationalScalar( (this.number * s.getDenominator()) + s.getNumerator(), s.getDenominator()).reduce();
    }
    @Override
    public Scalar addReal(RealScalar s) {
        return new RealScalar(this.number + s.getRealValue());
    }

    @Override
    public Scalar mulInteger (IntegerScalar s) {
        return new IntegerScalar(this.number * s.getNumber());
    }

    @Override
    public Scalar mulRational (RationalScalar s) {
        return new RationalScalar(this.number * s.getNumerator(), s.getDenominator()).reduce();
    }
    @Override
    public Scalar mulReal (RealScalar s) {
        return new RealScalar(this.number * s.getRealValue());
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(-this.number);
    }

    @Override
    public int sign() {
        if (this.number > 0) return 1;
        if (this.number < 0) return -1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Scalar){
            return ((Scalar) o).isEqualToInteger(this);
        }
        return false;
    }

    @Override
    public boolean isEqualToInteger(IntegerScalar s) {
        return this.number == s.getNumber();
    }
    @Override
    public boolean isEqualToRational(RationalScalar s) {
        RationalScalar reduced = s.reduce();
        return reduced.getDenominator() == 1 && reduced.getNumerator() == this.number;
    }
    @Override
    public boolean isEqualToReal(RealScalar s) {
        return Double.compare((double) this.number, s.getRealValue()) == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
