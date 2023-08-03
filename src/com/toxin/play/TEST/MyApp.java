package com.toxin.play.TEST;

import processing.core.PApplet;
import processing.core.PGraphics;

public class MyApp extends PApplet {
    PGraphics pg;
    int x, y, gravity, frictionalForce, delta;

    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        // Создаем объект класса PVector, который представляет координаты точки на экране
        float x = width / 2;
        float y = height / 2 - 10;
        // Инициализируем объект класса PGraphics для рисования
        pg = createGraphics(800, 600);
        // Устанавливаем цвет фона
        background(255);
        // Рисуем линию, которая будет служить маятником
        line(x, y, x, y + 10);
    }

    @Override
    public void draw() {
        // Перерисовываем экран
        super.updatePixels();
        // Обновляем координаты маятника в соответствии с физическим движением
        x = x - gravity * delta;
        y = y - frictionalForce * delta; // Здесь frictionalForce - коэффициент трения
        // Если маятник пересекает нижнюю границу экрана, то останавливаем его движение
        if (y < 0) {
            x = width / 2; // Возвращаем маятник в центр экрана
            y = 0; // Инициализируем его в начале координат
        }
        // Отрисовываем маятник
        pg.pushMatrix();
        pg.translate(x, y);
        pg.stroke(0); // Устанавливаем цвет линии
        pg.line(0, 0, 100, 0); // Рисуем линию длиной 100 пикселей
        pg.popMatrix();
    }

    public static void main (String... args) {
        MyApp pt = new MyApp();
        PApplet.runSketch(new String[]{"ProcessingTest"}, pt);
    }
}
