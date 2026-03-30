//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
package Polynomials;

import Scalars.IntegerScalar;

public class Main {
    public static void main(String[] args) {
        System.out.println("create polynomials");

        //p1 = 3x^2 + 2x
        Polynomial p1 = Polynomial.build("0 2 3");

        //p2 = 1x^2 + 5
        Polynomial p2 = Polynomial.build("5 0 1");

        //checking toString
        System.out.println("Polynomial 1: " + p1);
        System.out.println("Polynomial 2: " + p2);
        System.out.println("-------------------------");

        //checking add
        Polynomial sum = p1.add(p2);
        System.out.println("p1 + p2 = " + sum); // אמור לצאת: 5 + 2x + 4x^2

        //checking mul
        Polynomial product = p1.mul(p2);
        System.out.println("p1 * p2 = " + product);

        // checking derivative
        Polynomial derived = p1.derivative();
        System.out.println("Derivative of p1: " + derived); // הנגזרת של 3x^2+2x היא 2+6x

        // checking Evulate
        IntegerScalar valToEvaluate = new IntegerScalar(2);
        System.out.println("p1 evaluated with 2: " + p1.evaluate(valToEvaluate));
    }
}