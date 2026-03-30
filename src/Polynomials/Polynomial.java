package Polynomials;

import Scalars.IntegerScalar;
import Scalars.RationalScalar;
import Scalars.Scalar;

import java.util.Collection;
import java.util.ArrayList;

public class Polynomial {
    private Collection <Monomial> monomials;

    public Polynomial(){
        this.monomials = new ArrayList<Monomial>();
    }

    public static Polynomial build(String s){
            Polynomial output = new Polynomial();
            String [] coef = s.split(" ");
            int exp =0;
            for (String coefficient : coef) {
               Monomial mon;
                String[] curr = coefficient.split("/");
               if (curr.length > 1) {
                   mon = new Monomial(exp, new RationalScalar(Integer.parseInt(curr[0]), Integer.parseInt(curr[1])));
               }
               else {
                   mon = new Monomial(exp, new IntegerScalar(Integer.parseInt(curr[0])));
               }
               output.monomials.add(mon);
               exp++;
            }
            return output;
    }
    public Polynomial add (Polynomial p){

    }

    public Polynomial mul (Polynomial p){return null;}

    public Scalar evaluate(Scalar s){return null;}

    public Polynomial derivative (){
        Polynomial result = new Polynomial();

        for (Monomial m : this.monomials){
            Monomial derivedMonomial = m.derivative();

            if (derivedMonomial.getCoefficient().sign() != 0){
                result.monomials.add(m);
            }
        }
        return result;
    }

    public boolean equals (Object o){return false;}

    public String toString(){return null;}

}
