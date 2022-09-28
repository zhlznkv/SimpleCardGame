package com.company;

public enum Suit {
    DIAMONDS ("♦", "D"),
    CLUBS ("♣", "C"),
    HEARTS ("♥", "H"),
    SPADES ("♠", "S");

    private String symbol;
    private String name;

    Suit(String symbol, String name) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
