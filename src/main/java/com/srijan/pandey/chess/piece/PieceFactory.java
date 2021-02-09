package com.srijan.pandey.chess.piece;

public class PieceFactory {

    public static Piece getPiece(char piece, boolean isPlayerOne) {
        Piece p = null;
        switch (piece) {
            case 'k':
               p = new King();
               break;
            case 'q':
                p = new Queen();
                break;
            case 'n':
                p = new Knight();
                break;
            case 'p':
                p = new Pawn();
                break;
            case 'r':
                p = new Rook();
                break;
        }

    }
}
