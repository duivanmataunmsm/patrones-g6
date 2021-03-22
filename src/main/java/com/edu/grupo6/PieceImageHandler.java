package com.edu.grupo6;

import javax.swing.*;

public abstract class PieceImageHandler {
    String path = "";

    public ImageIcon getImage() {
        //System.out.println(this.getPath());
        try {
            return new ImageIcon(getClass().getClassLoader().getResource(this.getPath()));
        } catch (Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;
    }

    protected String getPath() {
        return this.path;
    }

    ;

    public abstract boolean hasImage();

}