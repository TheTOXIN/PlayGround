package com.toxin.play.Util;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class KeyboardObserver extends Thread {

    private final Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<>(100);
    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("KEY BOARD OBSERVER");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setOpacity(0.0f);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) { keyEvents.add(e); }

            @Override
            public void keyReleased(KeyEvent e) { }
        });
    }

    public void end() {
        this.frame.dispose();
    }

    public KeyEvent event() {
        if (!keyEvents.isEmpty()) {
            return keyEvents.poll();
        } else {
            return null;
        }
    }
}
