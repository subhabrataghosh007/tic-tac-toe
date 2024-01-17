package play.stategies.bot;

import play.enums.DifficultyLevel;

public class BotDifficultyFactory {

    public static BotPlayerStrategy botPlayerStrategy(DifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY :
                return new EasyBotPlayingStrategy();
            default:
                return null;
        }
    }
}
