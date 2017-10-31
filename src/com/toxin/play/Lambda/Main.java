package com.toxin.play.Lambda;

public class Main {
    public static void yeahFunctions(double volt) {
        System.out.println("SUPER FUNC " + volt);
    }


    public static void main(String[] args) {
        Switcher switcher = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();

        //event subscribe
        switcher.addElectricityListener(lamp);
        switcher.addElectricityListener(radio);

        switcher.addElectricityListener(new Electricity() {
            @Override
            public void electricityOn(double volt) {
                System.out.println("Пажар " + volt);
            }
        });

        switcher.addElectricityListener((volt) -> System.out.println("Лямбда Пажар - " + volt));
        switcher.addElectricityListener(volt -> Main.yeahFunctions(volt));

        switcher.addElectricityListener(System.out::println);
        switcher.addElectricityListener(Main::yeahFunctions);

        switcher.switchOn();
    }
}
