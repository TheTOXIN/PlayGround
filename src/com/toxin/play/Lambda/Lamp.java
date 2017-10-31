package com.toxin.play.Lambda;

public class Lamp implements Electricity{
    public void lightOn() {
        System.out.println("Лампа горит");
    }

    @Override
    public void electricityOn(double volt) {
        lightOn();
    }
}
