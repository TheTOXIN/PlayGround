package com.toxin.play.Builder;

public class Contact {

    private final String name;
    private final String surname;
    private final String eMail;
    private final String phoneNumber;

    public Contact(String name, String surname, String eMail, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public Contact(ContactBuilder builder) {
        this.name = builder.getName();
        this.surname = builder.getSurname();
        this.eMail = builder.geteMail();
        this.phoneNumber = builder.getPhoneNumber();
    }

    public void printContact() {
        System.out.println("Name - " + name + '\n' +
                           "Surname - " + surname + '\n' +
                           "Email - " + eMail + '\n' +
                           "Phone number - " + phoneNumber);
    }
}
