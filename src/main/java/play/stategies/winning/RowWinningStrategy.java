package play.stategies.winning;

import play.enums.CellState;
import play.model.Board;
import play.model.Cell;
import play.model.Player;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Cell currentCell, Board board) {
        Player currentPlayer = currentCell.getPlayer();
        int size = board.getSize();
        int currentRow = currentCell.getRow();

        for (int i = 0; i < size; i++) {
            Cell cell = board.getBoard().get(currentRow).get(i);
            if (cell.getCellState() == CellState.EMPTY || !cell.getPlayer().equals(currentPlayer)) {
                return false;
            }
        }
        return true;
    }
}
