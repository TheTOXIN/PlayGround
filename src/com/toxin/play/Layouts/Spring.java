package com.toxin.play.Layouts;

import javax.swing.*;
import java.awt.*;

public class Spring extends JFrame {
    public Spring() {
        Container contentPane = getContentPane();

        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        Component label = new JLabel("Метка");
        Component field = new JTextField(15);

        contentPane.add(label);
        contentPane.add(field);

        layout.putConstraint(SpringLayout.WEST , label, 10, SpringLayout.WEST , contentPane);
        layout.putConstraint(SpringLayout.NORTH, label, 25, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, field, 25, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST , field, 20, SpringLayout.EAST , label);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 300,300, 300);
        setTitle("SpringLayout");
        setVisible(true);
    }
}
