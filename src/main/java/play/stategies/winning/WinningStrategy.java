package play.stategies.winning;

import play.model.Board;
import play.model.Cell;

public interface WinningStrategy {

    boolean checkWin(Cell cell, Board board);
}
