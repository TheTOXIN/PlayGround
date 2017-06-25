package com.toxin.play.Layouts;

import javax.swing.*;
import java.awt.*;

public class Border extends JFrame {

    private BorderLayout border;

    public Border()
    {
        border = new BorderLayout();
        getContentPane().setLayout(border);
        getContentPane().add(new JButton("North"), BorderLayout.NORTH);
        getContentPane().add(new JButton("South"), BorderLayout.SOUTH);
        getContentPane().add(new JButton("West"), BorderLayout.WEST);
        getContentPane().add(new JButton("East"), BorderLayout.EAST);
        getContentPane().add(new JButton("Center"), BorderLayout.CENTER);
        setBounds(600,0,300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BorderLayout");
        setVisible(true);
    }
}
