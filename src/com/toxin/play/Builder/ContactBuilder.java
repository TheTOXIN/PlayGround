package com.toxin.play.Builder;

public class ContactBuilder {

    private String name;
    private String surname;
    private String eMail;
    private String phoneNumber;

    public ContactBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContactBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactBuilder seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public ContactBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact build() {
        return new Contact(this);
    }
}
