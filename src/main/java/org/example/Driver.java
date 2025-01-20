package org.example;

public class Driver {
    private final Grid board;
    private final Timer timer;
    private final UserInput userInput;

    public Driver(int rows, int cols, int mines, UserInput userInput) {
        this.board = new Grid(rows, cols, mines);
        this.timer = new Timer();
        this.userInput= userInput;
    }


    public void start () {

            System.out.println("Welcome to Minesweeper!\n");
            while (true) {
                board.display();
                int col = userInput.getValidCoord("Enter the column you want to take an action on: ");
                int row = userInput.getValidCoord("Enter the row you want to take an action on: ");

                char action = userInput.getValidAction();

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
                            userInput.close();
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
                    userInput.close();
                    System.exit(0);
                }
                if (!board.getFirstMove()){
                    System.out.println("Game time so far: " + timer.getTimeInS() + " seconds");
                }
            }
            }
        }
