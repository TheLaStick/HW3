import java.util.List;
import java.util.concurrent.TimeUnit;

public class Player implements Runnable {
    public static Deck deck;
    public static int fairPlayerCount;
    public static List<Player> players;
    public static boolean gameIsOn;

    protected int score;
    protected int playerNumber;

    static void initGame(Deck gameDeck, List<Player> playersInGame, int fairPlayerCount) {
        deck = gameDeck;
        players = playersInGame;
        Player.fairPlayerCount = fairPlayerCount;
        gameIsOn = true;
    }

    public Player(int playerNumber) {
        this.score = 0;
        this.playerNumber = playerNumber;
    }

    public synchronized int getScore() {
        return score;
    }

    protected synchronized void setScore(int score) {
        this.score = score;
    }

    @Override
    public void run() {
        while (gameIsOn) {
            int topDeck = deck.getTopDeck();
            synchronized (this) {
                System.out.println(this + " draws a card with " + topDeck + " points");
                score += topDeck;
            }

            int timeSleep = Constants.rand.nextInt(Constants.MIN_TIME_SLEEP, Constants.MAX_TIME_SLEEP + 1);
            try {
                TimeUnit.MILLISECONDS.sleep(timeSleep);
            } catch (InterruptedException e) {
                System.out.println("player stopped drawing cards");
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Player " + playerNumber + " with " + score + " score";
    }
}
