import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @Test
    public void gameConstructorOn2PlayersAnd2SharpersShouldHave4PlayersAnd2Sharpers() {
        Game game = new Game(2, 2);

        assertEquals(4, game.players.size());
        assertEquals(2, game.sharperCount);
    }

    @Test
    public void gameConstructorOnZeroPlayersAndZeroSharpersShouldHave1PlayerAndZeroSharper() {
        Game game = new Game(0, 0);

        assertEquals(1, game.players.size());
        assertEquals(0, game.sharperCount);
    }

    @Test
    public void gamePrintWinnersOnTwoPlayersWithSameMaScoreShouldPrintThoseTwoPlayers() {
        Game game = new Game(4, 1);

        game.players.get(2).score = 100;
        game.players.get(3).score = 100;

        game.printPlayersWithWinners();

        assertEquals(5, game.totalPlayerCount);
    }
}
