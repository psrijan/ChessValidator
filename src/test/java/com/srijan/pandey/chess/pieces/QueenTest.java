package com.srijan.pandey.chess.pieces;

import com.srijan.pandey.chess.exception.PieceNotFoundException;
import com.srijan.pandey.chess.testset.CreateBoard;
import com.srijan.pandey.chess.util.BoardUtil;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import java.util.List;

class QueenTest extends AbstractPieceTest{

    @Test
    void testQueenat_1a() throws PieceNotFoundException {
        Piece queen = PieceFactory.getPiece('Q', true);
        Piece[][] boardState = CreateBoard.getQueenAt_1a();
        queen.setBlackPiece(true);
        List<String> moves = queen.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('a'));
        printMoves(moves);
        assertThat(moves, hasItems("Qa2", "Qa3", "Qa4", "Qa5", "Qa6", "Qa7", "Qa8", "Qb1", "Qc1", "Qd1",
                "Qe1", "Qf1", "Qg1", "Qh1", "Qb2", "Qc3", "Qd4", "Qe5", "Qf6", "Qg7", "Qh8"));
    }
    @Test
    void testQueenat_1h() throws  PieceNotFoundException {
        Piece queen = PieceFactory.getPiece('Q', true);
        Piece[][] boardState = CreateBoard.getQueenAt_1h();
        queen.setBlackPiece(true);
        List<String> moves = queen.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        assertThat(moves, hasItems("Qh2","Qh3", "Qh4", "Qh5", "Qh6", "Qh7", "Qh8", "Qg1",
                "Qf1", "Qe1", "Qd1", "Qc1", "Qb1", "Qa1", "Qg2", "Qf3",
                "Qe4", "Qd5", "Qc6", "Qb7", "Qa8"));
    }

    @Test
    void testQueenat_3c() throws PieceNotFoundException{
       Piece queen = PieceFactory.getPiece('Q', true);
        Piece[][] boardState = CreateBoard.getQueenAt_3c();
        queen.setBlackPiece(true);
        List<String> moves = queen.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves, hasItems("Qc4", "Qc5", "Qc6", "Qc7", "Qc8", "Qd3", "Qe3", "Qf3", "Qg3", "Qh3", "Qc2", "Qc1", "Qb3", "Qa3", "Qd4",
                "Qe5", "Qf6", "Qg7", "Qh8", "Qb2", "Qa1", "Qb4", "Qa5", "Qd2", "Qe1"));
    }

    @Test
    void testQueenSurroundedByFriends() throws PieceNotFoundException{
        Piece queen = PieceFactory.getPiece('Q', true);
        Piece[][] boardState = CreateBoard.getQueenCoveredByFriends();
        queen.setBlackPiece(true);
        List<String> moves = queen.getMoves(boardState, BoardUtil.getGridRow('3'), BoardUtil.getGridColumn('c'));
        assertThat(moves.size(), is(equalTo(0)));

    }

    @Test
    void testQueenSurroundedByEnemyInOneSide() throws PieceNotFoundException{
        Piece queen = PieceFactory.getPiece('Q', true);
        Piece[][] boardState = CreateBoard.getQueenAt_1h();
        queen.setBlackPiece(true);
        List<String> moves = queen.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        printMoves(moves);
        assertThat(moves, hasItems("Qh2","Qh3", "Qh4", "Qh5", "Qh6", "Qh7", "Qh8", "Qg1",
                "Qf1", "Qe1", "Qd1", "Qc1", "Qb1", "Qa1", "Qg2", "Qf3",
                "Qe4", "Qd5", "Qc6", "Qb7", "Qa8"));

    }

    @Test
    void testQueenSurroundedByEnemyInTwoSide() throws PieceNotFoundException{
        Piece queen = PieceFactory.getPiece('Q', true);
        Piece[][] boardState = CreateBoard.getQueenAt_1h();
        queen.setBlackPiece(true);
        List<String> moves = queen.getMoves(boardState, BoardUtil.getGridRow('1'), BoardUtil.getGridColumn('h'));
        printMoves(moves);
        assertThat(moves, hasItems("Qh2","Qh3", "Qh4", "Qh5", "Qh6", "Qh7", "Qh8", "Qg1",
                "Qf1", "Qe1", "Qd1", "Qc1", "Qb1", "Qa1", "Qg2", "Qf3",
                "Qe4", "Qd5", "Qc6", "Qb7", "Qa8"));

    }
}