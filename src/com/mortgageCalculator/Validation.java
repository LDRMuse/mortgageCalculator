package com.mortgageCalculator;

import java.util.Scanner;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Validation {
    //VALIDATION
    public static Integer checkPrincipalValidation(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return parseInt(scanner.nextLine());
            }
            else  {
                System.out.println(scanner.nextLine() + " is not a valid integer");
                System.out.print("Please enter correct Principal (Integer): ");
            }
        }
    }

    public static Float checkInterestValidation(Scanner scanner) {
        while (true) {
            if (scanner.hasNextFloat() || scanner.hasNextInt()) {
                if(scanner.hasNextInt()) {
                    return parseFloat(scanner.nextLine());
                }
                return scanner.nextFloat();
            }
            else  {
                System.out.println(scanner.nextLine() + " is not a valid rate");
                System.out.print("Please enter correct Rate: ");
            }
        }

    }public static Integer checkPeriodValidation(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            else  {
                System.out.println(scanner.nextLine() + " is not a valid period");
                System.out.print("Please enter correct Period (Years): ");
            }
        }

    }

}
