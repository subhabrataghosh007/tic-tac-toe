package play.model;

import lombok.Data;
import play.enums.CellState;

import java.util.ArrayList;
import java.util.List;

@Data
public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<>(size));
            for (int j = 0; j < size; j++) {
                board.get(0).add(new Cell(i, j));
            }
        }
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.print("|\t");
            for (int j = 0; j < this.size; j++) {

                if (this.board.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    System.out.print("\t|\t");
                } else {
                    System.out.print(this.board.get(i).get(j).getPlayer().getSymbol() + "\t|\t");
                }
            }
            System.out.println();
        }
    }
}
