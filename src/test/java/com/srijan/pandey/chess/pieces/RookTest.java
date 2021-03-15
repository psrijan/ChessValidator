package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.exception.PieceNotFoundException;
import com.srijan.pandey.chess.testset.CreateBoardUtil;
import com.srijan.pandey.chess.util.BoardUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

class RookTest {

    @Test
    void testRookAt_1a() throws PieceNotFoundException {
        Piece rook = PieceFactory.getPiece('R', true);
        Piece[][] boardState = CreateBoardUtil.getRookAt_1a();
        List<String> moves = rook.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('a'));
        assertThat(moves, hasItems("Ra2", "Ra3", "Ra4", "Ra5", "Ra6", "Ra7", "Ra8", "Rb1", "Rc1", "Rd1",
                "Re1", "Rf1", "Rg1", "Rh1"));
    }

    @Test
    void testRookAt_1h() throws  PieceNotFoundException {
        Piece rook = PieceFactory.getPiece('R', true);
        Piece[][] boardState = CreateBoardUtil.getRookAt_1h();
        List<String> moves = rook.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        assertThat(moves, hasItems("Rh2","Rh3", "Rh4", "Rh5", "Rh6", "Rh7", "Rh8", "Rg1", "Rf1", "Re1", "Rd1", "Rc1", "Rb1", "Ra1"));
    }

    @Test
    void testRookAt_3c() throws PieceNotFoundException{
        Piece rook = PieceFactory.getPiece('R', true);
        Piece[][] boardState = CreateBoardUtil.getRookAt_3c();
        List<String> moves = rook.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasItems("Rc4", "Rc5", "Rc6", "Rc7", "Rc8", "Rd3", "Re3", "Rf3", "Rg3", "Rh3", "Rc2", "Rc1", "Rb3", "Ra3"));
    }

    @Test
    void testRookSurroundedByFriends() throws PieceNotFoundException {
        Piece rook = PieceFactory.getPiece('R', true);
        Piece[][] boardState = CreateBoardUtil.getRookCoveredByFriends();
        List<String> moves = rook.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasSize(0));
    }

    @Test
    void testRookSurroundedByEnemyInOneSide() throws PieceNotFoundException{
        Piece rook = PieceFactory.getPiece('R', true);
        Piece[][] boardState = CreateBoardUtil.getRookFrontOfEnemyInOneSide();
        List<String> moves = rook.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasItems("Rc2"));

    }

    @Test
    void testRookSurroundedByEnemyInTwoSide() throws PieceNotFoundException {
        Piece rook = PieceFactory.getPiece('R', true);
        Piece[][] boardState = CreateBoardUtil.getRookFrontOfEmenyInTwoSide();
        List<String> moves = rook.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        assertThat(moves, hasItems("Rh2","Rh4"));
    }
}