package com.srijan.pandey.chess;

import com.srijan.pandey.chess.piece.King;
import com.srijan.pandey.chess.piece.Piece;
import com.srijan.pandey.chess.piece.PieceFactory;

import java.util.List;

public class Board {
    private Piece[][] chessBoard = new Piece[8][8];
    private String curPiece;

    public Board() {

    }

    public void populateBoard(String[] blackPieces, String[] whitePieces) {
        for (int i = 0; i < blackPieces.length; i++) {
            chessBoard[blackPieces[i].charAt(1) - 'a'][blackPieces[i].charAt(2) - 1] = PieceFactory.getPiece(blackPieces[i].charAt(0), true);
        }

        for (int i = 0; i < whitePieces.length; i++) {
            chessBoard[blackPieces[i].charAt(1) - 'a'][blackPieces[i].charAt(2) - 1] = PieceFactory.getPiece(blackPieces[i].charAt(0), false);
        }
    }

    public List<String> getMoves(char piece, boolean isPlayerOne, int row, int col) {
        Piece pieceVal = PieceFactory.getPiece(piece, isPlayerOne);
        return pieceVal.getMoves(chessBoard, row, col);
    }
}
