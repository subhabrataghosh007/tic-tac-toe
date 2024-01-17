package play.service;

import play.Utility;
import play.enums.GameState;
import play.model.Cell;
import play.model.Game;
import play.model.Move;
import play.model.Player;
import play.stategies.winning.WinningStrategy;

import java.util.Scanner;

public class GameService {

    private Game game;
    private Scanner sc;

    public GameService(Game game, Scanner sc) {
        this.game = game;
        this.sc = sc;
    }

    public void executeNextMoves() {

        while (Utility.isEmptyCellAvailable(game)) {
            Player currentPlayer = game.getPlayers().get(game.getNextPlayerIndex());
            System.out.printf("It's %s move...\n", currentPlayer.getName());

            Cell cell = currentPlayer.nextMove(game.getBoard());

            game.getMoves().add(new Move(cell, currentPlayer));
            game.getBoard().print();

            for (WinningStrategy winningStrategy: game.getWinningStrategies()) {
                if (winningStrategy.checkWin(cell, game.getBoard())) {
                    game.setGameState(GameState.SUCCESS);
                    System.out.printf("Player %s won!!!", currentPlayer.getName());
                    return;
                }
            }

            int nextPlayerIndex = (game.getNextPlayerIndex() + 1) % game.getPlayers().size();
            game.setNextPlayerIndex(nextPlayerIndex);
        }

        if (!game.getGameState().equals(GameState.SUCCESS)) {
            game.setGameState(GameState.DRAW);
            System.out.println("No more cells to play, and hence game draw.");
        }
    }

}
