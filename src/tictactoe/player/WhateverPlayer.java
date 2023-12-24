package tictactoe.player;

import tictactoe.main.Board;
import tictactoe.main.Mark;

import java.util.Random;

public  class WhateverPlayer implements Player {
    private Random random=new Random();
@Override
    public void playTurn(Board board, Mark mark) {
        while (true) {
            if (board.putMark(mark, random.nextInt(board.SIZE), random.nextInt(board.SIZE)))
                return;

        }
    }
}
