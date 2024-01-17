package play.model;

import lombok.Data;
import play.enums.GameState;
import play.stategies.winning.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int nextPlayerIndex;
    private GameState gameState;
    private  Player winner;
    private List<WinningStrategy> winningStrategies;

    public Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.gameState = GameState.INIT;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
    }
}
