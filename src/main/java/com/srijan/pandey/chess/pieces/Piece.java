package com.srijan.pandey.chess.pieces;

import java.util.List;

public abstract class Piece {
    private boolean isBlackPiece;
    private char pieceVal;

    public abstract List<String> getMoves(Piece[][] boardState, int row, int col);

    public void setBlackPiece(boolean blackPiece) {
        isBlackPiece = blackPiece;
    }

    public boolean isBlackPiece() {
        return isBlackPiece;
    }

    public abstract char getPieceVal();

}
