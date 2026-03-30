package Polynomials;
import Scalars.IntegerScalar;
import Scalars.Scalar;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent,  Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public int getExponent() {
        return exponent;
    }
    public Scalar getCoefficient(){
        return coefficient;
    }

    public Monomial add(Monomial m){
        if (this.exponent != m.getExponent()) {
            return null;
        }
        Scalar newCoefficient = this.coefficient.add(m.getCoefficient());
        return new Monomial(this.exponent, newCoefficient);
    }

    public Monomial mul(Monomial m){
        int newExp = getExponent() + m.getExponent();
        Scalar newCoefficient = getCoefficient().mul(m.getCoefficient());
        return new Monomial(newExp, newCoefficient);
    }

    public Scalar evaluate(Scalar s){
        Scalar sPower = s.power(this.exponent);
        return this.coefficient.mul(sPower);
    }

    public Monomial derivative(){
        if (getExponent() == 0) {
            return new Monomial(0, new IntegerScalar(0));
        }
        return new Monomial(getExponent() - 1, getCoefficient().mul(new IntegerScalar(getExponent())));
    }

    public int sign(){
        return this.coefficient.sign();
    }

    @Override
    public boolean equals(Object o){
        if (! (o instanceof Monomial)) {
            return false;
        }
        Monomial other = (Monomial) o;
        return getCoefficient().equals(other.getCoefficient()) && getExponent() == other.getExponent();
    }

    @Override
    public String toString(){
        String coefficientStr = this.coefficient.toString();
        if(this.exponent == 0){
            return coefficientStr;
        }
        String result = "";
        if(coefficientStr.equals("1")){
            result = "";
        }
        else if(coefficientStr.equals("-1")){
            result = "-";
        }
        else{
            result = coefficientStr;
        }
        if(this.exponent == 1){
            return result + "x";
        }
        else{
            return result + "x^" + this.exponent;
        }
    }
}
