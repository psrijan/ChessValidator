package com.srijan.pandey.chess;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isBlackPieceValid = false;
        boolean isWhitePieceValid = false;
        boolean isMovePieceValid= false;

        String blackPieces= "";
        String whitePieces="";
        String pieceToMove="";

        while (!isBlackPieceValid) {
            blackPieces = sc.nextLine();
            isBlackPieceValid = ValidateInputs.validateBlackPieces(blackPieces);
        }
        while(!isWhitePieceValid) {
            whitePieces = sc.nextLine();
            isWhitePieceValid =  ValidateInputs.validateWhitePieces(whitePieces);
        }

        while (!isMovePieceValid) {
            pieceToMove = sc.nextLine();
            isMovePieceValid = ValidateInputs.validateCurrentPiece(pieceToMove);
        }

    }
}
