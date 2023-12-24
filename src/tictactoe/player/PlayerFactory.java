package tictactoe.player;

public class PlayerFactory {

    public Player buildPlayer(String type) {
        switch (type) {
            case "Human":
                return new HumanPlayer();
            case "Whatever":
                return new WhateverPlayer();
            case "Clever":
                return new CleverPlayer();
            default:
                return null;
        }
    }
}
