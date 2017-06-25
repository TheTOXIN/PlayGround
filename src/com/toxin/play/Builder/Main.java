package com.toxin.play.Builder;

public class Main {
    public static void main(String[] args) {
        Contact myContact = new ContactBuilder()
                .setName("Yuri")
                .setSurname("Belousov")
                .seteMail("thetoksin@hotmail.com")
                .setPhoneNumber("+79186710791")
                .build();
        myContact.printContact();
    }
}
