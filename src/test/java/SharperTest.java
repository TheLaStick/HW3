import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SharperTest {
    @Test
    public void sharperGetScoreOnSetScore4ShouldReturn4() {
        Sharper sharper = new Sharper(0);
        sharper.setScore(4);
        assertEquals(4, sharper.getScore());
    }

    @Test
    public void sharperCheatOnPlayerWith9ScoreAnd5StolenScoreShouldReturnScoreEquals5() {
        Sharper sharper = new Sharper(0);

        Player player = new Player(1);
        player.setScore(9);

        sharper.cheat(player, 5);
        assertEquals(5, sharper.getScore());
    }
}
