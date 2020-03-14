package org.rogamba.gradletesting;

public class GradleTesting {

    public static Integer sumNumbers(Integer a, Integer b) {
        return a+b;
    }

    public static void main(String[] args) {
        Integer x = 1;
        Integer y = 2;
        Integer z = sumNumbers(x,y);
        System.out.println(z);
    }
}