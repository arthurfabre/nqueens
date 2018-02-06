package com.arthurfabre.compilerworks.nqueens;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.util.stream.Stream;

/**
 *
 */
public class Main {

    /**
     * Command line parameters.
     */
    private static class Params {
        @Parameter(names = {"-s", "--size"}, description = "Size of chess board in rows / columns")
        private int size = 8;

        @Parameter(names = {"-a", "--all"}, description = "Compute all solutions")
        private boolean all = false;

        @Parameter(names = {"-h", "--help"}, help = true)
        private boolean help;

        /**
         * @return Size of a square chess board in rows / columns.
         */
        public int getSize() {
            return size;
        }

        /**
         * @return True if we should compute all possible solutions, false otherwise.
         */
        public boolean computeAll() {
            return all;
        }

        /**
         * @return True if usage help should be displayed, false otherwise.
         */
        public boolean showHelp() {
            return help;
        }
    }

    public static void main(String[] args) {
        Params params = new Params();
        JCommander paramParser = JCommander.newBuilder().addObject(params).build();
        paramParser.parse(args);

        if (params.showHelp()) {
            paramParser.usage();
            return;
        }

        Stream<Board> valid = Board.permutations(params.getSize()).filter(Board::valid);

        if (params.computeAll()) {
            System.out.println(valid.count());
            return;
        }

        System.out.println(valid.findFirst().orElseThrow(() -> new RuntimeException("No solutions found")));
    }
}