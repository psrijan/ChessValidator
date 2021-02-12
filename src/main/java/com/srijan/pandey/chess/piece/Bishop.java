package com.srijan.pandey.chess.piece;

import com.srijan.pandey.chess.BoardUtil;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    int[][] direction = {{1,1}, {-1, -1}, {1,-1}, {-1,1}};

    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        List<String> finalRes = new ArrayList<>();
        for (int i = 0; i < direction.length; i++) {
            List<String> result = new ArrayList<>();
            getSubMoves(boardState, row, col, direction[i], result);
            finalRes.addAll(result);
        }
        return finalRes;
    }

    public void getSubMoves(Piece[][] boardState, int row, int col, int[] direction, List<String> result) {
        Piece boardPiece = boardState[row][col];
        if (row < 0 || col < 0 || row >= boardState.length || col >= boardState[0].length)
            return;
        if (boardPiece != null && boardPiece.isPlayerOne() == this.isPlayerOne())
            return;
        else if (boardPiece != null && boardPiece.isPlayerOne() != this.isPlayerOne()) {
           result.add(BoardUtil.getMove(this.getPieceVal(), row, col));
           return;
        }
        result.add(BoardUtil.getMove(this.getPieceVal(), row, col));
        getSubMoves(boardState, row + direction[i][0] , col + direction[i][1], result);
    }
}
