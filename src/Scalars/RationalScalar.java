package Scalars;

public class RationalScalar extends Scalar{
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator) {
        if (denominator < 0){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else{
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public RationalScalar reduce(){
        int gcd = gcd(Math.abs(getNumerator()),Math.abs(getDenominator()));
        int newNum = getNumerator() / gcd;
        int newDem = getDenominator() / gcd;

        if (newDem < 0) {
            newDem = -newDem;
            newNum = -newNum;
        }
        return new RationalScalar(newNum, newDem);
    }

    private int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a%b);
    }


    @Override
    public Scalar add(Scalar s) { return s.addRational(this); }

    @Override
    public Scalar mul(Scalar s) { return s.mulRational(this); }


    @Override
    public Scalar addInteger(IntegerScalar s){
        int newNumerator = this.numerator + (s.getNumber() * this.denominator);
        return new RationalScalar(newNumerator, this.denominator).reduce();
    }

    @Override
    public Scalar addRational(RationalScalar s){
        int newNumerator = (this.numerator * s.getDenominator()) + (s.getNumerator() * this.denominator);
        int newDenominator = this.denominator * s.getDenominator();
        return new RationalScalar(newNumerator, newDenominator).reduce();
    }

    @Override
    public Scalar addReal (RealScalar s){
        double thisRealValue = (double) this.numerator / this.denominator;
        return new RealScalar(thisRealValue + s.getRealValue());
    }


    @Override
    public Scalar mulInteger(IntegerScalar s){
        return new RationalScalar(this.numerator * s.getNumber(), this.denominator);
    }

    @Override
    public Scalar mulRational(RationalScalar s) {
        // כפל רציונלי עם רציונלי: מונה כפול מונה, מכנה כפול מכנה
        return new RationalScalar(this.numerator * s.getNumerator(), this.denominator * s.getDenominator()).reduce();
    }

    @Override
    public Scalar mulReal(RealScalar s) {
        // כפל רציונלי עם ממשי: התוצאה היא ממשית
        double thisRealValue = (double) this.numerator / this.denominator;
        return new RealScalar(thisRealValue * s.getRealValue());
    }


    @Override
    public Scalar neg() {
        return new RationalScalar(-getNumerator(), getDenominator()).reduce();
    }

    @Override
    public int sign() {
        if (getNumerator() == 0) {
            return 0;
        }
        return getNumerator() / Math.abs(getNumerator());
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Scalar) {
            return ((Scalar) o).isEqualToRational(this);
        }
        return false;
    }
    @Override
    public boolean isEqualToInteger (IntegerScalar s){
        RationalScalar reduced = this.reduce();
        return reduced.denominator == 1 && reduced.numerator == s.getNumber();
    }

    @Override
    public boolean isEqualToRational (RationalScalar s){
        return (long)this.denominator * s.getDenominator() == (long)s.getNumerator() * this.numerator;
    }

    @Override
    public boolean isEqualToReal(RealScalar s) {
        return Double.compare((double)numerator / denominator, s.getRealValue()) == 0;
    }


    @Override
    public String toString() {
        RationalScalar r = this.reduce();
        if (r.denominator == 1) {
            return String.valueOf(r.numerator);
        }
        return r.numerator + "/" + r.denominator;
    }

}
