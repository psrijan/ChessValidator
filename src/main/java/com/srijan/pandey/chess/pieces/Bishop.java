package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.util.BoardUtil;

import java.util.ArrayList;
import java.util.List;


public class Bishop extends Piece {
    int[][] direction = {{1,1}, {-1, -1}, {1,-1}, {-1,1}};
    private static final Character PIECE_VAL = 'B';
    /**
     * Takes in a possible direction array and recurses over all possible moves in the board
     * by way of utilizing the directionalArray values.
     * @param boardState
     * @param row
     * @param col
     * @return
     */
    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        List<String> finalRes = new ArrayList<>();
        for (int i = 0; i < direction.length; i++) {
            List<String> result = new ArrayList<>();
            getSubMoves(boardState, row + direction[i][0], col + direction[i][1], direction[i], result);
            finalRes.addAll(result);
        }
        return finalRes;
    }

    @Override
    public char getPieceVal() {
        return PIECE_VAL;
    }

    /**
     * Recursive function for the getMoves, finds all possible combination of moves for a particular
     * piece
     */
    public void getSubMoves(Piece[][] boardState, int row, int col, int[] direction, List<String> result) {
        if (row < 0 || col < 0 || row >= boardState.length || col >= boardState[0].length) // row and col is outside the grid area.
            return;
        Piece boardPiece = boardState[row][col];
        if (boardPiece != null && boardPiece.isBlackPiece() == this.isBlackPiece()) // Steps onto the same player
            return;
        else if (boardPiece != null && boardPiece.isBlackPiece() != this.isBlackPiece()) { // Steps onto a different player. Add Move and return
           result.add(BoardUtil.getUserFriendlyMove(this.getPieceVal(), row, col));
           return;
        }
        // For empty board state add it into the result set and recurse as there might be more empty states in the particular direction
        // Do this until you meet a wall, oponent or a friend.
        result.add(BoardUtil.getUserFriendlyMove(this.getPieceVal(), row, col));
        getSubMoves(boardState, row + direction[0] , col + direction[1], direction, result);
    }


}
