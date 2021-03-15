package com.srijan.pandey.chess.testset;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.pieces.Piece;

public class CreateBoard {

    public static Piece[][] getKingAt_1a() {
        Board board = new Board();
        String[] blackPiece = {"Ka1"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getKingAt_1h() {
        Board board = new Board();
        String[] blackPiece = {"Kh1"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getBlackKingPieceSurroundedByWhite() {
        Board board  = new Board();
        String[] blackPiece = {"Kb2"};
        String[] whitePiece = {"Pb1,Pa2,Pb3,Pc2,Pa1,Pa3,Pc1,Pc3"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getQueenAt_1a() {
        Board board = new Board();
        String[] blackPiece = {"Qa1"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getQueenAt_1h() {
       Board board = new Board();
       String[] blackPiece = {"Qh1"};
       String[] whitePiece = new String[]{};
       board.populateBoard(blackPiece, whitePiece);
       return board.getChessBoard();
    }


    public static Piece[][] getQueenAt_3c() {
        Board board = new Board();
        String[] blackPiece = {"Qc3"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getQueenCoveredByFriends() {
        Board board = new Board();
        String[] blackPiece = {"Qc3,Kc2,Bc4,Bb3,Pd3,Pb2,Pd2,Pd4,Pb4"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static  Piece[][] getQueenFrontOfEnemyInOneSide() {
        Board board = new Board();
        String[] blackPiece = {"Qc3,Bc4,Bb3,Pd3,Pb2,Pd2,Pd4,Pb4"};
        String[] whitePiece = new String[]{"Kc2"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getQueenFrontOfEmenyInTwoSide() {
        Board board = new Board();
        String[] blackPiece = {"Qc3,Bb3,Pd3,Pb2,Pd2,Pd4,Pb4"};
        String[] whitePiece = new String[]{"Kc2,Bc4"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getFullChessBoardOrigin() {
        return null;
    }
}
