package com.srijan.pandey.chess.piece;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public static final Character STR = 'K';

    public List<String> getMoves(Piece[][] boardState, int row, int col) {
        int[][] direction = {{1,0}, {0, 1}, {-1,0}, {0, -1}};
        List<int[][]> possibleMoves = new ArrayList<>();
        List<String> moveStringList = new ArrayList<>();
        for (int i = 0; i < direction.length; i++) {
            int[] nextState = {row - direction[i][0], col - direction[i][1]};
            if (nextState[0] < 0 || nextState[1] > 7)
                continue;
            if (boardState[nextState[0]][nextState[1]] != null && boardState[nextState[0]][nextState[1]].isPlayerOne() == this.isPlayerOne())
                continue;
            String moveStr = "" + STR + (char)('a' + nextState[0]) + String.valueOf(nextState[1]);
            moveStringList.add(moveStr);
        }
        return moveStringList;
    }
}
