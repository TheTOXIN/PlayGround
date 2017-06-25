package com.toxin.play.Layouts;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MyLayout");
        for(int k=0; k<5; k++)
            frame.getContentPane().add(new JButton(""+k));
        for(int k=0; k<5; k++)
            frame.getContentPane().add(new JLabel(""+k, JLabel.CENTER));
        frame.setLayout(new MyLayout());
        frame.setBounds(900,300,300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Flow flowLayout = new Flow();
        Box boxLayout = new Box();
        Border borderLayout = new Border();
        Grid gridLayout = new Grid();
        Card cardLayout = new Card();
        GridBag gridBagLayout = new GridBag();
        Spring springLayout = new Spring();
    }
}
