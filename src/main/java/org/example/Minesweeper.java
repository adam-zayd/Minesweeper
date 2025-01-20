package org.example;


public class Minesweeper {



    public static void main(String[] args) {
        UserInput userInput= new UserInput();
        int rows= userInput.getValidDim("Enter how many rows you want: ");
        int cols= userInput.getValidDim("Enter how many columns you want: ");
        int mines= userInput.getValidInt(rows, cols);

        Driver game = new Driver(rows, cols, mines, userInput); // Grid size: 8x8, 10 mines
        game.start();
        }
    }
