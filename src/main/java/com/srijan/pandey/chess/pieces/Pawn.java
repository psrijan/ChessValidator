package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.util.BoardUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Pawn class.
 * IMPORTANT NOTE: Since the pawns are directional movers, the black pieces will start from row 8 and 7
 * and the white pieces will start from row 0 and 1.
 *
 * IMPORTANT NOTE: Pawn in this chess validation engine will not be able to do the initial two square advance at the start of
 * the chess match
 */
public class Pawn extends Piece {

    private static final Character PIECE_VAL = 'P';
    int[][] direction = {{-1, 0}, {1,0}}; // when there is no enemy only move a step forward 1st Index - Black Piece Direction, 2nd Index - White Piece direction
    int[][] specialDirection = {{-1,1}, {-1,-1}, {1,1}, {1,-1}}; // when there is an enemy then move to the right side depending on if you are black or white pawn piece

    /**
     * Get Moves for a pawn
     * 1 step forward if no enemy
     * 2 step forward during start if no enemy
     * if enemy then can only move in angles.
     * @param boardState Current Board State
     * @param row Row index of the Pawn
     * @param col Col index of the Pawn
     * @return list of possible moves
     */
    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        List<String> result = new ArrayList<>();
        // Choices direction index 0 for black and 1 for white piece.
        // This is normal move when the Pawn moves in a stright line
        int[] curDir = direction[isBlackPiece()? 0 : 1];

        /* Choose direction index 0 and 1 for black piece
        * and index 2 and 3 for white piece. This is handled
        * by having start index start from either 0 or 2
        */
        int[] curSpecDir = specialDirection[(isBlackPiece() ? 0 : 1) * 2];
        Piece p1;

        // Add the move if the normal moved index doesn't have any white or black players.
        int r1 = row + curDir[0];
        int c1 = col + curDir[1];
        if (isValidIndex(r1,c1)) {
            p1 = boardState[r1][c1];
            if (p1 == null)
                result.add(BoardUtil.getUserFriendlyMove(getPieceVal(), r1, c1));
        }

        // Add the move for special direction if there if board
        r1 = row + curSpecDir[0];
        c1 = col + curSpecDir[1];
        if (isValidIndex(r1,c1)) {
            p1 = boardState[r1][c1];
            // check if not null and p1 is different piece than the current piece
            if (p1 != null && p1.isBlackPiece() != isBlackPiece())
                result.add(BoardUtil.getUserFriendlyMove(getPieceVal(), r1, c1));
        }

        // Repeat the same process for the second special directional move
        r1 = row + specialDirection[(isBlackPiece() ? 0 : 1) * 2 + 1][0];
        c1 = col + specialDirection[(isBlackPiece()? 0 : 1) * 2 + 1][1];
        if(isValidIndex(r1, c1)) {
            p1 = boardState[r1][c1];
            if (p1 != null && p1.isBlackPiece() != isBlackPiece())
                result.add(BoardUtil.getUserFriendlyMove(getPieceVal(), r1, c1));
        }

        return result;
    }

    private boolean isValidIndex(int row, int col) {
        return (row >= 0 && row < 8) && (col >= 0 && col < 8);
    }

    @Override
    public char getPieceVal() {
        return PIECE_VAL;
    }


}
