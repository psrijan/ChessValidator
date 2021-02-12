package com.srijan.pandey.chess;

import com.srijan.pandey.chess.piece.Piece;

public class BoardUtil {
    public static String getMove(char piece, int row, int col) {
        return piece + (char)('a' + row) + String.valueOf(col);
    }
}
