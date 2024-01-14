package org.example.model;

import org.example.stategies.winning.WinningStrategy;

import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int nextPlayerIndex;
    private GameState gameState;
    private  Player winner;
    private List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.board = new Board(dimension);
        this.gameState = GameState.INIT;
        this.nextPlayerIndex = 0;
    }
}
