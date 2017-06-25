package com.toxin.play.Decorate;

public class CatWrapper extends Cat {
    private Cat original;

    public CatWrapper(Cat cat) {
        super(cat.getName());
        this.original = cat;
    }

    @Override
    public String getName() {
        return "Кот по имени " + original.getName();
    }

    @Override
    public void setName(String name) {
        original.setName(name);
    }
}
