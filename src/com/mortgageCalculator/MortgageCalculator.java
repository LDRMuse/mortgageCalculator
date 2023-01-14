package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

import static com.mortgageCalculator.Validation.*;


public class MortgageCalculator {
    static byte MONTHS_IN_YEAR = 12;
    static byte PERCENT = 100;

    public static Integer getPrincipal(Scanner scanner) {
        System.out.print("Principal (1K - $1M): ");
        try {
            return checkPrincipalValidation(scanner);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Float getAnnualInterestRate(Scanner scanner) {
        System.out.print("Annual Interest Rate: ");
        try {
            return checkInterestValidation(scanner);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Integer getPeriod(Scanner scanner) {
        System.out.print("Period (1-30 Years): ");
        try {
            return checkPeriodValidation(scanner);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static double getMortgage(Integer principal, Float interestRate, Integer period, byte PERCENT,
                                     byte MONTHS_IN_YEAR) {
        float monthlyInterest = interestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;
        double mathPower = Math.pow(1 + monthlyInterest, numberOfPayments);
        //        return NumberFormat.getCurrencyInstance().format(monthlyPayment);
        return principal * (monthlyInterest * mathPower / (mathPower - 1));

    }

    public static void calculateBalance(Integer principal, Float interestRate, double mortgage) {
        double newBalance = principal;
        interestRate /= 100;

        for (int month = 1; month <= periodInYears * MONTHS_IN_YEAR; month++) {
            newBalance = newBalance + interestRate - mortgage;
            if (newBalance <= 0) {
                break;
            }
            System.out.println(NumberFormat.getCurrencyInstance().format(newBalance));

        }

    }


    public static void runMortgageCalculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("MORTGAGE CALCULATOR");
        String mortgage = String.valueOf(getMortgage(getPrincipal(scanner), getAnnualInterestRate(scanner), getPeriod(scanner), PERCENT, MONTHS_IN_YEAR));
        System.out.print("MORTGAGE: " + mortgage);
        System.out.println(" ");
        System.out.println(" ");


        System.out.println("BALANCE:");
        calculateBalance(principal, interest, Double.parseDouble(mortgage));

    }


}



