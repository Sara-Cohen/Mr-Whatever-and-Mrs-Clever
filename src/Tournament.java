import javax.swing.plaf.synth.SynthListUI;

public class Tournament {

    Player[] players;
    Renderer rendererBoard;
    int numOfRounds;
    int[] score;

    public Tournament(Player player1, Player player2, Renderer rendererBoard, int numOfRounds) {
        this.players = new Player[]{player1, player2};
        this.rendererBoard = rendererBoard;
        this.numOfRounds = numOfRounds;
        this.score = new int[]{0, 0, 0};
    }

    public int[] playTournament() {
        Game myGame;
        GameStatus win;
        for (int i = 0; i < numOfRounds; i++) {
            myGame = new Game(this.players[i % 2], players[(i + 1) % 2], rendererBoard);
            System.out.println("In this round player " + (i % 2 + 1) + " is X and player " + ((i + 1) % 2 + 1) + " is O:");

            win = myGame.run();
            if (i % 2 == 0) {
                if (win == GameStatus.X_WIN) {
                    score[i % 2]++;
                    System.out.println("In this round player " + (i % 2 + 1) + " win");
                } else if (win == GameStatus.O_WIN) {
                    score[(i + 1) % 2]++;
                    System.out.println("In this round player " + ((i + 1) % 2 + 1) + " win");
                } else {
                    score[2]++;
                    System.out.println("In this round Player 1 and 2 both win");
                }

            } else {
                if (win == GameStatus.X_WIN) {
                    score[(i + 1) % 2]++;
                    System.out.println("In this round player " + ((i + 1) % 2 + 1) + " win");

                } else if (win == GameStatus.O_WIN) {
                    score[i % 2]++;
                    System.out.println("In this round player " + (i % 2 + 1) + " win");

                } else {
                    score[2]++;
                    System.out.println("In this round Player 1 and 2 both win");
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.err.println("Error, you must enter 2 players, console and num of rond");
            return;
        }
        PlayerFactory playerFactory = new PlayerFactory();
        RendererFactory rendererFactory = new RendererFactory();
        Player player1 = playerFactory.buildPlayer(args[0]);
        Player player2 = playerFactory.buildPlayer(args[1]);
        if (player1 == null || player2 == null) {
            System.err.println("Error, you must enter valid players");
            return;
        }
        Renderer renderBoard = rendererFactory.buildRenderer(args[2]);
        if (renderBoard == null) {
            System.err.println("Error, you must enter valid renderer board");
            return;
        }
        int numOfRounds = Integer.parseInt(args[3]);
        if (numOfRounds < 1) {
            System.err.println("Error, you must enter 1 or more");
            return;
        }
        Tournament tournament = new Tournament(player1, player2, renderBoard, numOfRounds);
        tournament.playTournament();
        System.out.println("the result is:");
        System.out.println("score player 1: " + tournament.score[0]);
        System.out.println("score player 2: " + tournament.score[1]);
        System.out.println("score teko: " + tournament.score[2]);

        if (tournament.score[0] > tournament.score[1])
            System.out.println("player 1 win");
        else if (tournament.score[1] > tournament.score[0])
            System.out.println("player 2 win");
        else
            System.out.println("Teko!!");
    }
}
