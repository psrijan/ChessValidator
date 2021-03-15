package com.srijan.pandey.chess.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validate Input, checks that the user defined input is valid.
 */
public class ValidateInputs {
    public static final String PIECE_REGEX = "[KQBNRP][a-h][1-8]";

    /**
     * This function validates if Piece List provided by the user is
     * valid or not.
     * @param piecesString String value of piece list provided by the user
     * @return true if valid
     */
    public static boolean validatePieces(String piecesString) {
        System.out.println(piecesString);
        piecesString = piecesString.trim();
        piecesString = piecesString.replace(" ", "");
        String[] pieceArr = piecesString.split(",");
        Pattern pattern = Pattern.compile(PIECE_REGEX);
        for (String piece : pieceArr) {
            Matcher matcher = pattern.matcher(piece);
            if (!(matcher.matches() && piece.length() == 3)) {
                System.out.println("Length: " + piece.length());
                System.out.println("piece: " + piece);
                System.out.println("Matcher Matches? " + matcher.matches());
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the current piece for which the user needs the move is
     * valid or not
     * @param piece Piece to check validity
     * @return true if valid
     */
    public static boolean validateCurrentPiece(String piece) {
        Pattern curPieceRegex = Pattern.compile(PIECE_REGEX);
        Matcher matcher = curPieceRegex.matcher(piece);
        return matcher.matches() && piece.length() == 3;
    }

}
