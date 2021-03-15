package com.srijan.pandey.chess.util;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.pieces.Piece;
import com.srijan.pandey.chess.testset.CreateBoard;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

class BoardUtilTest {

    @Test
    void testUserFriendlyMove() {
        String res = BoardUtil.getUserFriendlyMove('Q', 1,1);
        assertThat(res, is(equalTo("Qb2")));

        res = BoardUtil.getUserFriendlyMove('K', 2,2);
        assertThat(res, is(equalTo("Kc3")));
    }

    @Test
    void testGridRow() {
        int row = BoardUtil.getGridRow('1');
        assertThat(row, is(equalTo(0)));

        row = BoardUtil.getGridRow('2');
        assertThat(row, is(equalTo(1)));

        row = BoardUtil.getGridRow('7');
        assertThat(row, is(equalTo(6)));
    }


    @Test
    void testGridCol() {
        int col = BoardUtil.getGridColumn('a');
        assertThat(col, is(equalTo(0)));

        col = BoardUtil.getGridColumn('c');
        assertThat(col, is(equalTo(2)));
    }

    @Test
    void testVisualizeBoard() {
        Piece[][] board = CreateBoard.getQueenAt_1a();
    }

}