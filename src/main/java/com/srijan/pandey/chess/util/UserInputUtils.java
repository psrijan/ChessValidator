package com.srijan.pandey.chess.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Gets Input from user
 */
public class UserInputUtils {

    private Scanner sc;

    public UserInputUtils() {
        sc = new Scanner(System.in);
    }
    /**
     * Function that takes user inputs for black pieces
     * white pieces and piece to move
     * @param isDefault flag to return a default test value
     * @return Arraylist containing strings of black piece, white piece and piece to move
     */
    public List<String> getUserInput(boolean isDefault) {
        List<String> result = new ArrayList<>();
        boolean isBlackPieceValid = false;
        boolean isWhitePieceValid = false;
        boolean isMovePieceValid = false; // Check if the Move Piece is a valid Move Piece

        String blackPieces = "Kb8,Ne8,Pa7,Pb7,Pc7,Ra5";
        String whitePieces = "Rf1,Kg1,Pf2,Ph2,Pg3";
        String pieceToMove = "Kb8";

        // isDefault is a test configuration for default values
        if (isDefault) {
            result.add(blackPieces);
            result.add(whitePieces);
            result.add(pieceToMove);
            return result;
        }

        while (!isBlackPieceValid) {
            System.out.println("Please enter valid black pieces FORMAT: (<piece><column><row>,)");
            System.out.println("Eg: Kb8,Ne8,Pa7,Pb7,Pc7,Ra5");
            blackPieces = sc.nextLine();
            isBlackPieceValid = ValidateInputUtil.validatePieces(blackPieces); // Strict validity check for the Black Piece String
        }

        while (!isWhitePieceValid) {
            System.out.println("Please enter valid white pieces FORMAT: (<piece><column><row>,)");
            System.out.println("Eg: Rf1,Kg1,Pf2,Ph2,Pg3");
            whitePieces = sc.nextLine();
            isWhitePieceValid = ValidateInputUtil.validatePieces(whitePieces); // Strict validity Check for the White Piece String
        }

        while (!isMovePieceValid) {
            System.out.println("Please enter a single valid Piece for which you want a move list FORMAT:(<piece><column><row>)");
            System.out.println("Eg: Kb8");
            pieceToMove = sc.nextLine();
            isMovePieceValid = ValidateInputUtil.validateCurrentPiece(pieceToMove.trim());
        }
        result.add(blackPieces);
        result.add(whitePieces);
        result.add(pieceToMove);
        return result;
    }
}
