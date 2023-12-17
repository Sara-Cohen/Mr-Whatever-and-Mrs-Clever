package tictactoe.player;

public class PlayerFactory {

    public Player buildPlayer(String type) {
        switch (type) {
            case "Human":
                return new HumanPlayer();
            default:
                return null;    }}
}
