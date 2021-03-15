package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.exception.InvalidPieceException;
import com.srijan.pandey.chess.util.BoardUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class KnightTest {

    private final Knight knight = new Knight();

    @Test
    void testKnightPiece() {
        assertThat(knight.getPieceVal(), is(equalTo('N')));
    }

    @Test
    void testKnightAtLeftEdge() throws InvalidPieceException {
        Board board = new Board();
        board.populateBoard(new String[]{"Na1"}, new String[]{});
        knight.setBlackPiece(true);
        List<String> result = knight.getMoves(board.getChessBoard(), BoardUtil.getGridRow('1'),BoardUtil.getGridColumn('a'));
        assertThat(result, hasSize(2));
        assertThat(result, hasItems("Nc2", "Nb3"));
    }

    @Test
    void testKnightAt_B1() throws InvalidPieceException {
        Board board = new Board();
        board.populateBoard(new String[]{"Nb1"} , new String[]{});
        knight.setBlackPiece(true);
        List<String> result = knight.getMoves(board.getChessBoard(), BoardUtil.getGridRow( '1'), BoardUtil.getGridColumn('b'));
        assertThat(result, hasSize(3));
        assertThat(result, hasItems("Na3","Nc3", "Nd2"));
    }


    @Test
    void testKnightFrontOfFriend() throws InvalidPieceException {
        Board board = new Board();
        board.populateBoard(new String[]{}, new String[]{"Na1", "Pb3", "Nc2"});
        knight.setBlackPiece(false);
        List<String> result = knight.getMoves(board.getChessBoard(), BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('a'));
        assertThat(result, empty());
    }


    @Test
    void testKnightInFrontOfEnemy() throws InvalidPieceException {
        Board board = new Board();
        board.populateBoard(new String[]{"Nb1"}, new String[]{"Pb3","Pc2"});
        knight.setBlackPiece(true);
        List<String> result = knight.getMoves(board.getChessBoard(), BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('b'));
        assertThat(result, hasSize(3));
        assertThat(result, hasItems("Nd2", "Na3", "Nc3"));
    }


}