package tictactoe.main;


public class Board {

    public static final int SIZE = 3;
    public static final int WIN_STREAK = 3;
    int capacity = 0;
    private Mark[][] board;
    private GameStatus gameStatus;

    private int countMarkInDirection(int row, int col, int rowDelta, int colDelta, Mark mark) {
        int count = 0;
        while (row < SIZE && row >= 0 && col < SIZE && col >= 0 && board[row][col] == mark) {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    }


    private void GameResult(Mark mark, int r, int c) {
        if (this.capacity >= 2 * WIN_STREAK - 1) {
            int sum;

            //for to check win in row
            sum = countMarkInDirection(r, c, 0, 1, mark) + countMarkInDirection(r, c, 0, -1, mark) - 1;
            if (sum >= WIN_STREAK) {
                if (mark == Mark.X) this.gameStatus = GameStatus.X_WIN;
                else this.gameStatus = GameStatus.O_WIN;
                return;
            }


            //for to check win in colum
            sum = countMarkInDirection(r, c, 1, 0, mark) + countMarkInDirection(r, c, -1, 0, mark) - 1;
            if (sum >= WIN_STREAK) {
                if (mark == Mark.X) this.gameStatus = GameStatus.X_WIN;
                else this.gameStatus = GameStatus.O_WIN;
                return;
            }
            //for to check win in /
            sum = countMarkInDirection(r, c, 1, -1, mark) + countMarkInDirection(r, c, -1, 1, mark) - 1;
            if (sum >= WIN_STREAK) {
                if (mark == Mark.X) this.gameStatus = GameStatus.X_WIN;
                else this.gameStatus = GameStatus.O_WIN;
                return;
            }
            //for to check win in \
            sum = countMarkInDirection(r, c, 1, 1, mark) + countMarkInDirection(r, c, -1, -1, mark) - 1;
            if (sum >= WIN_STREAK) {
                if (mark == Mark.X) this.gameStatus = GameStatus.X_WIN;
                else this.gameStatus = GameStatus.O_WIN;
                return;
            }
        }

        if (this.capacity == SIZE * SIZE) gameStatus = GameStatus.DRAW;

    }

    public Board() {
        this.board = new Mark[SIZE][SIZE];
        this.gameStatus = GameStatus.IN_PROGRESS;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = Mark.BLANK;
            }
        }
    }


    public boolean putMark(Mark mark, int row, int col) {
        if (row < SIZE && col < SIZE) {
            if (this.board[row][col] == Mark.BLANK) {
                this.board[row][col] = mark;
                capacity++;
                this.GameResult(mark, row, col);
                return true;
            }
        }
        return false;
    }

    public GameStatus gameStatus() {
        return gameStatus;
    }

    public Mark getMark(int row, int col) {
        return this.board[row][col];
    }

}