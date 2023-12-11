public class Tournament {


    public void playTournament(Player player1, Player player2, Renderer rendererBoard, int numOfRounds) {
        Game myGame;
        int player1Winn=0,player2Winn=0;
        GameStatus winn;
        for (int i = 0; i < numOfRounds; i++) {
            if (i % 2 == 0) {
                myGame = new Game(player1, player2, rendererBoard);

                winn=myGame.run();
                if (winn==GameStatus.X_WIN)
                    player1Winn++;
                else if (winn==GameStatus.O_WIN)
                    player2Winn++;
            } else {
                myGame = new Game(player2, player1, rendererBoard);
                winn=myGame.run();
                if (winn==GameStatus.O_WIN)
                    player1Winn++;
                else if (winn==GameStatus.X_WIN)
                    player2Winn++;
            }
            System.out.println("In this around the winner is  " + winn);

        }
        if (player1Winn>player2Winn)
            System.out.println("The Player1 Winn!");
        else if     (player2Winn>player1Winn)
            System.out.println("The Player2 Winn!");
        else
            System.out.println("You both Winn!");

    }

    public static void main(String[] args) {
        PlayerFactory playerFactory = new PlayerFactory();
        RendererFactory rendererFactory = new RendererFactory();
        Player player1 = playerFactory.buildPlayer("Human");
        Player player2 = playerFactory.buildPlayer("Human");
        Renderer renderBoard = rendererFactory.buildRenderer("Console");
        int numOfRounds = 2;
        Tournament tournament = new Tournament();
        tournament.playTournament(player1, player2, renderBoard, numOfRounds);

    }


}
