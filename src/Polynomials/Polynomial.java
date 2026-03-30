package Polynomials;

import Scalars.Scalar;

import java.util.Collection;
import java.util.ArrayList;

public class Polynomial {
    private Collection <Monomial> monomials;

    public Polynomial(String s){
        this.monomials = new ArrayList<Monomial>();

    }

    public Collection <Monomial> getMonomials(){
        return monomials;
    }

    public static Polynomial build(String s){
            
    }
    public Polynomial add (Polynomial p){

    }

    public Polynomial mul (Polynomial p){return null;}

    public Scalar evulate(Scalar s){return null;}

    public Polynomial derivate (){
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
