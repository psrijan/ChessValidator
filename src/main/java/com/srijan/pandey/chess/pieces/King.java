package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.util.BoardUtil;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    private static final Character PIECE_VAL= 'K';

    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        int[][] direction = {{1,0}, {0, 1}, {-1,0}, {0, -1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}};
        List<String> moveStringList = new ArrayList<>();
        for (int i = 0; i < direction.length; i++) {
            int[] nextState = {row + direction[i][0], col + direction[i][1]};
            if (nextState[0] < 0 || nextState[1] < 0 || nextState[1] > 7 || nextState[0] > 7)
                continue;
            if (boardState[nextState[0]][nextState[1]] != null && boardState[nextState[0]][nextState[1]].isBlackPiece() == this.isBlackPiece())
                continue;
            String moveStr = BoardUtil.getUserFriendlyMove(getPieceVal(), nextState[0], nextState[1]);
            moveStringList.add(moveStr);
        }
        return moveStringList;
    }

    @Override
    public char getPieceVal() {
        return PIECE_VAL;
    }
}
