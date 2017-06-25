package com.toxin.play.OOP;

public class Circle extends Figure {
    public Circle(int x, int y) {
        super(x, y);
    }

    public void printPI() {
        System.out.println("3,14");
    }

    @Override
    public void draw() {
        System.out.println("O");
    }
}
