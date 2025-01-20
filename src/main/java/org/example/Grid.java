package org.example;
import java.util.Random;

public class Grid{
    private final int rows;
    private final int cols;
    private final int totalMines;
    private final Cell[][] board;
    private boolean firstMove;

    public Grid(int rows, int cols, int totalMines){   //constructor
        this.rows = rows;
        this.cols = cols;
        this.totalMines = totalMines;
        this.board = new Cell[rows][cols];    //2D array of Cell type to store board state
        this.firstMove = true;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                board[i][j] = new Cell();
            }
        }
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public void firstMoveSetup(int initialRow, int initialCol){    //first move set to false, mines placed except for first move
        this.firstMove = false;
        initMines(initialRow, initialCol);
        calculateAllSurroundingMines();
    }

    private void initMines(int initialRow, int initialCol){  //randomly place mines at start of game, except in given coords
        Random random= new Random();
        for(int i = 0; i<totalMines ;i++){
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            if(row == initialRow && col == initialCol
               ||row == initialRow-1 && col == initialCol-1
               ||row == initialRow && col == initialCol-1
               ||row == initialRow-1 && col == initialCol
               ||row == initialRow-1 && col == initialCol+1
               ||row == initialRow+1 && col == initialCol-1
               ||row == initialRow+1 && col == initialCol
               ||row == initialRow && col == initialCol+1
               ||row == initialRow+1 && col == initialCol+1
               ||board[row][col].getMine()){
                i --;
                continue;
            }
            board[row][col].setMine();
        }
        }

    private void calculateAllSurroundingMines(){//for each cell, count surrounding mines
        for(int i =0; i<rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j].getMine()){
                    continue;
                }
                else{
                    int count = 0;
                    for (int x = -1; x <= 1; x++){
                        for (int y = -1; y <= 1; y++){
                            int newRow = i + x;
                            int newCol = j + y;
                            if((newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) && board[newRow][newCol].getMine()){
                                count++;
                            }
                        }
                    }
                    board[i][j].setNeighboringMines(count);
                }
            }
        }
    }

public boolean firstMoveValidation(int row, int col){
    if(!(row < rows && col < cols)){
        System.out.println("YOU ENTERED AN INVALID COORDINATE.");
        return false;
    } else if(board[row][col].getFlagged()){
        System.out.println("YOU HAVE FLAGGED THAT POINT. If you want to reveal it, unflag using 'f' as your action next time.");
        return false;
    } else{
        return true;
    }
}

public int revealCell(int row, int col){  //return 0 on success, return 1 on mine, return anything else on error (-1: Flagged, 2: invalid entry, 3: already revealed)
    if(!(row >= 0 && row < rows && col >= 0 && col < cols)){
        return 2;
    }
    if (board[row][col].getRevealed()){
        return 3;
    }
    if (board[row][col].getFlagged()){
        return -1;
    }
    board[row][col].reveal();
    if (board[row][col].getMine()){
        return 1;
    }
    if (board[row][col].getSurroundingMines() == 0){
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int newRow = row + i;
                int newCol = col + j;
                if((newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) && !board[newRow][newCol].getRevealed() && !board[newRow][newCol].getMine() && !board[newRow][newCol].getFlagged()){
                    revealCell(newRow, newCol);
                }
            }
        }
    }
    return 0;
    }

    public void flagCell(int row, int col){
        if((row >= 0 && row < rows && col >= 0 && col < cols) && !board[row][col].getRevealed()){
            board[row][col].flag();
        }
        else{
            System.out.println("You have entered an invalid coordinate or it has already been revealed.");
        }
    }

    public boolean getFirstMove(){
    return firstMove;
    }

    public boolean gameWon(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j].getMine()){
                    continue;
                }
                else{
                    if (!board[i][j].getRevealed()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void display(){   //display Grid
        System.out.print("\n");
        System.out.print("    ");
        for(int col = 0; col < cols; col++){
            System.out.print(col + "   ");
        }
        System.out.println();
        for(int row = 0; row < rows; row++){
            System.out.print(row + "  ");
            for(int col = 0; col < cols; col++){
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
        }