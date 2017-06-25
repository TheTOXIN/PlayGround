package com.toxin.play.Layouts;

import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {

    public GridLayout grid;

    public Grid() {
        grid = new GridLayout(4, 3, 10, 10);
        getContentPane().setLayout(grid);
        for (int i = 0; i < 12; i++) {
            getContentPane().add(new JButton("" + i));
        }
        setBounds(900, 0, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GridLayout");
        setVisible(true);
    }
}
