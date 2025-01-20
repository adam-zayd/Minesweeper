package org.example;

import java.util.Scanner;

public class Driver {
    private final Grid board;
    private final Scanner scanner;
    private final Timer timer;

    public Driver(int rows, int cols, int mines) {
        this.board = new Grid(rows, cols, mines);
        this.scanner = new Scanner(System.in);
        this.timer = new Timer();
    }

    private static int getValidInt(Scanner reader, String outp) {
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
            System.out.println("Your entry is invalid. \nMake sure your input is 0 or greater. \nMake sure it is only a number. \nMake sure it has no decimal place.");
        }
    }

    private static char getValidAction(Scanner reader) {
        char input;
        while (true) {
            System.out.println("Enter the action you want to take. Use 'f' for flag, 'r' for reveal: ");
            String userInput = reader.next().trim();

            if (userInput.length() == 1) {
                input = userInput.charAt(0);

                if (input == 'f' || input == 'F' || input == 'r' || input == 'R') {
                    return Character.toLowerCase(input);
                }
            }
            System.out.println("\nInvalid input. Please enter only 'f' or 'r', for flag or reveal, respectively: ");
        }
    }


    public void start () {

            System.out.println("Welcome to Minesweeper!\n");
            while (true) {
                board.display();
                int col = getValidInt(scanner, "Enter the column you want to take an action on: ");
                int row = getValidInt(scanner, "Enter the row you want to take an action on: ");

                char action = getValidAction(scanner);

                if (action == 'r') {
                    if (board.getFirstMove()) {
                        if (!board.firstMoveValidation(row,col)){
                            continue;
                        }
                        board.firstMoveSetup(row, col);
                        System.out.println("The timer has begun!!!");
                        timer.start();
                    }

                    int outcome = board.revealCell(row, col);
                    //return 0 on success, return 1 on mine, return anything else on error (-1: Flagged, 2: invalid entry, 3: already revealed)
                    switch (outcome) {

                        case -1:
                            System.out.println("YOU HAVE FLAGGED THAT POINT. If you want to reveal it, unflag using 'f' as your action next time.");
                            break;

                        case 0:
                            //successful reveal
                            break;

                        case 1:
                            board.display();
                            System.out.println("YOU HIT A MINE! Better luck next time");
                            System.out.println("Total game time: " + timer.getTimeInS() + " seconds");
                            System.exit(0);

                        case 2:
                            System.out.println("YOU ENTERED AN INVALID COORDINATE. Your row input should be between 0 and " + (board.getRows()-1) + ". Your column input should be between 0 and " + (board.getCols()-1));
                            break;

                        case 3:
                            System.out.println("YOU HAVE ALREADY REVEALED THAT POINT. Pick an unrevealed point next time. ");
                            break;

                        default:
                            System.out.println("REVEALCELL has returned ERRORRRRRRRRRRRRRRRRRRRRR. Something unexpected. ");
                            break;
                    }
                } else {   //action == 'f'
                    board.flagCell(row, col);
                }

                if (board.gameWon()) {            //FIX ME - implement game won checker
                    board.display();
                    System.out.println("Congratulations! You've won the game! Try it with a larger grid/more mines next time.");
                    System.out.println("Final game time: " + timer.getTimeInS() + " seconds");
                    System.exit(0);
                }
                if (!board.getFirstMove()){
                    System.out.println("Game time so far: " + timer.getTimeInS() + " seconds");
                }
            }
            }
        }
