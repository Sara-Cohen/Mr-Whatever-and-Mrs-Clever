package tictactoe.main;

import tictactoe.renderer.Renderer;
import tictactoe.player.Player;

public class Game {

    private Player playerX;
    private Player playerO;
    private Renderer renderBoard;


    public Game(Player _playerX, Player _playerO, Renderer _renderer) {
        this.playerX = _playerX;
        this.playerO = _playerO;
        this.renderBoard = _renderer;
    }

    public GameStatus run() {
        Mark mark = Mark.X;
        Board board = new Board();
        while (board.gameStatus() == GameStatus.IN_PROGRESS) {
            this.renderBoard.renderBoard(board);
            this.playerX.playTurn(board, Mark.X);
            if (board.gameStatus() == GameStatus.IN_PROGRESS) {
                this.renderBoard.renderBoard(board);
                this.playerO.playTurn(board, Mark.O);
            }
        }
        this.renderBoard.renderBoard(board);
        return board.gameStatus();
    }

}
