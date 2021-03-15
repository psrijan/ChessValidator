package com.srijan.pandey.chess.testset;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.pieces.Piece;

public class CreateBoardUtil {

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

    public static Piece[][] getKingAt_3c() {
        Board board = new Board();
        String[] blackPiece = {"Kc3"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }
    public static Piece[][] getKingCoveredByEnemiesAllSide() {
        Board board  = new Board();
        String[] blackPiece = {"Kc3"};
        String[] whitePiece = {"Qc2","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static  Piece[][] getKingFrontOfEnemyInOneSide() {
        Board board = new Board();
        String[] blackPiece = {"Kc3","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{"Kc2"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getKingFrontOfEnemyInTwoSide() {
        Board board = new Board();
        String[] blackPiece = {"Kc3","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{"Kc2","Bc4"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }
    public static Piece[][] getKingCoveredByFriends() {
        Board board = new Board();
        String[] blackPiece = {"Kc3","Kc2","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{};
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
        String[] blackPiece = {"Qc3","Kc2","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static  Piece[][] getQueenFrontOfEnemyInOneSide() {
        Board board = new Board();
        String[] blackPiece = {"Qc3","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{"Kc2"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getQueenFrontOfEmenyInTwoSide() {
        Board board = new Board();
        String[] blackPiece = {"Qc3","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{"Kc2","Bc4"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getRookAt_1a() {
        Board board = new Board();
        String[] blackPiece = {"Ra1"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getRookAt_1h() {
        Board board = new Board();
        String[] blackPiece = {"Rh1"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getRookAt_3c() {
        Board board = new Board();
        String[] blackPiece = {"Rc3"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getRookCoveredByFriends() {
        Board board = new Board();
        String[] blackPiece = {"Rc3","Kc2","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static  Piece[][] getRookFrontOfEnemyInOneSide() {
        Board board = new Board();
        String[] blackPiece = {"Rc3","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{"Kc2"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getRookFrontOfEmenyInTwoSide() {
        Board board = new Board();
        String[] blackPiece = {"Rc3","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{"Kc2","Bc4"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }


    public static Piece[][] getPawnAt_2a() {
        Board board = new Board();
        String[] whitePiece = {"Pa2"};
        String[] blackPiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getPawnAt_2h_withEnemyAt_3g() {
        Board board = new Board();
        String[] whitePiece = {"Ph1"};
        String[] blackPiece = new String[]{"Kg3"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getPawnAt_3c() {
        Board board = new Board();
        String[] blackPiece = {"Pc3"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getPawnCoveredByFriends() {
        Board board = new Board();
        String[] blackPiece = {"Pc3","Kc2","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static  Piece[][] getPawnFrontOfEnemyInOneSide() {
        Board board = new Board();
        String[] blackPiece = {"Pc3","Bc4","Bb3","Pd3","Pb2","Pd2","Pd4","Pb4"};
        String[] whitePiece = new String[]{"Kc2"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

    public static Piece[][] getPawnFrontOfEmenyInTwoSide() {
        Board board = new Board();
        String[] blackPiece = {"Pc3","Bb3","Pd3","Pb2","Pd4","Pb4"};
        String[] whitePiece = new String[]{"Kd2","Pc2","Bc4"};
        board.populateBoard(blackPiece, whitePiece);
        return board.getChessBoard();
    }

}
