package bk.tales;

import java.util.ArrayList;
import java.util.Collections;

public class DeckManager {

        ArrayList<Card> cardDeck = new ArrayList<>();
        Card card;
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Queen", "Jack", "King", "Ace"};

        int index01;
        int index02;


        public Deck createDeck(){

            for (int i = 0; i < Shapes.values().length; i++){
                for (int j = 0; j < values.length; j++){
                    cardDeck.add(createCard(Shapes.values()[i], values[j]));
                }
            }

            shuffle();

            return new Deck(cardDeck);
        }

        private Card createCard(Shapes shape, String value){
            return new Card(shape, value);
        }

        public void shuffle(){
            Collections.shuffle(cardDeck);
        }

        public int winCondition(String value01, String value02){

            for (int i = 0; i < values.length; i++) {
                if(values[i].equals(value01)){
                    index01 = i;
                }else if(values[i].equals(value02)){
                    index02 = i;
                }
            }

            if(index01 > index02){
                return 1;
            }else if(index01 < index02) {
                return 0;
            }else if(index01 == index02){
                return -1;
            }

            return 99;
        }
           
}
