package com.mortgageCalculator;

import java.util.Scanner;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Validation {
static int principal;
static float interest;
static int periodInYears;


    public static int checkPrincipalValidation(Scanner scanner) {

        while (true) {
            if (scanner.hasNextInt()) {
                principal = scanner.nextInt();
                if (principal >= 1_000 && principal <= 1_000_000) {
                    break;
                }
                System.out.println(principal + " is not between 1,000 and 1,000,000. Please enter correct Principal (1K - $1M):");
            } else {
                System.out.println(scanner.nextLine() + " is not a valid integer. Please enter correct Principal (Integer):");
            }
        }
        return principal;
    }


    public static Float checkInterestValidation(Scanner scanner) {
        while (true) {
            if (scanner.hasNextFloat() || scanner.hasNextInt()) {
                   if (scanner.hasNextInt())
                       return interest = parseFloat(String.valueOf(scanner.nextInt()));
                   if (scanner.hasNextFloat())
                       return interest = scanner.nextFloat();
            } else {
                System.out.println(scanner.nextLine() + " is not a valid rate");
                System.out.print("Please enter correct Rate: ");
            }
        }

    }

    public static Integer checkPeriodValidation(Scanner scanner) {

        while (true) {
            if (scanner.hasNextInt()) {
                periodInYears = scanner.nextInt();
                return periodInYears;
            } else {
                System.out.println(scanner.nextLine() + " is not a valid period");
                System.out.print("Please enter correct Period (Years): ");
            }
        }
    }


}
