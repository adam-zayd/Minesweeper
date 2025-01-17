package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Minesweeper {

    private static int getValidInt(Scanner reader, String outp) {
        while (true) {
            System.out.println(outp);
            if (reader.hasNextInt()) {
                int value = reader.nextInt();
                    if (value>=4) {
                        return value;
                    }
            } else {
                reader.next();
            }
            System.out.println("Your entry is invalid. \nMake sure your input is 3 or greater. \nMake sure it is only a number. \nMake sure it has no decimal place.");
        }
    }

    private static int getValidInt(Scanner reader, String outp, int rows, int cols) {
        int maxMines= (rows*cols)-9;
        while (true) {
            System.out.println(outp);
            if (reader.hasNextInt()) {
                int value = reader.nextInt();
                if (value<=maxMines) {
                    return value;
                }
            } else {
                reader.next();
            }
            System.out.println("Your entry is invalid. \nMake sure your input is " + maxMines + " or less. \nMake sure it is only a number. \nMake sure it has no decimal place.");
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int rows= getValidInt(reader, "Enter how many rows you want: ");
        int cols= getValidInt(reader, "Enter how many columns you want: ");
        int mines= getValidInt(reader, "Enter how many mines you want: ",rows, cols);

        Driver game = new Driver(rows, cols, mines); // Grid size: 8x8, 10 mines
        game.start();
        }
    }
