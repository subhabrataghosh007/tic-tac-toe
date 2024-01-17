package play.stategies.bot;

import play.enums.CellState;
import play.model.Board;
import play.model.Cell;

public class EasyBotPlayingStrategy implements BotPlayerStrategy {

    @Override
    public Cell suggestMove(Board board) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getBoard().get(i).get(j).getCellState() == CellState.EMPTY) {
                    return board.getBoard().get(i).get(j);
                }
            }
        }
        return null;
    }
}
