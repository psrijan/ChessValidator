package com.srijan.pandey.chess.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputsTest {

    @Test
    public void validateInputTest() {
        boolean res = ValidateInputs.validatePieces("assd");
        assertFalse(res);
        assertFalse(ValidateInputs.validatePieces("Asd,Asd"));
        assertFalse(ValidateInputs.validatePieces("A12,A12"));
        assertFalse(ValidateInputs.validatePieces("Kz2,"));
        assertFalse(ValidateInputs.validatePieces("Az2"));
        assertFalse(ValidateInputs.validatePieces(""));
        assertTrue(ValidateInputs.validatePieces("Ka1,Qa2"));
    }

    @Test
    void validateCurrentPiece() {
        assertFalse(ValidateInputs.validateCurrentPiece("Az1"));
        assertFalse(ValidateInputs.validateCurrentPiece("as,as"));
        assertFalse(ValidateInputs.validateCurrentPiece("At2.asd"));
        assertTrue(ValidateInputs.validateCurrentPiece("Ka1"));
        assertTrue(ValidateInputs.validateCurrentPiece("Ba2"));
    }
}