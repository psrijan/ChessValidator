package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.util.BoardUtil;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    int[][] direction = {{1,0}, {0,1}, {-1, 0}, {0,-1}};
    private static final Character PIECE_VAL = 'R';

    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        List<String> resList = new ArrayList<>();
       for (int i = 0; i < direction.length; i++) {
           List<String> result = new ArrayList<>();
           getCurMoves(boardState, row, col, direction[i], result);
           resList.addAll(result);
       }
       return  resList;
    }

    @Override
    public char getPieceVal() {
        return PIECE_VAL;
    }

    public void getCurMoves (Piece[][] boardState, int row, int col,int[] direction, List<String> result) {
       Piece curPiece = boardState[row][col];
       if (row < 0 || col < 0 || row >= boardState.length || col >= boardState[0].length)
           return;
       if (curPiece != null && curPiece.isBlackPiece() == isBlackPiece())
          return;
       if (curPiece != null && curPiece.isBlackPiece() != isBlackPiece()) {
           result.add(BoardUtil.getUserFriendlyMove(getPieceVal(), row, col));
           return;
       }
       result.add(BoardUtil.getUserFriendlyMove(getPieceVal(), row, col));
       getCurMoves(boardState, row + direction[0], col + direction[1], direction, result);
    }

}
