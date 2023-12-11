import javax.swing.plaf.synth.SynthListUI;

public class Tournament {

    Player[] players;
    Renderer rendererBoard;
    int numOfRounds;
    int[] score ;
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
            myGame = new Game(this.players[i%2],players[(i+1)%2], rendererBoard);
            win = myGame.run();

            if (i % 2 == 0) {
                if (win == GameStatus.X_WIN)
                    score[i%2]++;
                else if (win == GameStatus.O_WIN)
                    score[(i+1)%2]++;
                else
                    score[2]++;
            } else {
                if (win == GameStatus.X_WIN)
                    score[(i+1)%2]++;
                else if (win == GameStatus.O_WIN)
                    score[i%2]++;
                else
                    score[2]++;
            }
            System.out.println("In this around the winner is  " + win);
        }
        return score;
    }

    public static void main(String[] args) {
        PlayerFactory playerFactory = new PlayerFactory();
        RendererFactory rendererFactory = new RendererFactory();
        Player player1 = playerFactory.buildPlayer("Human");
        Player player2 = playerFactory.buildPlayer("Human");
        Renderer renderBoard = rendererFactory.buildRenderer("Console");
        int numOfRounds = 2;
        Tournament tournament = new Tournament(player1, player2, renderBoard, numOfRounds);
        tournament.playTournament();
        System.out.println("score player 1: "+tournament.score[0]);
        System.out.println("score player 2: "+tournament.score[1]);
        System.out.println("score teko: "+tournament.score[2]);

        if (tournament.score[0]>tournament.score[1])
            System.out.println("player 1 win");
        else if (tournament.score[1]>tournament.score[0])
            System.out.println("player 2 win");
        else
            System.out.println("Teko!!");


    }

}
