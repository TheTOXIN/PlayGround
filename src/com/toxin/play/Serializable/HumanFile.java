package com.toxin.play.Serializable;

import java.io.*;

public class HumanFile {
    public void save(String name, Human human) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream("src/com/toxin/play/Serializable/" + name);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(human);
        fileOutput.close();
        objectOutput.close();
    }

    public Human load(String name) throws IOException, ClassNotFoundException {
        FileInputStream fileInput = new FileInputStream("src/com/toxin/play/Serializable/" + name);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        Human human = (Human) objectInput.readObject();
        fileInput.close();
        objectInput.close();
        return human;
    }
}
