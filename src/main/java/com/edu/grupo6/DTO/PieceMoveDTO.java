package com.edu.grupo6.DTO;
import java.io.Serializable;

public class PieceMoveDTO implements Serializable {
    private int currentRow;
    private int currentColumn;
    private int previousRow;
    private int previousColumn;
    private String piece;
    private String color;

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public int getPreviousRow() {
        return previousRow;
    }

    public void setPreviousRow(int previousRow) {
        this.previousRow = previousRow;
    }

    public int getPreviousColumn() {
        return previousColumn;
    }

    public void setPreviousColumn(int previousColumn) {
        this.previousColumn = previousColumn;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PieceMoveDTO() {
    }
}
