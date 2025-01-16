package org.example;
import java.util.Random;

public class Grid {
    private final int rows;
    private final int cols;
    private final int totalMines;
    private final Cell[][] grid;
    private boolean firstMove;

    public Grid(int rows, int cols, int totalMines) {   //constructor
        this.rows = rows;
        this.cols = cols;
        this.totalMines = totalMines;
        this.grid = new Cell[rows][cols];    //2D array of Cell type to store grid state
        this.firstMove = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void firstMoveSetup(int initialRow, int initialCol) {    //first move set to false, mines placed except for first move,
    }

    private void initMines(int initialRow, int initialCol) {  //randomly place mines at start of game
        }


    private void calculateAllSurroundingMines() {  //for each cell, count surrounding mines, set value in cell attribute
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
