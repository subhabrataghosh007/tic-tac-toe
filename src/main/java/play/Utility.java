package play;

import play.enums.CellState;
import play.model.Board;
import play.model.Game;

public class Utility {

    public static boolean isEmptyCellAvailable(Game game) {
        Board board = game.getBoard();
        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.getBoard().get(i).get(j).getCellState() == CellState.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }
}
