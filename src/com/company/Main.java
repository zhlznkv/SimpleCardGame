package com.company;

import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // формируем колоду карт
        LinkedList<Card> Deck = new LinkedList<>();
        for (Suit s : Suit.values()){
            for (Rang r : Rang.values()) {
                Deck.add(new Card(r, s));
            }
        }

        Collections.shuffle(Deck);

        LinkedList<Card> IvanList = new LinkedList<>();
        LinkedList<Card> JohnList = new LinkedList<>();

        // раздача карт Ивану и Джону
        while (!Deck.isEmpty()){
            IvanList.add(Deck.getFirst());
            Deck.remove(0);
            JohnList.add(Deck.getFirst());
            Deck.remove(0);
        }

        // игра "ПЬЯНИЦА" длится до тех пор, пока у обоих игроков есть карты
        int counter = 0;
        while (!IvanList.isEmpty() & !JohnList.isEmpty()){
            counter++;
            System.out.println("ИВАН " + IvanList.size() + " - ДЖОН " + JohnList.size());
            System.out.println("-----");
            System.out.println("Карта Ивана " + IvanList.getFirst());
            System.out.println("Карта Джона " + JohnList.getFirst());

            int IvanJohnScore = IvanList.getFirst().compareTo(JohnList.getFirst());

            if (IvanJohnScore < 0) {

                JohnList.addLast(IvanList.getFirst());
                JohnList.addLast(JohnList.getFirst());
                JohnList.removeFirst();
                IvanList.removeFirst();
                System.out.println("Джон забирает!");

            } else if (IvanJohnScore > 0){

                IvanList.addLast(IvanList.getFirst());
                IvanList.addLast(JohnList.getFirst());
                JohnList.removeFirst();
                IvanList.removeFirst();
                System.out.println(("Иван забирает!"));

            } else {

                System.out.println("Карты равнозначны!");
                if (JohnList.size()==1) {
                    IvanList.add(JohnList.getFirst());
                    JohnList.removeFirst();
                    continue;
                };
                if (IvanList.size()==1) {
                    JohnList.add(IvanList.getFirst());
                    IvanList.removeFirst();
                    continue;
                };
                LinkedList<Card> onDeckList = new LinkedList<Card>();
                onDeckList.add(IvanList.getFirst());
                IvanList.removeFirst();
                onDeckList.add(JohnList.getFirst());
                JohnList.removeFirst();
                boolean isCardsEquals = true;
                while (isCardsEquals) {
                    onDeckList.add(IvanList.getFirst());
                    onDeckList.add(JohnList.getFirst());
                    System.out.println("Карта Ивана " + IvanList.getFirst());
                    System.out.println("Карта Джона " + JohnList.getFirst());
                    if (IvanList.getFirst().compareTo(JohnList.getFirst()) ==0 ){
                        System.out.println("Карты снова равнозначны!");
                        IvanList.removeFirst();
                        JohnList.removeFirst();
                    } else if (IvanList.getFirst().compareTo(JohnList.getFirst()) < 0 ){
                        JohnList.addAll(onDeckList);
                        IvanList.removeFirst();
                        JohnList.removeFirst();
                        System.out.println("Джон забирает!");
                        isCardsEquals = false;
                    } else if (IvanList.getFirst().compareTo(JohnList.getFirst()) > 0 ){
                        IvanList.addAll(onDeckList);
                        IvanList.removeFirst();
                        JohnList.removeFirst();
                        System.out.println("Иван забирает!");
                        isCardsEquals = false;
                    }
                }
            }
            //Thread.sleep(950);
        }
        System.out.println("=== GAME OVER ===");
        System.out.println(counter);
    }
}
