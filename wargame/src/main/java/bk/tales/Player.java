package bk.tales;

public class Player {

    private String name;
    private Deck hand;


    public Player(String name, Deck hand){
        this.name = name;
        this.hand = hand;
    }

    public String getPlayerName(){
        return name;
    }

    public Deck getPlayerHand(){
        return hand;
    }

    public Card playCard(int round){
        Card cardToPlay = hand.getCardIndex(round);

        return cardToPlay;
    }
}
