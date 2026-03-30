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
    public Polynomial add (Polynomial p) {
        Polynomial output = new Polynomial();
        output.monomials.addAll(monomials);
        for (Monomial mon : p.monomials) {
            Monomial myMon = getExp(mon.getExponent());
            if ( myMon != null) {
                output.monomials.add(mon.add(myMon));
                output.monomials.remove(myMon);
            }
            else {
                output.monomials.add(mon);
            }
        }
        return output;
    }
    private Monomial getExp(int exp) {
        for (Monomial mon : this.monomials) {
            if (mon.getExponent() == exp) {
                return mon;
            }
        }
        return null;
    }
    public Polynomial mul (Polynomial p){return null;}

    public Scalar evaluate(Scalar s){
        Scalar output = new IntegerScalar(0);
        for(Monomial mon : this.monomials) {
            output = output.add(mon.evaluate(s));
        }
        return output;
    }

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

    public String toString() {
        if (monomials.isEmpty()) {
            return "0";
        }
        int size = monomials.size();
        String output = "";
        for (int i = 0; size > 0; i++) {
            Monomial mon = getExp(i);
            if (mon != null) {
                if (!output.isEmpty() && mon.sign() > 0) {
                    output = output + "+";
                }
                output = output + mon.toString();
                size--;
            }
        }
        return output;
    }
}
