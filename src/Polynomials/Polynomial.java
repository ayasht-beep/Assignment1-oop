package Polynomials;

import Scalars.IntegerScalar;
import Scalars.RationalScalar;
import Scalars.Scalar;

import java.security.cert.PolicyNode;
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
            if (myMon != null) {
                output.monomials.remove(myMon);
                Monomial sum = mon.add(myMon);
                if (sum.sign() != 0) {
                    output.monomials.add(sum);
                }
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

    public Polynomial mul (Polynomial p){
        Polynomial output = new Polynomial();
        for (Monomial myMon : this.monomials) {
            for(Monomial otherMon : p.monomials){
                Monomial product = myMon.mul(otherMon);
                Monomial existingMon = output.getExp(product.getExponent());
                if (existingMon != null) {
                    output.monomials.remove(existingMon);
                    Monomial sum = existingMon.add(product);

                    if (sum.sign() != 0) {
                        output.monomials.add(sum);
                    }
                }
                else {
                    if(product.sign() != 0){
                        output.monomials.add(product);
                    }
                }
            }
        }
        return output;
    }


    public Scalar evaluate(Scalar s){
        Scalar output = new IntegerScalar(0);
        for(Monomial mon : this.monomials) {
            output = output.add(mon.evaluate(s));
        }
        return output;
    }

    public Polynomial derivative (){
        Polynomial output = new Polynomial();

        for (Monomial m : this.monomials){
            Monomial derived = m.derivative();

            if (derived.sign() != 0) {
                output.monomials.add(derived);
            }
        }
        return output;
    }
    @Override
    public boolean equals (Object o){
        if (this == o) { return true; }
        if (!(o instanceof Polynomial)){ return false; }
        Polynomial other = (Polynomial) o;
        if (this.monomials.size() != other.monomials.size()) return false;
        for (Monomial myMon : this.monomials) {
            Monomial otherMon = other.getExp(myMon.getExponent());
            if (otherMon == null) {
                return false;
            }
            if ( !myMon.getCoefficient().equals(otherMon.getCoefficient())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (monomials.isEmpty()) {
            return "0";
        }
        int size = monomials.size();
        String output = "";
        for (int i = 0; size > 0; i++) {
            Monomial mon = getExp(i);
            if (mon != null) {
                if (mon.sign() != 0) {
                    if (!output.isEmpty() && mon.sign() > 0) {
                        output = output + "+";
                    }
                    output = output + mon.toString();
                }
                size--;
            }
        }
        if (output.isEmpty()) {
            return "0";
        }
        return output;
    }
}
