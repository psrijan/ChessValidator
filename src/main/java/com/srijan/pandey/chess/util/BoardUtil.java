package com.srijan.pandey.chess.util;

import com.srijan.pandey.chess.pieces.Piece;

/**
 * Utility class for the Board class
 */
public class BoardUtil {

    private BoardUtil() {
    }

    // Return the user expected move String for any piece
    public static String getUserFriendlyMove(char piece, int row, int col) {
        String rowStr = String.valueOf(row + 1);
        String colStr = String.valueOf((char)('a' + col));
        return piece + colStr + rowStr;
    }

    /**
     * Takes in a user defined row value and returns the
     * actual position of the User Defined row to the
     * equivalant grid position
     * @param row user defined row
     * @return grid row value
     */
    public static int getGridRow(char row) {
       return row - '1';
    }

    /**
     * Takes the user defined column value and return the
     * actual position of the
     */
    public static int getGridColumn(char col) {
       return col - 'a'; // column is specified as a-f and the 0th position in grid will be a value
    }

    /***
     * Utility function that helps to visualize the data inside the booard
     * Prints out the systems board state
     * @param chessBoard state of the chess board is given and the application prints out the board state.
     */
//    public static void visualizeBoard(Piece[][] chessBoard) {
//        for (int row = 0; row < chessBoard.length; row++) {
//            for (int col = 0; col < chessBoard[0].length; col++) {
//                Piece piece = chessBoard[row][col];
//                String prettyPiece = "";
//                if (piece != null ) {
//                    prettyPiece = BoardUtil.getUserFriendlyMove(piece.getPieceVal(), row, col);
//                    String pieceType = piece.isBlackPiece() ? "(B)" : "(W)";
//                    prettyPiece = prettyPiece + pieceType;
//                } else {
//                    prettyPiece = "null";
//                }
//                System.out.printf("%s, ",prettyPiece);
//            }
//            System.out.println("");
//        }
//    }



}

