package com.srijan.pandey.chess.piece;

import com.srijan.pandey.chess.BoardUtil;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{
    private int[][] direction = {{2,1}, {-2,1}, {-2, -1}, {2, -1}};
    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        List<String> moveStringList = new ArrayList<>();
        for (int i = 0; i < direction.length; i++) {
            int[] nextState = {row - direction[i][0], col - direction[i][1]};
            if (nextState[0] < 0 || nextState[1] < 0 || nextState[0] >= boardState.length || nextState[1] >= boardState.length)
                continue;
            if (boardState[nextState[0]][nextState[1]] != null && boardState[nextState[0]][nextState[1]].isPlayerOne() == this.isPlayerOne())
                continue;
            String moveStr = BoardUtil.getMove(this.getPieceVal(), nextState[0], nextState[1]);
            moveStringList.add(moveStr);
        }
        return moveStringList;
    }
}
