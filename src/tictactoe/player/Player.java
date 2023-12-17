package tictactoe.player;

import tictactoe.main.Board;
import tictactoe.main.Mark;

public interface Player {
    void playTurn(Board board, Mark mark);
}
