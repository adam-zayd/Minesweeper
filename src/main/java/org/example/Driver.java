package org.example;

import java.util.Scanner;

public class Driver {
    private final Grid board;
    private final Scanner scanner;

    public Driver(int rows, int cols, int mines) {
        this.board = new Grid(rows, cols, mines);
        this.scanner = new Scanner(System.in);
    }

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

//    private static char getValidAction(Scanner reader){   FIX ME
//        while (true) {
//            System.out.println("Please enter a valid action \n'r' for revealing the given coords\n'f' for flagging them");
//            if (reader.hasNext(){
//                if ((reader.next() = "r") || (reader.next() = "R") || (reader.next() = "f") || reader.next() ="F"){
//            }) {
//                int value = reader.nextInt();
//                if (value>=0) {
//                    return value;
//                }
//            } else {
//                reader.next();
//            }
//            System.out.println(err);
//        }
//
//    }
//}

    public void start() {

        System.out.println("Welcome to Minesweeper!");
        while (true) {
            board.display();
            System.out.print("Enter which coordinate you want to take an action on (separate row and column : ");
            int row = getValidInt(scanner, "Enter the row you want to take an action on: ", "Your entry is invalid. \nMake sure your input is 0 or greater. \nMake sure it is only a number. \nMake sure it has no decimal place.");
            int col = getValidInt(scanner, "Enter the column you want to take an action on: ", "Your entry is invalid. \nMake sure your input is 0 or greater. \nMake sure it is only a number. \nMake sure it has no decimal place.");

            char action = scanner.next().charAt(0);    //FIX ME - implement valid action checker

            if (board.getFirstMove()) {
                board.firstMoveSetup(row, col);
            }

            if (action == 'r') {
                if (board.revealCell(row, col)) {     //FIX ME Reveal Cell output changed from bool to int output
                    System.out.println("Game over! You hit a mine.");
                    board.display();
                    break;
                }
            } else if (action == 'm') {
                board.flagCell(row, col);
            } else {
                System.out.println("Invalid action. Use 'r' to reveal or 'm' to mark.");
            }

            if (game is won){            //FIX ME - implement game won checker
                System.out.println("Congratulations! You've won the game!");
                board.display();
                break;

            }

        }

