package com.srijan.pandey.chess.matchers;

import com.srijan.pandey.chess.pieces.Piece;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class PieceEqls extends TypeSafeMatcher<Piece> {
    private Piece piece;

    public PieceEqls(Piece piece) {
        this.piece = piece;
    }

    @Override
    protected boolean matchesSafely(Piece actualPiece) {
        if (actualPiece == null && piece == null)
            return true;
        if (actualPiece != null && piece != null && actualPiece.getPieceVal() == piece.getPieceVal() && actualPiece.isBlackPiece() == piece.isBlackPiece())
            return true;
        return false;
    }

    @Override
    public void describeTo(Description description) {
    }

    public static Matcher<Piece> pieceEq(Piece p1) {
        return new PieceEqls(p1);
    }
}
