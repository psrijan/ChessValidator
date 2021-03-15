package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.exception.InvalidPieceException;
import com.srijan.pandey.chess.exception.PieceNotFoundException;
import com.srijan.pandey.chess.testset.CreateBoardUtil;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.Matchers.*;
import com.srijan.pandey.chess.util.BoardUtil;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KingTest extends AbstractPieceTest {

    @Test
    void testKingAt_1a() throws InvalidPieceException {
        Piece king = PieceFactory.getPiece('K', true);
        Piece[][] chessBoard = CreateBoardUtil.getKingAt_1a();
        List<String> moves = king.getMoves(chessBoard, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('a'));
        assertTrue(moves.contains("Ka2"));
        assertTrue(moves.contains("Kb1"));
        assertTrue(moves.contains("Kb2"));
        assertThat(moves.size() , equalTo(3));
    }


    @Test
    void testKingAt_1h() throws InvalidPieceException{
        Piece king = PieceFactory.getPiece('K', true);
        Piece[][] chessBoard = CreateBoardUtil.getKingAt_1h();
        king.setBlackPiece(true);
        List<String> actualMoves = king.getMoves(chessBoard, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        assertThat(actualMoves, hasItems("Kg1", "Kg2", "Kh2") );
        assertEquals(actualMoves.size(), 3);
    }

    @Test
    void testKingPieceSurroundedByEnemy() throws InvalidPieceException{
        Piece king = PieceFactory.getPiece('K', true);
        Piece[][] chessBoard = CreateBoardUtil.getKingCoveredByEnemiesAllSide();
        List<String> actualMoves = king.getMoves(chessBoard, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(actualMoves, hasItems("Kc4", "Kc2", "Kd3", "Kb3", "Kd3", "Kb4", "Kb2"));
        assertThat(actualMoves.size(), is(equalTo(8)));
    }
    @Test
    void testKingAt_3c() throws PieceNotFoundException {
        Piece king = PieceFactory.getPiece('K', true);
        Piece[][] boardState = CreateBoardUtil.getKingAt_3c();
        List<String> moves = king.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasItems("Kc4", "Kc2", "Kd3", "Kb3", "Kd3", "Kb4", "Kb2"));
    }

    @Test
    void testKingSurroundedByFriends() throws PieceNotFoundException {
        Piece king = PieceFactory.getPiece('K', true);
        Piece[][] boardState = CreateBoardUtil.getKingCoveredByFriends();
        List<String> moves = king.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasSize(0));
    }

    @Test
    void testKingSurroundedByEnemyInOneSide() throws PieceNotFoundException{
        Piece king = PieceFactory.getPiece('K', true);
        Piece[][] boardState = CreateBoardUtil.getKingFrontOfEnemyInOneSide();
        List<String> moves = king.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasItems("Kc2"));
    }

    @Test
    void testKingSurroundedByEnemyInTwoSide() throws PieceNotFoundException {
        Piece king = PieceFactory.getPiece('K', true);
        Piece[][] boardState = CreateBoardUtil.getKingFrontOfEnemyInTwoSide();
        List<String> moves = king.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasItems("Kc2","Kc4"));
    }
}