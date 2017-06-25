package com.toxin.play.Serializable;

import java.io.*;

public class Human implements Serializable, Externalizable {
    private String name;
    private String female;
    private int age;
    private String phone;
    private transient int secretNumber;

    public Human(String name, String female, int age, String phone) {
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
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }

    public void printINFO() {
        System.out.println(name);
        System.out.println(female);
        System.out.println(age);
        System.out.println(phone);
    }
}
