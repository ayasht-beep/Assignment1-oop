import Scalars.Scalar;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent,  Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m){
        if (this.exponent != m.getExponent) {
            return null;
        }
        Scalar newCoefficient = this.coefficient.add(m.getCoefficient);
        return new Monomial(this.exponent, newCoefficient);
    }

    public Monomial mul(Monomial m){return null;}

    public Scalar evulate(Scalar s){
        Scalar sPower = s.power(this.exponent);
        return this.coefficient.mul(sPower);
    }

    public Monomial derivative(){return null;}

    public int sign(){
        return this.coefficient.sign();
    }

    public boolean equals(Object o){return false;}
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
