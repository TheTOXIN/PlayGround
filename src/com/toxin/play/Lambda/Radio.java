package com.toxin.play.Lambda;

public class Radio implements Electricity{
    public void playMusic() {
        System.out.println("Музыка играет");
    }

    @Override
    public void electricityOn(double volt) {
        playMusic();
    }
}
