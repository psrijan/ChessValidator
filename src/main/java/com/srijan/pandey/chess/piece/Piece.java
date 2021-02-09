package com.srijan.pandey.chess.piece;

import java.util.List;

public abstract class Piece {
    private boolean isPlayerOne;

    public abstract List<String> getMoves(Piece[][] boardState, int row, int col);

    public void setPlayerOne(boolean playerOne) {
        isPlayerOne = playerOne;
    }

    public boolean isPlayerOne() {
        return isPlayerOne;
    }
}
