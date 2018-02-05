package com.arthurfabre.compilerworks.nqueens;

import com.beust.jcommander.Parameter;

/**
 * Command line parameters
 */
public class Params {
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