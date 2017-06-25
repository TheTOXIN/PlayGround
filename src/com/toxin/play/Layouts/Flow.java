package com.toxin.play.Layouts;

import javax.swing.*;
import java.awt.*;

public class Flow extends JFrame {

    private FlowLayout flow;

    public Flow() {
        flow = new FlowLayout(FlowLayout.CENTER, 10, 10);
        getContentPane().setLayout(flow);
        for(int k=0; k < 25; k++) {
            getContentPane().add(new JButton("" + k));
        }
        setBounds(0,0,300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("FlowLayout");
        setVisible(true);
    }
}