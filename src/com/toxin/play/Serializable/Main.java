package com.toxin.play.Serializable;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human toxin = new Human("Yuri", "Belousov", 19, "89186710791");
        HumanFile humanFile = new HumanFile();
        humanFile.save("toxin.dat", toxin);
        Human newToxin =  humanFile.load("toxin.dat");
        newToxin.printINFO();
    }
}
