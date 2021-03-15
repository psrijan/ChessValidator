package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.exception.PieceNotFoundException;
import com.srijan.pandey.chess.testset.CreateBoardUtil;
import com.srijan.pandey.chess.util.BoardUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

/**
 * This Validation engine doesn't allow double step for pawn
 * at the start of the board
 */
class PawnTest {

    @Test
    void testPawnAt_1a() throws PieceNotFoundException {
        Piece pawn = PieceFactory.getPiece('P', false);
        Piece[][] boardState = CreateBoardUtil.getPawnAt_2a();
        List<String> moves = pawn.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('a'));
        assertThat(moves, hasSize(1));
        assertThat(moves, hasItems("Pa3"));
    }

    @Test
    void testPawnAt_1h() throws PieceNotFoundException {
        Piece pawn = PieceFactory.getPiece('P', false);
        Piece[][] boardState = CreateBoardUtil.getPawnAt_2h_withEnemyAt_3g();
        List<String> moves = pawn.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        assertThat(moves, hasItems("Ph3", "Pg3"));
    }

    @Test
    void testPawnAt_3c() throws PieceNotFoundException {
        Piece pawn = PieceFactory.getPiece('P', false);
        Piece[][] boardState = CreateBoardUtil.getPawnAt_3c();
        List<String> moves = pawn.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasSize(1));
        assertThat(moves, hasItems("Pc4"));
    }

    @Test
    void testPawnSurroundedByFriends() throws PieceNotFoundException {
        Piece pawn = PieceFactory.getPiece('P', true);
        Piece[][] boardState = CreateBoardUtil.getPawnCoveredByFriends();
        List<String> moves = pawn.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasSize(0));
    }

    @Test
    void testPawnSurroundedByEnemyInOneSideNotInPawnsVision() throws PieceNotFoundException {
        Piece pawn = PieceFactory.getPiece('P', true);
        Piece[][] boardState = CreateBoardUtil.getPawnFrontOfEnemyInOneSide();
        List<String> moves = pawn.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasSize(0));
    }

    @Test
    void testPawnSurroundedByEnemyInTwoSideOneInPawnsVision() throws PieceNotFoundException {
        Piece pawn = PieceFactory.getPiece('P', true);
        Piece[][] boardState = CreateBoardUtil.getPawnFrontOfEmenyInTwoSide();
        List<String> moves = pawn.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        assertThat(moves, hasItems( "Pd2"));
    }
}