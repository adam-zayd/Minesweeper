package org.example;

public class Cell {
    private boolean getMine;       //Mine on it
    private boolean getRevealed;    //Has been clicked
    private boolean getFlagged;     //Has been flagged
    private int surroundingMines;  //number of mines in surrounding

    public Cell() {   //constructor
        this.getMine = false;
        this.getRevealed = false;
        this.getFlagged = false;
        this.surroundingMines = 0;
    }


    public boolean getMine() {
        return getMine;
    }

    public void setMine() {
        this.getMine = true;
    }

    public boolean getRevealed() {
        return getRevealed;
    }

    public void reveal() {
        this.getRevealed = true;
    }

    public boolean getFlagged() {
        return getFlagged;
    }

    public void flag() {
        this.getFlagged = !this.getFlagged;
    }

    public int getSurroundingMines() {
        return surroundingMines;
    }

    public void setNeighboringMines(int neighboringMines) {

        this.surroundingMines = neighboringMines;
    }

//    @Override
//    public String toString() {
//        if (getRevealed) {
//            if (getMine){
//                return "*";
//            }
//            else {
//                String ret= String.valueOf(surroundingMines)
//                return "[" + ret + "]";
//            }
//        }
//        else{
//            if (getFlagged){
//                return "|>";
//            }
//            else{
//                return "[?]";
//            }
//
//        }
//    }

}
