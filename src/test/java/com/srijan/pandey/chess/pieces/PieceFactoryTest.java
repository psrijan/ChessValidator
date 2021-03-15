package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.exception.PieceNotFoundException;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class PieceFactoryTest {

    @Test
    void testKingOfBlackSet() throws PieceNotFoundException {
       Piece piece = PieceFactory.getPiece('K', true);
       assertThat(piece.getPieceVal(), is(equalTo('K')));
       assertThat(piece.isBlackPiece(), is(equalTo(true)));
    }

    @Test
    void testKingOfWhiteSet() throws PieceNotFoundException {
        Piece piece = PieceFactory.getPiece('K', false);
        assertThat(piece.getPieceVal(), is(equalTo('K')));
        assertThat(piece.isBlackPiece(), is(equalTo(false)));
    }

    @Test
    void testQueenOfBothSet() throws PieceNotFoundException {
        Piece blackPiece = PieceFactory.getPiece('Q', true);
        Piece whitePiece = PieceFactory.getPiece('Q', false);

        assertThat(blackPiece.getPieceVal(), is(equalTo('Q')));
        assertThat(whitePiece.getPieceVal(), is(equalTo('Q')));

        assertThat(blackPiece.isBlackPiece(), is(equalTo(true)));
        assertThat(whitePiece.isBlackPiece(), is(equalTo(false)));
    }

    @Test
    void testBishop() throws PieceNotFoundException {
        Piece blackPiece = PieceFactory.getPiece('B', true);
        Piece whitePiece = PieceFactory.getPiece('B', false);

        assertThat(blackPiece.getPieceVal(), is(equalTo('B')));
        assertThat(whitePiece.getPieceVal(), is(equalTo('B')));

        assertThat(blackPiece.isBlackPiece(), is(equalTo(true)));
        assertThat(whitePiece.isBlackPiece(), is(equalTo(false)));

    }

    @Test
    void testKnight() throws PieceNotFoundException {
        Piece blackPiece = PieceFactory.getPiece('N', true);
        Piece whitePiece = PieceFactory.getPiece('N', false);

        assertThat(blackPiece.getPieceVal(), is(equalTo('N')));
        assertThat(whitePiece.getPieceVal(), is(equalTo('N')));

        assertThat(blackPiece.isBlackPiece(), is(equalTo(true)));
        assertThat(whitePiece.isBlackPiece(), is(equalTo(false)));

    }


    @Test
    void testRook() throws PieceNotFoundException {
        Piece blackPiece = PieceFactory.getPiece('R', true);
        Piece whitePiece = PieceFactory.getPiece('R', false);

        assertThat(blackPiece.getPieceVal(), is(equalTo('R')));
        assertThat(whitePiece.getPieceVal(), is(equalTo('R')));

        assertThat(blackPiece.isBlackPiece(), is(equalTo(true)));
        assertThat(whitePiece.isBlackPiece(), is(equalTo(false)));

    }



    @Test
    void testPawn() throws PieceNotFoundException {
        Piece blackPiece = PieceFactory.getPiece('P', true);
        Piece whitePiece = PieceFactory.getPiece('P', false);

        assertThat(blackPiece.getPieceVal(), is(equalTo('P')));
        assertThat(whitePiece.getPieceVal(), is(equalTo('P')));

        assertThat(blackPiece.isBlackPiece(), is(equalTo(true)));
        assertThat(whitePiece.isBlackPiece(), is(equalTo(false)));

    }



    @Test
    void testPieceException() throws PieceNotFoundException {
        assertThrows(PieceNotFoundException.class, ()-> {
            PieceFactory.getPiece('M', true);
        });

    }





}