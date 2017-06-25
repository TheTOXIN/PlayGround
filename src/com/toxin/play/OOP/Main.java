package com.toxin.play.OOP;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>();

        Figure circle = new Circle(5, 5);
        Figure triangle = new Triangle(1, 3);
        Figure square = new Square(9, 7);

        figures.add(circle);
        figures.add(triangle);
        figures.add(square);

        Square squareCurrent = (Square) square;
        Triangle triangle1Current = (Triangle) triangle;
        Circle circleCurrent = (Circle) circle;

        squareCurrent.printCountAngle();
        triangle1Current.printCountEye();
        circleCurrent.printPI();

        for (Figure figure : figures) {
            figure.draw();
        }

        for (Figure figure : figures) {
            if (figure instanceof RotateFigure) {
                ((RotateFigure) figure).rotate(7, 7);
            }
        }
    }
}
