package com.arthurfabre.compilerworks.nqueens;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Chess board, that holds Queens.
 */
public class Board {

    /**
     * 
     */
    private final List<Integer> positions;

    private Board(List<Integer> positions) {
        this.positions = positions;
    }

    public boolean valid() {
        // Intersection of diagonals and x axis
        Set<Integer> seenDiagonals = new HashSet<>();

        for (int x = 0; x < positions.size(); x++) {
            int diagonal = x - positions.get(x);

            if (seenDiagonals.contains(diagonal)) {
                return false;
            }

            seenDiagonals.add(diagonal);
        }

        return true;
    }

    /**
     * Lazy generated stream of board permutations 
     * @param size
     * @return 
     */
    public static Stream<Board> permutations(int size) {
        return StreamSupport.stream(((Iterable<Board>)(() -> new Iterator<Board>() {
            @Override
            public boolean hasNext() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Board next() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        })).spliterator(), false);
    }
}