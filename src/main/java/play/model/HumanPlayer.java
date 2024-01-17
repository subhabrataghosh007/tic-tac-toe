package play.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import play.enums.CellState;

import java.util.Scanner;

@Data
@SuperBuilder
public class HumanPlayer extends Player {

    private int rank;
    private int age;

    @Override
    public Cell nextMove(Board board) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the row:");
        int row = scanner.nextInt();
        System.out.println("Please enter the column:");
        int col = scanner.nextInt();

        Cell cell = board.getBoard().get(row).get(col);
        cell.setPlayer(this);
        cell.setCellState(CellState.OCCUPIED);
        return cell;
    }
}
