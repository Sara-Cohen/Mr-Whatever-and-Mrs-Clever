package tictactoe.main;//import javax.swing.plaf.synth.SynthListUI;

import tictactoe.player.Player;
import tictactoe.player.PlayerFactory;
import tictactoe.renderer.Renderer;
import tictactoe.renderer.RendererFactory;


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
            System.out.printf("\nIn the round #%d player %d  is X and player %d is O:\n",
                    (i + 1), (i % 2 + 1), ((i + 1) % 2 + 1));
            win = myGame.run();
            if (i % 2 == 0)
                checkWinner(win, 0, 1);
            else
                checkWinner(win, 1, 0);
        }
        return score;
    }

    private void checkWinner(GameStatus win, int player1, int player2) {
        if (win == GameStatus.X_WIN) {
            score[player1 % 2]++;
            System.out.printf("In this round player %d win\n",player1+1);
        } else if (win == GameStatus.O_WIN) {
            score[(player2) % 2]++;
            System.out.printf("In this round player %d win\n",player2+1);
        } else {
            score[2]++;
            System.out.println("In this round tictactoe.player.Player 1 and 2 both win\n");
        }
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
        System.out.printf("The tournament result:\nscore player 1:%d\nscore player 2:%d\nscore draw:%d\nthe winner is:",
                tournament.score[0], tournament.score[1], tournament.score[2]);
        if (tournament.score[0] > tournament.score[1])
            System.out.println("player 1 ");
        else if (tournament.score[1] > tournament.score[0])
            System.out.println("player 2 ");
        else
            System.out.println("draw!!");
    }
}
