package Scalars;

public class RationalScalar extends Scalar{
    private int numerator;
    private int denominator;

    public RationalScalar(int num, int den){
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
        int otherDem = s.getDenominator();
        int otherNum = s.getNumerator();
        int newNum = this.getNumerator() * otherDem + otherNum * this.getDenominator();
        int newDem = this.getDenominator() * otherDem;
        return new RationalScalar(newNum, newDem).reduce();
    }

    @Override
    public Scalar mul(Scalar s) {
        int newNum = s.getNumerator() * getNumerator();
        int newDem = s.getDenominator() * getDenominator();
        return new RationalScalar(newNum, newDem).reduce();
    }

    @Override
    public Scalar neg() {
        return new RationalScalar(-getNumerator(), getDenominator()).reduce();
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

    public Scalar reduce(){
        int gcd = gcd(Math.abs(getNumerator()),Math.abs(getDenominator()));
        int newNum = getNumerator() / gcd;
        int newDem = getDenominator() / gcd;
        if (newDem < 0) {
            newDem = -newDem;
            newNum = - newNum;
        }
        if (newDem == 1){
            return new IntegerScalar(newNum);
        }
        return new RationalScalar(newNum, newDem);
    }

    private int gcd(int a, int b){
     if (b == 0){
         return a;
     }
     return gcd(b, a%b);
    }

}
