package com.toxin.play.Layouts;

import java.awt.*;

public class MyLayout implements LayoutManager {
    private Dimension computeLayoutSize(Container parent) {
        int prefWidth = 0;
        int prefHeight = 0;
        Component[] components = parent.getComponents();
        for (int i = 0; i < components.length; i++) {
            prefWidth += components[i].getWidth();
            prefHeight += components[i].getHeight();
        }
        return new Dimension(prefWidth, prefHeight);
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        //TODO
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        //TODO
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return computeLayoutSize(parent);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return computeLayoutSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        Component components[] = parent.getComponents();
        int row = 0;
        int col = 0;
        int width = parent.getWidth() / components.length;
        int height = parent.getHeight() / components.length;
        for (int i = 0; i < components.length; i++) {
            Rectangle r = new Rectangle(col, row, width, height);
            components[i].setBounds(r);
            col += width;
            row += height;
        }
    }
}
