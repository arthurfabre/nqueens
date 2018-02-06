package com.arthurfabre.compilerworks.nqueens;

import com.google.common.collect.Collections2;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Chess board, that holds Queens.
 */
public class Board {

    /**
     * List of row number of Queen for every column.
     * Ensures one Queen per column.
     * An ordered set would ensure one Queen per row, but the interface is a bit nasty.
     */
    private final List<Integer> positions;

    private Board(List<Integer> positions) {
        this.positions = positions;
    }

    /**
     * Check if the layout of a board is valid
     * @return 
     */
    public boolean valid() {
        // Instersaction of diagonals and x axis (which is mirrored for the 2nd set)
        return checkDiag(x -> x - positions.get(x)) && checkDiag(x -> (positions.size() - x) - positions.get(x));
    }

    /**
     * Check the diagonal of every Queen is unique.
     * @param diag Lambda that computes the diagonal from the index.
     * @return True if every Queen has a unique diagonal, false otherwise.
     */
    private boolean checkDiag(IntUnaryOperator diag) {
        return IntStream.range(0, positions.size()).map(diag).distinct().count() == positions.size();
    }

    /**
     * ASCII board representation.
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int r = 0; r < positions.size(); r++) {
            for (int c = 0; c < positions.size(); c++) {
                str.append(positions.get(c).equals(r) ? "x" : ".").append(" ");
            }
            str.append(System.lineSeparator());
        }
        return str.toString();
    }

    /**
     * Lazy generated stream of board permutations 
     * @param size Size of board in rows / cols
     * @return Possible permutations with a unique queen per row & column.
     */
    public static Stream<Board> permutations(int size) {
        // The collection returned from Guava is actually lazy generated
        return Collections2.permutations(IntStream.range(0, size).boxed().collect(Collectors.toList())).stream().map(p -> new Board(p));
    }
}