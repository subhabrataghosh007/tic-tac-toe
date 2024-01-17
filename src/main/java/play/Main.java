package play;

import play.controller.CreateController;
import play.controller.GameController;
import play.enums.DifficultyLevel;
import play.model.Game;
import play.model.HumanPlayer;
import play.model.Player;
import play.stategies.winning.ColumnWinningStrategy;
import play.stategies.winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("||Welcome to the Tic Tac Toe game||");
        System.out.println("------Let's start playing------");
        System.out.println("How many players would be playing?");

        Scanner sc = new Scanner(System.in);
        int noOfPlayers = sc.nextInt();

        System.out.println("Enter the dimension for the board.");
        int dimension = sc.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < noOfPlayers; i++) {
            System.out.println("Please Enter Details of Player " + (i +1));
            System.out.println("Name:");
            String name = sc.next();

            System.out.println("Symbol:");
            String symbol = sc.next();

            System.out.println("Is this player a BOT? (Y/N)");

            if (sc.next().equals("Y")) {
                System.out.println("What's the level of the bot? (E/M/H)");
                String level = sc.next();
                DifficultyLevel difficultyLevel;
                switch (level) {
                    case "E":
                        difficultyLevel = DifficultyLevel.EASY;
                        break;
                    case "H":
                        difficultyLevel = DifficultyLevel.HARD;
                        break;
                    default:
                        difficultyLevel = DifficultyLevel.MEDIUM;
                }
                players.add(CreateController.createBotPlayer(name, symbol.charAt(0), difficultyLevel));
            } else {
                players.add(CreateController.createHumanPlayer(name, symbol.charAt(0)));
            }
        }

        Game game = GameController.initiateGame(dimension, players, Arrays.asList(new RowWinningStrategy(), new ColumnWinningStrategy()));

        System.out.println("Are you ready to start the game? (Y/N)");
        if (sc.next().equalsIgnoreCase("Y")) {
            GameController gc = new GameController(game, sc);
            gc.startGame();
        }

//        Game game = new Game(3, players, null);
//        game.getBoard().print();





    }
}