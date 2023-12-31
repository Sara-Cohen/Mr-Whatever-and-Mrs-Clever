package tictactoe.player;

import tictactoe.main.Board;
import tictactoe.main.Mark;


public class CleverPlayer implements Player {
    @Override
    public void playTurn(Board board, Mark mark) {
        for (int i = 0; i < Board.SIZE; i++)
            for (int j = 0; j < Board.SIZE; j++)
                if (board.putMark(mark, i, j))
                    return;
    }
}