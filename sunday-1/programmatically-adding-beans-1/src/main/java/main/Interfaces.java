package main;

import java.util.function.Supplier;

public class Interfaces {
    public static void main(String[] args) {
        /*
         * The Supplier<T> interface is used to generate and return the same type of object.
         * It only creates the object when it is requested.
         */

        // The old way to specify a functional interface is to use an anonymous class.
        Supplier<String> helloSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "hello";
            }
        };
        System.out.println(helloSupplier.get());

        // The newer way is to use a lambda expression.
        // Lambda expressions can only be used to define a functional interface with 1 method.
        Supplier<Integer> number = () -> 420;
        System.out.println(number.get());

        // Example of specifying a functional interface with lambda expressions.
        MathOp add = Double::sum;
        MathOp sub = (a, b) -> a - b;
        MathOp mul = (a, b) -> a * b;
        MathOp div = (a, b) -> a / b;

        System.out.println(add.compute(5, 5));
        System.out.println(sub.compute(10, 5));
        System.out.println(mul.compute(10, 10));
        System.out.println(div.compute(10, 2));
    }

    public interface MathOp {
        double compute(double a, double b);
    }
}
