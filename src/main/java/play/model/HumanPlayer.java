package play.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class HumanPlayer extends Player {

    private int rank;
    private int age;

}
