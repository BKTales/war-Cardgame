package bk.tales;

import java.util.ArrayList;

public class Deck {

    ArrayList<Card> deck;

    public Deck(ArrayList<Card> cardDeck){
        deck = cardDeck;
    }

    public boolean cardExits(Card card){
        for (int i = 0; i < deckSize(); i++) {
            if(deck.contains(card)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public int deckSize(){
        return deck.size();
    }

    public void addCard(Card card){
        deck.add(card);
    }

    public void removeCard(Card card){
        deck.remove(card);
    }

    public Card getCardIndex(int index){
        return deck.get(index);
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
