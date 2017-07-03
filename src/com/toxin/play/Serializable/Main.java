package com.toxin.play.Serializable;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human toxin = new Human("Yuri", "Belousov", 19, "89186710791");

        toxin.save("toxin.dat");
        Human newToxin =  toxin.load("toxin.dat");

        newToxin.printINFO();
    }
}
