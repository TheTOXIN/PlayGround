package com.toxin.play.OOP;

public class Triangle extends Figure implements RotateFigure {
    public Triangle(int x, int y) {
        super(x, y);
    }

    public void printCountEye() {
        System.out.println("I have a 1 one eye");
    }

    @Override
    void draw() {
        System.out.println("/\\");
    }

    @Override
    public void rotate(int x, int y) {
        System.out.println("Rotating triangle");
    }

    @Override
    void transform() {
        System.out.println("TRANSFORM - TRIANGLE");
    }
}
