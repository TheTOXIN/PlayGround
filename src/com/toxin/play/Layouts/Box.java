package com.toxin.play.Layouts;

import java.awt.*;
import javax.swing.*;

public class Box extends JFrame {

    private BoxLayout box;

    public Box() {
        box = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
        getContentPane().setLayout(box);
        for (int i = 0; i < 25; i++) {
            getContentPane().add(new JButton("" + i));
        }
        setBounds(300, 0, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BoxLayout");
        setVisible(true);
    }
}
