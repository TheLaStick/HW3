import java.util.Random;

public class Deck {
    private int topDeck;

    public Deck() {
        topDeck = Constants.rand.nextInt(Constants.MIN_CARD_VALUE, Constants.MAX_CARD_VALUE + 1);
    }

    synchronized int getTopDeck() {
        int card = topDeck;
        topDeck = Constants.rand.nextInt(Constants.MIN_CARD_VALUE, Constants.MAX_CARD_VALUE + 1);
        return card;
    }
}
