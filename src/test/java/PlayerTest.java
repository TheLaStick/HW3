import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {
    @Test
    public void playerInitGameOn4PlayersShouldHave4Players() {
        List<Player> players = new ArrayList<Player>(4);
        for (int i = 0; i < 4; ++i) {
            players.add(new Player(i));
        }
        Player.initGame(new Deck(), players, 4);
        assertEquals(4, Player.players.size());
    }

    @Test
    public void playerGetScoreOnSetScore4ShouldReturn4() {
        Player player = new Player(0);
        player.setScore(4);
        assertEquals(4, player.getScore());
    }

    @Test
    public void PlayerOnSharperCheatPlayerWith9ScoreAnd5StolenScoreShouldReturnScoreEquals4() {
        Sharper sharper = new Sharper(0);

        Player player = new Player(1);
        player.setScore(9);

        sharper.cheat(player, 5);
        assertEquals(4, player.getScore());
    }
}
