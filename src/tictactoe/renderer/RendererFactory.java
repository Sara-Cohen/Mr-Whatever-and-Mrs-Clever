package tictactoe.renderer;


public class RendererFactory {
    public Renderer buildRenderer(String type) {
        switch (type) {
            case "Console":
                return new ConsoleRenderer();
            case "none":
                return new  VoidRenderer();
            default:return null;
        }
    }
}
