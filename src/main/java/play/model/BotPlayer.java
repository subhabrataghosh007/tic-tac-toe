package play.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import play.enums.CellState;
import play.enums.DifficultyLevel;
import play.stategies.bot.BotPlayerStrategy;

@Data
@SuperBuilder
public class BotPlayer extends Player {

    private DifficultyLevel difficultyLevel;
    private BotPlayerStrategy botPlayerStrategy;

    @Override
    public Cell nextMove(Board board) {
        Cell cell = botPlayerStrategy.suggestMove(board);
        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);
        return cell;
    }
}
