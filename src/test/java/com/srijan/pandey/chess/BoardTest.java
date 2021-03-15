package com.srijan.pandey.chess;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.pieces.Piece;
import com.srijan.pandey.chess.pieces.PieceFactory;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static com.srijan.pandey.chess.matchers.PieceEqls.pieceEq;

class BoardTest {
/*    private Board board = new Board();

    @Test
    public void testPopulateBoard() {
        
       Piece[][] actualChessBoard = board.getChessBoard();
       Piece[][] expectedChessBoard = boardDetails.getChessBoard();

       for (int i = 0; i < expectedChessBoard.length; i++) {
           for (int j = 0; j < expectedChessBoard.length; j++) {
               assertThat(actualChessBoard[i][j] , pieceEq(expectedChessBoard[i][j]));
           }
       }
    }

    public BoardDetails getBoardDetail() {
        BoardDetails boardDetails = new BoardDetails();
        String white1 = "Rf1, Kg1";
        String black1 = "Kb8, Ne8";

        white1 = white1.replace(" ", "");
        black1 = black1.replace(" ", "");

        String[] whiteArr = white1.split(",");
        String[] blackArr = black1.split(",");

        Piece[][] pieces = new Piece[8][8];
        Piece bp1 = PieceFactory.getPiece(blackArr[0].charAt(0), true);
        Piece bp2 = PieceFactory.getPiece(blackArr[1].charAt(0), true);

        Piece wp1 = PieceFactory.getPiece(whiteArr[0].charAt(0), false);
        Piece wp2 = PieceFactory.getPiece(whiteArr[1].charAt(0), false);

        pieces[7][5] = wp1;
        pieces[7][6] = wp2;

        pieces[0][1] = bp1;
        pieces[0][4] = bp2;
        BoardDetails bd = new BoardDetails(blackArr, whiteArr, pieces);
        return bd;
    }*/
}