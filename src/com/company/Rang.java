package com.company;
import java.util.Comparator;

public enum Rang {
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    TEN ("10"),
    JACK ("J"),
    QUEEN ("Q"),
    KING ("K"),
    ACE ("A");

    private String name;

    Rang (String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
