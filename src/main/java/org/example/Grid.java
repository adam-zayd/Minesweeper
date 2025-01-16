package org.example;
import java.util.Random;

public class Grid {
    private final int rows;
    private final int cols;
    private final int totalMines;
    private final Cell[][] board;
    private boolean firstMove;

    public Grid(int rows, int cols, int totalMines) {   //constructor
        this.rows = rows;
        this.cols = cols;
        this.totalMines = totalMines;
        this.board = new Cell[rows][cols];    //2D array of Cell type to store board state
        this.firstMove = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public void firstMoveSetup(int initialRow, int initialCol) {    //first move set to false, mines placed except for first move
        this.firstMove= false;
        initMines(initialRow, initialCol);
        calculateAllSurroundingMines();
    }

    private void initMines(int initialRow, int initialCol) {  //randomly place mines at start of game, except in given coords
        Random random= new Random();

        for (int i=0; i<totalMines ;i++) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            if ((row == initialRow && col == initialCol) || board[row][col].getMine()) {
                i--;
                continue;
            }

            board[row][col].setMine();
        }
        }


    private void calculateAllSurroundingMines() {//for each cell, count surrounding mines
        for (int i =0; i<rows; i++){
            for (int j = 0; j < cols; j++) {
                if (board[i][j].getMine()){
                    continue;
                }
                else{
                    int count = 0;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            int newRow = i + x;
                            int newCol = j + y;

                            if ((newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) && board[newRow][newCol].getMine()) {
                                count++;
                            }
                        }
                    }
                    board[i][j].setNeighboringMines(count);
                }

            }
        }
    }

public boolean revealCell(int row, int col) {
        }

    public void flagCell(int row, int col) {
        }


    public boolean getFirstMove() {
    return firstMove;
    }

    public void display() {   //display Grid

        }

}
