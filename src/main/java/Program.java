import java.util.Scanner;

public class Program {
    static final Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("21 CARD GAME");
            System.out.println("Type: \"play\" to start");
            System.out.println("      \"exit\" to exit");

            String result = scr.next();
            if (result.equals("exit")) {
                return;
            } else if (!result.equals("play")) {
                System.out.println("Incorrect command");
                continue;
            } else {
                System.out.println("Hello, it's 21 card game");
                System.out.println("In this game there are fair players and sharpers");
                System.out.println("Just enter fair players and sharpers count singly");
                System.out.println("They will play by themselves. You just watch the results");
                int fairPlayerCount = parseInt();
                int sharpersCount = parseInt();

                Game game = new Game(fairPlayerCount, sharpersCount);
                game.play();

                for (int i = 0; i < 10; ++i) {
                    System.out.println();
                }
            }

        }
    }

    public static int parseInt() {
        while (!scr.hasNextInt()) {
            System.out.println("Incorrect input. Try to enter a number");
            scr.next();
        }

        return scr.nextInt();
    }
}
