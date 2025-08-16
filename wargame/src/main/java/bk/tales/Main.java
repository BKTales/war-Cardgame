package bk.tales;

/**
 * Hello world!
 *
 */
public class Main 
{ 
    public static void main( String[] args )
    {
        DeckManager deckManager = new DeckManager();
        Deck deck = deckManager.createDeck();

        System.out.println("This is my deck:");

        System.out.println(deck);
    }
}
