package com.srijan.pandey.chess.core;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.exception.InvalidPieceException;
import com.srijan.pandey.chess.util.BoardUtil;

import java.util.List;
import java.util.function.BinaryOperator;

public class ValidationEngineMain {

    private Board board;

    public ValidationEngineMain() {
        board = new Board();
    }
    /**
     * The main function to get the possible set of moves for a particular list of black and white pieces
     *
     * @param blackPieces Black Pieces currently in the board
     * @param whitePieces White Pieces in the board
     * @param pieceToMove The piece to move
     */
    public void startValidationEngine(String blackPieces, String whitePieces, String pieceToMove) {
        boolean isValid = board.populateBoard(blackPieces.split(","), whitePieces.split(","));

        if (!isValid)  // Inconsistent board state, exit gracefully
            return;

        char userPiece = pieceToMove.charAt(0);
        char userRow = pieceToMove.charAt(2);
        char userCol = pieceToMove.charAt(1);
        try {
            List<String> moves = board.getMoves(userPiece, userRow, userCol);
            System.out.printf("Possible Moves For the Piece %s are \n", pieceToMove);
            for (String res : moves) {
                System.out.println(res);
            }
        } catch (InvalidPieceException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }


}
