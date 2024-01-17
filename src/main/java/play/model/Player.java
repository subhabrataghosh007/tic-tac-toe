package play.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import play.enums.PlayerType;

@Data
@SuperBuilder
public abstract class Player {

    private String name;
    private char symbol;
    private PlayerType playerType;

    public abstract Cell nextMove(Board board);
}
