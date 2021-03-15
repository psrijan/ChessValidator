package com.srijan.pandey.chess.core;

import com.srijan.pandey.chess.exception.InvalidPieceException;
import com.srijan.pandey.chess.exception.PieceNotFoundException;
import com.srijan.pandey.chess.pieces.Piece;
import com.srijan.pandey.chess.pieces.PieceFactory;
import com.srijan.pandey.chess.util.BoardUtil;

import java.util.List;

public class Board {
    private final Piece[][] chessBoard = new Piece[8][8];

    /**
     * This is the start function to populate the boaord with black and white pieces
     * @param blackPieces set of black pieces the user has specified
     * @param whitePieces set of white pieces the user has specified
     */
    public boolean populateBoard(String[] blackPieces, String[] whitePieces) {
        try {
            populateSet(blackPieces, true);
            populateSet(whitePieces, false);
        } catch (InvalidPieceException ex ) {
            System.out.println("Invalid Piece and Inconsistent Board Exiting");
            return false;
        }
        return true;
    }

    /**
     * Initially run when the user specifies all the pieces and populates the board
     * @param pieceList List of pieces to populate the set
     * @param isBlackPiece Information about if it is a this a black piece or a white piece
     */
    private void populateSet(String[] pieceList, boolean isBlackPiece) throws PieceNotFoundException {
        for (String userDefinedPiece : pieceList) {
            char piece = userDefinedPiece.charAt(0);
            char userRow = userDefinedPiece.charAt(2);
            char userCol = userDefinedPiece.charAt(1);
            int row = BoardUtil.getGridRow(userRow);
            int col = BoardUtil.getGridColumn(userCol);
            chessBoard[row][col] = PieceFactory.getPiece(piece, isBlackPiece);
        }
    }

    /**
     * Takes in user defined row, col and piece information for a particular
     * piece to move in a board and then returns a list of possible output.
     * @param userPiece Which Piece is it
     * @param userRow What is the user defined row information
     * @param userCol What is the user defined column information
     * @return a list of moves for the particular piece
     */
    public List<String> getMoves(char userPiece, char userRow, char userCol) throws InvalidPieceException {
        int row = BoardUtil.getGridRow(userRow);
        int col = BoardUtil.getGridColumn(userCol);
        System.out.println("User Row: " + userRow + " Row: " + row);
        System.out.println("User Col: " + userCol + " Col: " + col);
        Piece piece = chessBoard[row][col];

        System.out.println("User Piece: " + userPiece);
        if (piece == null || userPiece != piece.getPieceVal()) {
            throw new InvalidPieceException("The board doesn't have the piece specified in the particular row and column");
        }
        return piece.getMoves(chessBoard, row, col);
    }

    /**
     * Return Chess Board
     * @return chessboard states
     */
    public Piece[][] getChessBoard() {
        return chessBoard;
    }
}
