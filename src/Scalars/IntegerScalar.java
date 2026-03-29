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
        return new RationalScalar((this.number *  s.getDenominator()) + s.getNumerator(),
                s.getDenominator()).reduce();
    }

    @Override
    public Scalar mul(Scalar s) {
        return  new RationalScalar(this.number * s.getNumerator(), s.getDenominator()).reduce();
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(-this.number);
    }

    @Override
    public int sign() {
        if (this.number > 0){
            return 1;
        }
        if (this.number < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof IntegerScalar){
            return this.number == ((IntegerScalar) o).number;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
