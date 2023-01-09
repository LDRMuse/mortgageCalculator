package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

import static com.mortgageCalculator.Validation.*;


public class MortgageCalculator {


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
        System.out.print("Period (Years): ");
        try {
            return checkPeriodValidation(scanner);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public static void getMortgage(Integer principal, Float interestRate, Integer period, byte PERCENT,
                                   byte MONTHS_IN_YEAR) {
        float monthlyInterest = interestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = period * MONTHS_IN_YEAR;
        double mathPower = Math.pow(1 + monthlyInterest, numberOfPayments);
        double monthlyPayment = principal * (monthlyInterest * mathPower / (mathPower - 1));
        String monthlyPaymentFormatted = NumberFormat.getCurrencyInstance().format(monthlyPayment);
        System.out.print("Mortgage: " + monthlyPaymentFormatted);
    }

    public static void runMortgageCalculator() {
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

            System.out.println("MORTGAGE CALCULATOR");

            getMortgage(getPrincipal(scanner), getAnnualInterestRate(scanner), getPeriod(scanner), PERCENT, MONTHS_IN_YEAR);

    }


}



