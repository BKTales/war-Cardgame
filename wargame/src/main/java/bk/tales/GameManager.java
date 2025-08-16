package bk.tales;

import java.util.ArrayList;

public class GameManager {

    private Player player01;
    private Deck deck01;
    private ArrayList<Card> deck01Cards = new ArrayList<>();
    private Player player02;
    private Deck deck02;
    private ArrayList<Card> deck02Cards = new ArrayList<>();

    private int round;
    private DeckManager deckManager;
    private Deck fullDeck;

    private int repeatedCards;
    private ArrayList<Card> storedCards = new ArrayList<>();

    private Card player01Card;
    private Card player02Card;

    private int lowestCardDeck;

    public void start() throws InterruptedException{

        round = 0;
        deckManager = new DeckManager();

        fullDeck = deckManager.createDeck();
        divideDeck(fullDeck);


        player01 = new Player("A", deck01);
        player02 = new Player("B", deck02);

        while(deck01.deckSize() != 0 && deck02.deckSize() != 0){
            round++;

            System.out.printf("CURRENTLY PLAYING ROUND: %d %n", round);
            System.out.printf("CARDS IN %s %d %n", player01.getPlayerName(), player01.getPlayerHand().deckSize());
            System.out.printf("CARDS IN %s %d %n", player02.getPlayerName(), player02.getPlayerHand().deckSize());
            System.out.println();

            Thread.sleep(2500);

            lowestCardDeck = lowestCardDeck();


            player01Card = player01.playCard(lowestCardDeck);
            player02Card = player02.playCard(lowestCardDeck);

            System.out.printf("CARD PLAYED BY PLAYER %s: %s %n%nCARD PLAYED BY PLAYER %s: %s %n", player01.getPlayerName(), player01Card, player02.getPlayerName(), player02Card);
            Thread.sleep(2500);

            compareRound();
           
            Thread.sleep(2500);
        }

        if(deck01.deckSize() == 0){
            System.out.println();
            System.out.printf("PLAYER %s WON THE GAME! %n", player01.getPlayerName());
            System.out.println();
        }else if (deck01.deckSize() == 0){
            System.out.println();
            System.out.printf("PLAYER %s WON THE GAME! %n", player02.getPlayerName());
            System.out.println();
        }
       
    }

    private int lowestCardDeck(){
        if(player01.getPlayerHand().deckSize() < player02.getPlayerHand().deckSize()){
            return player01.getPlayerHand().deckSize() - 1;
        }else{
            return player02.getPlayerHand().deckSize() - 1;
        }
        
    }

    private void compareRound(){
        switch (deckManager.winCondition(player01Card.value, player02Card.value)) {
            case 1:
                System.out.println();
                System.out.printf("PLAYER %s WON THE ROUND! %n", player01.getPlayerName());
                System.out.printf("ADDING CARD %s to PLAYER %s %n", player01Card, player02.getPlayerName());
                System.out.println("----------------------------------------------------------------------");
                deck01.removeCard(player01Card);
                deck02.addCard(player01Card);
                if(repeatedCards > 0){
                    for (int i = 0; i < storedCards.size(); i++) {
                        if(deck01.cardExits(storedCards.get(i))){
                            deck02.addCard(player01Card);
                        }
                    }

                    repeatedCards = 0;
                }
                break;
            case 0:
                System.out.println();
                System.out.printf("PLAYER %s WON THE ROUND! %n", player02.getPlayerName());
                System.out.printf("ADDING CARD %s to PLAYER %s %n", player02Card, player01.getPlayerName());
                System.out.println("----------------------------------------------------------------------");
                deck02.removeCard(player02Card);
                deck01.addCard(player02Card);
                if(repeatedCards > 0){
                    for (int i = 0; i < storedCards.size(); i++) {
                        if(deck02.cardExits(storedCards.get(i))){
                            deck01.addCard(player01Card);
                        }
                    }

                    repeatedCards = 0;
                }
                break;
            case -1:
                repeatedCards += 2;
                storedCards.add(player01Card);
                storedCards.add(player02Card);
                deck02.removeCard(player01Card);
                deck01.removeCard(player01Card);
                System.out.println("NO ONE WON THIS ROUND, HOLDING CARDS!");
                System.out.println("----------------------------------------------------------------------");
                break;
            default:
                System.out.println("SOMETHING WENT WRONG...");
        }
    }

    private void divideDeck(Deck deckToBreak){

        int fullDeckSize = deckToBreak.deckSize();

        for (int i = 0; i < fullDeckSize / 2; i++) {
            deck01Cards.add(fullDeck.getCardIndex(i));
            deck02Cards.add(fullDeck.getCardIndex(fullDeckSize - i - 1));
        }

        deck01 = new Deck(deck01Cards);
        deck02 = new Deck(deck02Cards);
    }
    
}
