package tictactoe.player;

import tictactoe.main.Board;
import tictactoe.main.Mark;


import java.util.Scanner;

public class HumanPlayer implements Player {

    private Scanner in = new Scanner(System.in);
@Override
    public void playTurn(Board board, Mark mark) {
        while (true) {
            System.out.println("Choose cordinate of " + mark);
            int cor = in.nextInt();
            if (board.putMark(mark, (cor / 10) - 1, (cor % 10) - 1))
                return;

        }
    }
}
