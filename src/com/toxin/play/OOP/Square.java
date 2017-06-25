package com.toxin.play.OOP;

public class Square extends Figure implements RotateFigure {
    public Square(int x, int y) {
        super(x, y);
    }

    public void printCountAngle() {
        System.out.println("I have a 4 angles");
    }

    @Override
    void draw() {
        System.out.println("[]");
    }

    @Override
    public void rotate(int x, int y) {
        System.out.println("Rotating square");
    }
}
