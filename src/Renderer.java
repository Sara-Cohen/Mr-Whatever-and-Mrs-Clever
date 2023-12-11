

public interface Renderer {

    void renderBoard(Board board);

    void drawMarkInBuffer(int rowStart, int colStart, Mark mark);
}
