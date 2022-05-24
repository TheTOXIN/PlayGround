package com.toxin.play.Patterns;

import java.util.List;
import java.util.Random;

public class AbstractFactory {

    //family one
    interface Button {
        void paint();
    }

    class ButtonWin implements Button {
        @Override
        public void paint() {
            System.out.println("WIN Button");
        }
    }

    class ButtonMac implements Button {
        @Override
        public void paint() {
            System.out.println("MAC Button");
        }
    }

    //family two
    interface Checkbox {
        void draw();
    }

    class CheckboxWin implements Checkbox {
        @Override
        public void draw() {
            System.out.println("WIN Checkbox");
        }
    }

    class CheckboxMac implements Checkbox {
        @Override
        public void draw() {
            System.out.println("MAC Checkbox");
        }
    }

    //factory
    abstract class GUIFactory { //may be iface
        protected abstract Button createButton();
        protected abstract Checkbox createCheckbox();
    }

    class GUIFactoryWin extends GUIFactory {
        @Override
        protected Button createButton() {
            return new ButtonWin();
        }

        @Override
        protected Checkbox createCheckbox() {
            return new CheckboxWin();
        }
    }

    class GUIFactoryMac extends GUIFactory {
        @Override
        protected Button createButton() {
            return new ButtonMac();
        }

        @Override
        protected Checkbox createCheckbox() {
            return new CheckboxMac();
        }
    }

    class ApplicationView {
        private GUIFactory guiFactory;
        private Button button;
        private Checkbox checkbox;

        public ApplicationView(GUIFactory guiFactory) {
            this.guiFactory = guiFactory;

            this.createUI();
            this.renderUI();
        }

        public void createUI() {
            this.button = guiFactory.createButton();
            this.checkbox = guiFactory.createCheckbox();
        }

        public void renderUI() {
            this.button.paint();
            this.checkbox.draw();
        }

        @Override
        public String toString() {
            return "APP WORK";
        }
    }

    class AppRunner {

        public void run(String os) {
            GUIFactory factory;

            if (os.equals("MAС")) {
                factory = new GUIFactoryMac();
            } else if (os.equals("WIN")) {
                factory = new GUIFactoryWin();
            } else {
                throw new RuntimeException("ШО");
            }

            ApplicationView application = new ApplicationView(factory);
            System.out.println(application);
        }
    }

    AppRunner runner = new AppRunner();

    public static void main(String[] args) {
        String os = List.of("MAС", "WIN").get((int) (Math.random() * 2));

        AbstractFactory main = new AbstractFactory();
        main.runner.run(os);
    }
}
