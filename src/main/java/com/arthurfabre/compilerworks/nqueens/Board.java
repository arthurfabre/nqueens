package com.arthurfabre.compilerworks.nqueens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Chess board, that holds Queens.
 */
public class Board {

    private final List<List<Boolean>> queens;

    public Board(int size) {
        queens = new ArrayList<>(Collections.nCopies(size, new ArrayList<>(Collections.nCopies(size, false))));
    }

    /**
     * Place a queen.
     * @param x Column
     * @param y Row
     */
    public void place(int x, int y) {
        queens.get(x).set(y, true);
    }

    /**
     * @return Size of board in columns / rows.
     */
    public int size() {
        return queens.size();
    }
}