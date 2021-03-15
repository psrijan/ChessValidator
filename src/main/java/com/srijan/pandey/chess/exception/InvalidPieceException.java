package com.srijan.pandey.chess.exception;

/**
 * Exception that identifies that the piece is invalid
 */
public class InvalidPieceException extends Exception{

    public  InvalidPieceException(String errorMessage) {
        super(errorMessage);
    }
}
