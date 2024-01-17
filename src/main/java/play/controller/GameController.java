package play.controller;

import play.enums.GameState;
import play.model.Game;
import play.model.Player;
import play.service.GameService;
import play.stategies.winning.WinningStrategy;

import java.util.List;
import java.util.Scanner;

public class GameController {

    private Game game;
    private GameService gameService;

    public GameController(Game game, Scanner sc) {
        this.game = game;
        this.gameService = new GameService(game, sc);
    }

    public static Game initiateGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return new Game(dimension, players, winningStrategies);
    }

    public void startGame() {
        game.setGameState(GameState.IN_PROGRESS);
        gameService.executeNextMoves();
    }
}
