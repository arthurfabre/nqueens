package com.arthurfabre.compilerworks.nqueens;

import com.beust.jcommander.JCommander;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        Params params = new Params();
        JCommander.newBuilder().addObject(params).build().parse(args);

        NQueens nqueens = new NQueens();
        nqueens.solve(params);
    }
}