package play.stategies.bot;

import play.model.Board;
import play.model.Cell;

public interface BotPlayerStrategy {
    Cell suggestMove(Board board);
}
