package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Minesweeper {

    private static int getValidInt(Scanner reader, String outp, String err) {
        while (true) {
            System.out.println(outp);
            if (reader.hasNextInt()) {
                int value = reader.nextInt();
                if (value>=0) {
                    return value;
                }
            } else {
                reader.next();
            }
            System.out.println(err);
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int rows= getValidInt(reader, "Enter how many rows you want: ","Your entry is invalid. \nMake sure your input is 0 or greater. \nMake sure it is only a number. \nMake sure it has no decimal place.");
        int cols= getValidInt(reader, "Enter how many columns you want: ","Your entry is invalid. \nMake sure your input is 0 or greater. \nMake sure it is only a number. \nMake sure it has no decimal place.");
        int mines= getValidInt(reader, "Enter how many mines you want: ","Your entry is invalid. \nMake sure your input is 0 or greater. \nMake sure it is only a number. \nMake sure it has no decimal place.");

        Driver game = new Driver(rows, cols, mines); // Grid size: 8x8, 10 mines
        game.start();
        }
    }
