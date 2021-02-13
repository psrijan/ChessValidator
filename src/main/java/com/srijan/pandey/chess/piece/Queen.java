package com.srijan.pandey.chess.piece;

import com.srijan.pandey.chess.BoardUtil;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1},{-1,-1}, {1,-1}, {-1,1}};

    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        List<String> moveStringList = new ArrayList<>();
        for (int i = 0; i < direction.length; i++) {
            List<String> result = new ArrayList<>();
            getCurMove(boardState, row, col, direction[i] , result);
            moveStringList.addAll(result);
        }
        return moveStringList;
    }

    public void getCurMove(Piece[][] boardState, int row, int col, int[] direction, List<String> result) {
        Piece curPiece = boardState[row][col];
        if (row < 0 || col < 0 || row >= boardState.length || col >= boardState[0].length)
            return;
        if (curPiece.isPlayerOne() == this.isPlayerOne())
            return;
        else if (curPiece.isPlayerOne() != this.isPlayerOne()) {
            result.add(BoardUtil.getMove(getPieceVal(), row, col));
            return;
        }
        result.add(BoardUtil.getMove(this.getPieceVal(), row , col));
        getCurMove(boardState, row + direction[0], col + direction[1], direction, result);
    }
}
