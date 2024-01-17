package play.stategies.winning;

import play.model.Board;
import play.model.Cell;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWin(Cell cell, Board board) {
        return false;
    }
}
