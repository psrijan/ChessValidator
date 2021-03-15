package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.exception.PieceNotFoundException;

public class PieceFactory {

    private PieceFactory() {
    }

    /**
     * Get piece Class based on piece character and type of piece information
     */
    public static Piece getPiece(char piece, boolean isBlackPiece) throws PieceNotFoundException {
        Piece p = null;
        switch (piece) {
            case 'K':
               p = new King();
               break;
            case 'Q':
                p = new Queen();
                break;
            case 'N':
                p = new Knight();
                break;
            case 'P':
                p = new Pawn();
                break;
            case 'R':
                p = new Rook();
                break;
            case 'B':
                p = new Bishop();
                break;
            default:
                throw new PieceNotFoundException("The piece of the type " + piece + " could not be found");
        }
        p.setBlackPiece(isBlackPiece);
        return p;
    }
}
