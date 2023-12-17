package tictactoe.main;

import tictactoe.renderer.Renderer;
import tictactoe.player.Player;

public class Game {

    private Player humanPlayerX;
    private Player humanPlayerO;
    private Renderer renderBoard;


    public Game(Player _Human_playerX, Player _Human_playerO, Renderer _renderer) {
        this.humanPlayerX = _Human_playerX;
        this.humanPlayerO = _Human_playerO;
        this.renderBoard = _renderer;
    }

    public GameStatus run() {
        Mark mark = Mark.X;
        Board board = new Board();
        while (board.gameStatus() == GameStatus.IN_PROGRESS) {
            this.renderBoard.renderBoard(board);
            this.humanPlayerX.playTurn(board, Mark.X);
            if (board.gameStatus() == GameStatus.IN_PROGRESS) {
                this.renderBoard.renderBoard(board);
                this.humanPlayerO.playTurn(board, Mark.O);
            }
        }
        this.renderBoard.renderBoard(board);
        return board.gameStatus();
    }

}
