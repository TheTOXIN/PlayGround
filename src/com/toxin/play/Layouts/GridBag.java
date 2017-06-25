package com.toxin.play.Layouts;

import javax.swing.*;
import java.awt.*;

public class GridBag extends JFrame {
    public GridBag() {
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        getContentPane().setLayout(gridBag);

        c.fill = GridBagConstraints.BOTH;
        // Попробуйте убрать эту строку
        c.weightx = 1.0;
        makeButton("Button1", gridBag, c);
        makeButton("Button2", gridBag, c);
        makeButton("Button3", gridBag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; //конец строки
        makeButton("Button4", gridBag, c);

        c.weightx = 0.0;     // вернуть к значению по умолчанию
        makeButton("Button5", gridBag, c); //другая строка

        // Попробуйте закрыть эту строку и открыть следующюю за ней
        c.gridwidth = GridBagConstraints.RELATIVE; //предпоследний элемент
        //c.gridwidth = 1;
        makeButton("Button6", gridBag, c);

        c.gridwidth = GridBagConstraints.REMAINDER; //конец строки
        makeButton("Button7", gridBag, c);

        c.gridwidth = 1;        //установить значение по умолчанию
        c.gridheight = 2;
        // Попробуйте убрать эту строку
        c.weighty = 1.0;
        makeButton("Button8", gridBag, c);

        // Попробуйте убрать эту строку
        c.weighty = 0.0;     //установить значение по умолчанию
        c.gridwidth = GridBagConstraints.REMAINDER; //конец строки
        c.gridheight = 1;     //установить значение по умолчанию
        makeButton("Button9", gridBag, c);
        makeButton("Button10", gridBag, c);

        setBounds(300,300,300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GridBagLayout");
        setVisible(true);
    }

    protected void makeButton(String name, GridBagLayout gridbag, GridBagConstraints c)
    {
        JButton button = new JButton(name);
        gridbag.setConstraints(button, c);
        getContentPane().add(button);
    }
}
