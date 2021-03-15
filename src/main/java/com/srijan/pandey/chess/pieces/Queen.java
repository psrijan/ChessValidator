package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.util.BoardUtil;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    // Queen can move in any direction along a stright line
    int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}, {1,1},{-1,-1}, {1,-1}, {-1,1}};
    private static final Character PIECE_VAL = 'Q';
    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        List<String> moveStringList = new ArrayList<>();
        for (int i = 0; i < direction.length; i++) {
            List<String> result = new ArrayList<>();
            getCurMove(boardState, row + direction[i][0], col + direction[i][1], direction[i] , result);
            moveStringList.addAll(result);
        }
        return moveStringList;
    }

    @Override
    public char getPieceVal() {
        return PIECE_VAL;
    }

    private void getCurMove(Piece[][] boardState, int row, int col, int[] direction, List<String> result) {
        if (row < 0 || col < 0 || row >= boardState.length || col >= boardState[0].length)
            return;
        Piece curPiece = boardState[row][col];
        if (curPiece == null) {
            System.out.printf("null adding at %s \n" , BoardUtil.getUserFriendlyMove('T', row , col));
            result.add(BoardUtil.getUserFriendlyMove(this.getPieceVal(), row , col));
            getCurMove(boardState, row + direction[0], col + direction[1], direction, result);
        } else if (curPiece.isBlackPiece() == this.isBlackPiece())
            return;
        else if (curPiece.isBlackPiece() != this.isBlackPiece()) {
            System.out.println("Cur Piece : " + BoardUtil.getUserFriendlyMove(curPiece.getPieceVal(), row, col));
            System.out.println("adding 2");
            result.add(BoardUtil.getUserFriendlyMove(getPieceVal(), row, col));
        }
    }



}
