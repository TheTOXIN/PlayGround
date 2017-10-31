package com.toxin.play.Lambda;

import java.util.ArrayList;
import java.util.List;

public class Switcher {
    private List<Electricity> consumers = new ArrayList<>();

    public void addElectricityListener(Electricity e) {
        consumers.add(e);
    }

    public void removeElectricityListener(Electricity e) {
        consumers.remove(e);
    }

    public void switchOn() {
        System.out.println("ВКЛЮЧЕНО");
        for (Electricity elrc : consumers) {
            elrc.electricityOn(220);
        }
    }
}
