package com.srijan.pandey.chess.core;

import com.srijan.pandey.chess.exception.InvalidPieceException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Cases: startValidationEngine()
 * 1. Invalid Piece
 *      - Test: "Pd3,Ne6" , "Ph1,Ph2,Ph3,Zc1", "Pd3"
 *      - verify getMoves() not called
 * 2. Valid Input when a particular row column is null "
 *      - verify getMoves() not called
 *      - Test: "Pd3", "Ph1", "Ne5"
 * 3. When a particular Row Column doesn't have the right piece to move
 *      - verify ex.printStackTrace() called
 *      - Test: "Pd3,Ne6" , "Nc7", "Nd3"
 * 4. Valid Pieces and Move Piece
 *      - verify that ex.printStackTrace() not called
 *      - Test "Pd3,Ne6" "Nc7", "Nc7"
 *
 * These test cases will cover all branches in the following class file
 *
 */
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ValidationEngineMainTest {

    @Mock private Board board;

    @InjectMocks ValidationEngineMain validationEngineMain;


    @Before
    void init() {
        MockitoAnnotations.openMocks(this);
    }
    /**
     * For this test case the idea is to mock and get a desired result for isValid = false
     * so that we can test the invalid piece part.
     */
    @Test
    void testInvalidPiece() throws InvalidPieceException {
        String blackPiece = "Pd3,Ne6";
        String whitePiece = "Ph1,Ph2,Ph3,Zc1";
        String pieceToMove = "Pd3";
        when(board.populateBoard(any(String[].class), any(String[].class))).thenReturn(false);
        validationEngineMain.startValidationEngine(blackPiece,whitePiece,pieceToMove);
        // the function getMoves doesn't get called as the function returns after getting a false from populateBoard
        verify(board, times(0)).getMoves(pieceToMove.charAt(0), pieceToMove.charAt(2), pieceToMove.charAt(1));
    }

    @Test
    void testPieceNotAvailableInBoard() throws InvalidPieceException {
        String blackPiece = "Pd3,Ne6";
        String whitePiece = "Ph1,Ph2,Ph3,Zc1";
        String pieceToMove = "Pd3";
        when(board.populateBoard(any(String[].class), any(String[].class))).thenReturn(true);
        when(board.getMoves(anyChar(), anyChar(), anyChar())).thenThrow(InvalidPieceException.class);
        validationEngineMain.startValidationEngine(blackPiece, whitePiece, pieceToMove);
        verify(board , atLeastOnce()).getMoves(anyChar(), anyChar(), anyChar());
    }

    @Test
    void testValidPieceAvailable() throws InvalidPieceException {
        String blackPiece = "Pd3,Ne6";
        String whitePiece = "Ph1,Ph2,Ph3,Zc1";
        String pieceToMove = "Pd3";
        when(board.populateBoard(any(String[].class), any(String[].class))).thenReturn(true);
        when(board.getMoves(anyChar(), anyChar(), anyChar())).thenReturn(Arrays.asList("Qa1","Qa2","Qa3")); // returns successful list of elements
        validationEngineMain.startValidationEngine(blackPiece, whitePiece, pieceToMove);
        verify(board , atLeastOnce()).getMoves(anyChar(), anyChar(), anyChar());
    }

}