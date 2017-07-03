package com.toxin.play.Serializable;

import java.io.*;

public class Human implements Externalizable {
    private String name;
    private String female;
    private Integer age;
    private String phone;
    private transient int secretNumber;

    public Human() {}

    public Human(String name, String female, Integer age, String phone) {
        this.name = name;
        this.female = female;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getFemale() {
        return female;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeObject(this.female);
        out.writeObject(this.age);
        out.writeObject(this.phone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject();
        female = (String)in.readObject();
        age = (Integer)in.readObject();
        phone = (String)in.readObject();
    }

    public void save(String name) throws IOException {
        FileOutputStream fileOutput = new FileOutputStream("src/com/toxin/play/Serializable/" + name);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(this);
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

    public void printINFO() {
        System.out.println(name);
        System.out.println(female);
        System.out.println(age);
        System.out.println(phone);
    }
}
