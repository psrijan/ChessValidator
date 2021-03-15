package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.testset.CreateBoard;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.Matchers.*;
import com.srijan.pandey.chess.util.BoardUtil;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KingTest extends AbstractPieceTest {
    private King king = new King();

    @Test
    void testKingLeftEdge() {
        Piece[][] chessBoard = CreateBoard.getKingAt_1a();
        List<String> moves = king.getMoves(chessBoard, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('a'));
        assertTrue(moves.contains("Ka2"));
        assertTrue(moves.contains("Kb1"));
        assertTrue(moves.contains("Kb2"));
        assertThat(moves.size() , equalTo(3));
    }


    @Test
    void testKingRightEdge() {
        Piece[][] chessBoard = CreateBoard.getKingAt_1h();
        king.setBlackPiece(true);
        List<String> actualMoves = king.getMoves(chessBoard, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        printMoves(actualMoves);
        assertThat(actualMoves, hasItems("Kg1", "Kg2", "Kh2") );
        assertEquals(actualMoves.size(), 3);
    }

    @Test
    void testBlackKingPieceSurroundedByWhite() {
        Piece[][] chessBoard = CreateBoard.getBlackKingPieceSurroundedByWhite();
        king.setBlackPiece(true);
        List<String> actualMoves = king.getMoves(chessBoard, BoardUtil.getGridRow('2'), BoardUtil.getGridColumn('b'));
        printMoves(actualMoves);
        assertThat(actualMoves, hasItems("Kb1","Ka2","Kb3","Kc2","Ka1","Ka3","Kc1","Kc3"));
        assertThat(actualMoves.size(), is(equalTo(8)));
    }

}