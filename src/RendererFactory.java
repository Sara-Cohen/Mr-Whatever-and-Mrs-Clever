public class RendererFactory {
    public Renderer buildRenderer(String type) {
        switch (type) {
            case "Console":
                return new ConsoleRenderer();
            default:return null;
        }
    }
}
