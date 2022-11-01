package com.toxin.play.TMP;

import com.toxin.play.Util.KeyboardObserver;

import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiceCounter {

    private static final Integer DICE_SIDE_COUNT = 6;
    private static final KeyboardObserver KEYBOARD_OBSERVER = new KeyboardObserver();

    public static void main(String[] args) throws Exception {
        var work = true;

        KEYBOARD_OBSERVER.start();
        KeyEvent keyEvent;

        Map<String, Integer> result = IntStream.range(0, DICE_SIDE_COUNT)
                .map(i -> i + 1)
                .mapToObj(Objects::toString)
                .collect(Collectors.toMap(Function.identity(), val -> 0));

        while (work) {
            if ((keyEvent = KEYBOARD_OBSERVER.event()) != null) {
                int keyCode = keyEvent.getKeyChar();

                if (keyCode >= KeyEvent.VK_1 && keyCode <= KeyEvent.VK_6) {
                    String keyChar = String.valueOf(keyEvent.getKeyChar());
                    result.merge(keyChar, 1, Integer::sum);
                }

                if (keyCode == KeyEvent.VK_ENTER) {
                    work = false;
                }
            }
        }

        KEYBOARD_OBSERVER.end();

        System.out.println("DICE STATS:");

        result.forEach((key, val) -> {
            System.out.println(key + " -> " + val);
        });

        int sum = result.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum = " + sum);

        double average = result.values().stream().mapToDouble(Integer::doubleValue).average().orElse(0d);
        System.out.println("average = " + average);

        double error = result.values().stream().mapToDouble(d -> Math.abs(d - average)).average().orElse(0d);
        System.out.println("error accuracy = " + error);
    }
}
