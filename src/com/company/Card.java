package com.company;

public class Card implements Comparable<Card>{
    public Rang rang;
    public Suit suit;
    public boolean isTrump = false;

    Card(Rang rang, Suit suit) {
        this.rang = rang;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return new String(rang.toString()+suit.toString());
    }

    @Override
    public int compareTo(Card card) {
        if (this.rang.equals(Rang.SIX) && card.rang.equals(Rang.ACE)) return 1;
        else if (this.rang.equals(Rang.ACE) && card.rang.equals(Rang.SIX)) return -1;
        else return this.rang.ordinal() - card.rang.ordinal();
    }
}
