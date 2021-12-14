import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game {
    List<Player> players;
    int totalPlayerCount;
    int fairPlayerCount;
    int sharperCount;
    Deck deck;

    public Game(int fairPlayerCount, int sharperCount) {
        if (fairPlayerCount <= 0) {
            System.out.println("player count must be higher than zero");
            System.out.println("changing player count to 1");
            fairPlayerCount = 1;
        }

        deck = new Deck();
        this.totalPlayerCount = sharperCount + fairPlayerCount;
        this.sharperCount = sharperCount;
        this.fairPlayerCount = fairPlayerCount;

        players = new ArrayList<Player>(totalPlayerCount);
        for (int i = 0; i < totalPlayerCount; ++i) {
            if (i < sharperCount) {
                players.add(new Sharper(i));
                continue;
            }
            players.add(new Player(i));
        }

        Player.initGame(deck, players, fairPlayerCount);
    }

    public void play() {
        Thread[] threads = new Thread[totalPlayerCount];

        for (int i = 0; i < totalPlayerCount; ++i) {
            threads[i] = new Thread(players.get(i));
            threads[i].start();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
            Player.gameIsOn = false;
            for (int i = 0; i < totalPlayerCount; ++i) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printPlayersWithWinners();
    }

    public void printPlayersWithWinners() {
        System.out.println("______________________________________________________________");
        players.sort(Comparator.comparing(Player::getScore).reversed());

        int winningResult = players.get(0).getScore();
        for (int i = 0; i < players.size(); ++i) {
            Player currentPlayer = players.get(i);
            if (winningResult == currentPlayer.score) {
                System.out.println(currentPlayer + " won! WINNER WINNER CHICKEN DINNER!");
                continue;
            }
            System.out.println(currentPlayer);
        }
    }
}
