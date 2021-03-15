package com.srijan.pandey.chess.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateInputsTest {

    @Test
    void validateInputTest() {
        boolean res = ValidateInputUtil.validatePieces("assd");
        assertFalse(res);
        assertFalse(ValidateInputUtil.validatePieces("Asd,Asd"));
        assertFalse(ValidateInputUtil.validatePieces("A12,A12"));
        assertFalse(ValidateInputUtil.validatePieces("Kz2,"));
        assertFalse(ValidateInputUtil.validatePieces("Az2"));
        assertFalse(ValidateInputUtil.validatePieces(""));
        assertTrue(ValidateInputUtil.validatePieces("Ka1,Qa2"));
    }

    @Test
    void validateCurrentPiece() {
        assertFalse(ValidateInputUtil.validateCurrentPiece("Az1"));
        assertFalse(ValidateInputUtil.validateCurrentPiece("as,as"));
        assertFalse(ValidateInputUtil.validateCurrentPiece("At2.asd"));
        assertTrue(ValidateInputUtil.validateCurrentPiece("Ka1"));
        assertTrue(ValidateInputUtil.validateCurrentPiece("Ba2"));
    }
}