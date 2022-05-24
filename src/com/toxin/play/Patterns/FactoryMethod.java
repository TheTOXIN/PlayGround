package com.toxin.play.Patterns;

import java.util.List;

public class FactoryMethod {

    interface Button {
        void render();
        void click(String s);
    }

    class ButtonWin implements Button {
        @Override
        public void render() {
            System.out.println("WIN render");
        }

        @Override
        public void click(String s) {
            System.out.println("WIN click - " + s);
        }
    }

    class ButtonMac implements Button {
        @Override
        public void render() {
            System.out.println("MAC render");
        }

        @Override
        public void click(String s) {
            System.out.println("MAC click - " + s);
        }
    }

    abstract class DialogFactory {
        protected abstract Button createButton();

        void render() {
            Button button = createButton();

            button.click("close dialog");
            button.render();
        }
    }

    class DialogFactoryWin extends DialogFactory {
        @Override
        protected Button createButton() {
            return new ButtonWin();
        }
    }

    class DialogFactoryMac extends DialogFactory {
        @Override
        protected Button createButton() {
            return new ButtonMac();
        }
    }

    class AppRunner {

        public void run(String os) {
            DialogFactory factory;

            if (os.equals("MAС")) {
                factory = new DialogFactoryMac();
            } else if (os.equals("WIN")) {
                factory = new DialogFactoryWin();
            } else {
                throw new RuntimeException("ШО");
            }

            factory.render();
        }
    }

    AppRunner runner = new AppRunner();

    public static void main(String[] args) {
        String os = List.of("MAС", "WIN").get((int) (Math.random() * 2));

        FactoryMethod main = new FactoryMethod();
        main.runner.run(os);
    }
}
