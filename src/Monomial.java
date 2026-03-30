import Scalars.Scalar;

public class Monomial {
    private int exponent;
    private Scalar coefficient;

    public Monomial(int exponent,  Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    public Monomial add(Monomial m){return null;}
    public Monomial mul(Monomial m){return null;}
    public Scalar evulate(Scalar s){return null;}
    public Monomial derivative(){return null;}
    public int sign(){return 0;}
    public boolean equals(Object o){return false;}
    public String toString(){return null;}


}
