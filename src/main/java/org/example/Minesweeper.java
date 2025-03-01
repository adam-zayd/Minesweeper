package org.example;

public class Minesweeper{

    public static void main(String[] args){
        UserInput userInput = new UserInput();
        int rows = UserInput.getValidDim("Enter how many rows you want(recommended - 8): ");
        int cols = UserInput.getValidDim("Enter how many columns you want(recommended - 10): ");
        int mines = UserInput.getValidInt(rows, cols);
        Driver game = new Driver(rows, cols, mines, userInput); // Grid size: 8x8, 10 mines
        game.start();
    }
}
