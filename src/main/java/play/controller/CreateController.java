package play.controller;

import play.enums.DifficultyLevel;
import play.enums.PlayerType;
import play.model.BotPlayer;
import play.model.HumanPlayer;
import play.model.Player;
import play.stategies.bot.BotDifficultyFactory;

public class CreateController {

    public static Player createHumanPlayer(String name, char symbol) {
        return HumanPlayer.builder()
                .name(name)
                .symbol(symbol)
                .playerType(PlayerType.HUMAN)
                .build();
    }

    public static Player createBotPlayer(String name, char symbol, DifficultyLevel difficultyLevel) {
        return BotPlayer.builder()
                .name(name)
                .symbol(symbol)
                .playerType(PlayerType.BOT)
                .difficultyLevel(difficultyLevel)
                .botPlayerStrategy(BotDifficultyFactory.botPlayerStrategy(difficultyLevel))
                .build();
    }
}
