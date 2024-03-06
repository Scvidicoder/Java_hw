package semestr4.lab1;

import java.util.function.Predicate;

public class PowerOfTwoPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {

        if (number <= 0) {
            return false;
        }

        while (number > 1) {
            if (number % 2 != 0) {
                return false; //
            }
            number /= 2;
        }

        return true;
    }

    public static void main(String[] args) {
        PowerOfTwoPredicate powerOfTwoPredicate = new PowerOfTwoPredicate();


        int num1 = 8;
        int num2 = 10;

        System.out.println(num1 + " is power of two: " + powerOfTwoPredicate.test(num1));
        System.out.println(num2 + " is power of two: " + powerOfTwoPredicate.test(num2));
    }
}
