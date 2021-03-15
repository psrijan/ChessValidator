package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.exception.InvalidPieceException;
import com.srijan.pandey.chess.util.BoardUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Test Case:
 * 1. Left Edge
 * 2. Right Edge
 * 4. In front of friend
 * 5. In front of enemy
 *
 */
class BishopTest {

    Bishop bishop = new Bishop();
    Board board ;
    @Test
    void testBishopPiece() {
        assertThat(bishop.getPieceVal(), is(equalTo('B')));
    }

    @Test
    void testBishopAtLeftEdge() throws InvalidPieceException {
        board = new Board();
        board.populateBoard(new String[]{"Ba1"}, new String[]{});
        List<String> result = bishop.getMoves(board.getChessBoard(), BoardUtil.getGridRow('1'),BoardUtil.getGridColumn('a'));
        assertThat(result, hasSize(7));
        assertThat(result, hasItems("Bb2", "Bc3", "Bd4", "Be5", "Bf6", "Bg7", "Bh8"));
    }

    @Test
    void testBishopAt_B1() throws  InvalidPieceException{
        board = new Board();
        board.populateBoard(new String[]{"Bb1"} , new String[]{});
        List<String> result = bishop.getMoves(board.getChessBoard(), BoardUtil.getGridRow( '1'), BoardUtil.getGridColumn('b'));
        assertThat(result, hasSize(7));
        assertThat(result, hasItems("Ba2","Bc2", "Bd3", "Be4", "Bf5", "Bg6", "Bh7"));
    }


    @Test
    void testBishopFrontOfFriend() throws InvalidPieceException {
        board = new Board();
        board.populateBoard(new String[]{"Bb1", "Pc2", "Pa2"}, new String[]{});
        bishop.setBlackPiece(true);
        List<String> result = bishop.getMoves(board.getChessBoard(), BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('b'));
        assertThat(result, empty());
    }


    @Test
    void testBishopInFrontOfEnemy() throws InvalidPieceException {
        board = new Board();
        board.populateBoard(new String[]{"Bb1"}, new String[]{"Pc2","Pa2"});
        bishop.setBlackPiece(true);
        List<String> result = bishop.getMoves(board.getChessBoard(), BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('b'));
        assertThat(result, hasSize(2));
        assertThat(result, hasItems("Bc2", "Ba2"));
    }


}