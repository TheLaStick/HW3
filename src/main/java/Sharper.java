public class Sharper extends Player {
    public Sharper(int playerNumber) {
        super(playerNumber);
    }

    public void cheat(Player player, int stolenScore) {
        synchronized (player) {
            if (player.score < stolenScore) {
                player.setScore(0);
                setScore(score + player.score);
                System.out.println(this + " steals " + player.score + " points from " + player);

            } else {
                player.setScore(player.score - stolenScore);
                setScore(score + stolenScore);
                System.out.println(this + " steals " + stolenScore + " points from " + player);

            }
        }
    }

    @Override
    public void run() {
        while ()
        int chooseAction = Constants.rand.nextInt(1, 11);
        if (chooseAction <= 1000) {
            int numberOfPlayer = Constants.rand.nextInt(fairPlayerCount, players.size());
            int stolenScore = Constants.rand.nextInt(Constants.MIN_STEAL_SCORE, Constants.MAX_STEAL_SCORE + 1);
            cheat(players.get(numberOfPlayer), stolenScore);
        } else {
            super.run();
        }
    }

    @Override
    public String toString() {
        return "Sharper " + playerNumber + " with " + score + " score";
    }
}
