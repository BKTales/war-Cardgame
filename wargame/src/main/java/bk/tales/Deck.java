package bk.tales;

import java.util.ArrayList;

public class Deck {

    ArrayList<Card> deck;

    public Deck(ArrayList<Card> cardDeck){
        deck = cardDeck;
    }

    @Override
    public String toString(){
        String printable = " ";

        for (int i = 0; i < deck.size(); i++) {
            printable = printable + deck.get(i) + "\n\n";
        }


        return printable;
    }
}
