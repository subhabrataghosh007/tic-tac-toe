package org.example.model;

import lombok.Data;

import java.util.List;

@Data
public class Move {
    private Cell cell;
    private Player player;
}
