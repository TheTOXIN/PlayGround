package com.toxin.play.Layouts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Card extends JFrame implements ActionListener {
    private CardLayout card;

    private JPanel cardPanel = new JPanel();
    private JPanel buttons = new JPanel();
    private JButton first = new JButton("First");
    private JButton last = new JButton("Last");
    private JButton next = new JButton("Next");
    private JButton prev = new JButton("Prev");
    private JButton show = new JButton("Show");

    public Card() {
        card = new CardLayout(10, 10);

        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        cardPanel.setLayout(card);

        for (int i = 0; i < 12; i++) {
            cardPanel.add("" + i, new JLabel("" + i, JLabel.CENTER));
        }

        buttons.add(first);
        first.addActionListener(this);
        buttons.add(last);
        last.addActionListener(this);
        buttons.add(next);
        next.addActionListener(this);
        buttons.add(prev);
        prev.addActionListener(this);
        buttons.add(show);
        show.addActionListener(this);

        getContentPane().add("Center", cardPanel);
        getContentPane().add("South", buttons);

        setBounds(0, 300, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CardLayout");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == first) {
            ((CardLayout)cardPanel.getLayout()).first(cardPanel);
        }
        if(e.getSource()==last) {
            ((CardLayout)cardPanel.getLayout()).last(cardPanel);
        }
        if(e.getSource()==next) {
            ((CardLayout)cardPanel.getLayout()).next(cardPanel);
        }
        if(e.getSource()==prev) {
            ((CardLayout)cardPanel.getLayout()).previous(cardPanel);
        }
        if(e.getSource() == show) {
            String answer = JOptionPane.showInputDialog("INPUT NUMBER");
            if (answer != null) {
                ((CardLayout)cardPanel.getLayout()).show(cardPanel, answer);
            }
        }
    }
}
