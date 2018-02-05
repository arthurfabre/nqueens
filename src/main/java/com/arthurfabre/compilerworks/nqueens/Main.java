package com.arthurfabre.compilerworks.nqueens;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 *
 */
public class Main {

    /**
     * Command line parameters
     */
    private static class Params {
        @Parameter(description = "Size of chess board in rows / columns")
        private int size = 8;

        @Parameter(names = {"-h", "--help"}, help = true)
        private boolean help;

        /**
         * @return Size of a square chess board in rows / columns.
         */
        public int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        Params params = new Params();
        JCommander.newBuilder().addObject(params).build().parse(args);

        NQueens nqueens = new NQueens();
        nqueens.solve(new Board(params.getSize()));
    }
}