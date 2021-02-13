package com.srijan.pandey.chess.piece;

import com.srijan.pandey.chess.BoardUtil;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    int[][] direction = {{0, 1}, {1,0}};
    int[][] specialDirection = {{1,1}, {1,-1}, {-1,1}, {-1,-1}};

    /**
     * 1 step forward if no enemy
     * 2 step forward during start if no enemy
     * if enemy then can only move in angles.
     * @param boardState
     * @param row
     * @param col
     * @return
     */
    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        List<String> result = new ArrayList<>();
        int[] curDir = direction[isPlayerOne()? 0 : 1];
        int[] curSpecDir = specialDirection[(isPlayerOne() ? 0 : 1) * 2];
        int r1 = row + curDir[0];
        int c1 = row + curDir[1];

        Piece p1 = boardState[r1][c1];

        if (p1 == null)
           result.add(BoardUtil.getMove(getPieceVal(), row, col));

        r1 = row + curSpecDir[0];
        c1 = col + curSpecDir[1];

        p1 = boardState[r1][c1];

        if (p1.isPlayerOne() != isPlayerOne())
            result.add(BoardUtil.getMove(getPieceVal(), row, col));

        r1 = row + specialDirection[(isPlayerOne() ? 0 : 1) * 2 + 1][0];
        c1 = col + specialDirection[(isPlayerOne()? 0 : 1) * 2 + 1][1];

        p1 = boardState[r1][c1];
        if (p1.isPlayerOne() != isPlayerOne())
           result.add(BoardUtil.getMove(getPieceVal(), row, col));
        return result;
    }

}
