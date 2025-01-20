package org.example;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public void close(){
        scanner.close();
    }

    public static int getValidCoord(String outp) {
        while (true) {
            System.out.println(outp);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value>=0) {
                    return value;
                }
            } else {
                scanner.next();
            }
            System.out.println("Your entry is invalid. \nMake sure your input is 0 or greater. \nMake sure it is only a number. \nMake sure it has no decimal place.");
        }
    }

    public static int getValidDim(String outp) {
        while (true) {
            System.out.println(outp);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value>=4) {
                    return value;
                }
            } else {
                scanner.next();
            }
            System.out.println("Your entry is invalid. \nMake sure your rows/columns are 4 or greater.\nMake sure it is only a number. \nMake sure it has no decimal place.");
        }
    }

    public static int getValidInt(int rows, int cols) {
        int maxMines= (rows*cols)-9;
        while (true) {
            System.out.println("Enter how many mines you want: ");
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value<=maxMines) {
                    return value;
                }
            } else {
                scanner.next();
            }
            System.out.println("Your entry is invalid. \nMake sure your input is " + maxMines + " or less. \nMake sure it is only a number. \nMake sure it has no decimal place.");
        }
    }

    public static char getValidAction() {
        char input;
        while (true) {
            System.out.println("Enter the action you want to take. Use 'f' for flag, 'r' for reveal: ");
            String userInput = scanner.next().trim();

            if (userInput.length() == 1) {
                input = userInput.charAt(0);

                if (input == 'f' || input == 'F' || input == 'r' || input == 'R') {
                    return Character.toLowerCase(input);
                }
            }
            System.out.println("\nInvalid input. Please enter only 'f' or 'r', for flag or reveal, respectively: ");
        }
    }
}

