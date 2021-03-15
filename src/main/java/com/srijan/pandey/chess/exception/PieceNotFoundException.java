package com.srijan.pandey.chess.exception;

public class PieceNotFoundException extends InvalidPieceException {
    public PieceNotFoundException(String message ) {
       super(message);
    }
}
