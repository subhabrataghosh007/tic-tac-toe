package org.example.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
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
        }
    }
}
