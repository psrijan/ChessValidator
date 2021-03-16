package com.srijan.pandey.chess.core;

import com.srijan.pandey.chess.exception.InvalidPieceException;
import com.srijan.pandey.chess.exception.PieceNotFoundException;
import com.srijan.pandey.chess.pieces.Piece;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class BoardTest {

    @InjectMocks private Board board;

    @BeforeClass
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBoard() {
        Piece[][] chessBoard = board.getChessBoard();
        assertNotNull(chessBoard);
        for (Piece[] pieces : chessBoard) {
            for (Piece piece : pieces)
                assertNull(piece);
        }
    }

    @Test
    void testPieceNotAvailableInBoard_WhenGetMoves() {
        assertThrows(InvalidPieceException.class , () -> {
            board.getMoves('K', '1', 'c');
        });

    }


    @Test
    void testInvalidPiece_WhenGetMoves() {
        board.populateBoard(new String[]{"Qc1"}, new String[]{});
        assertThrows(InvalidPieceException.class, () -> {
            board.getMoves('K', '1', 'c');
        });
    }

    /**
     * Test For Populate Board
     * 1. Piece Not Found Exception Zc1
     * 2. With Valid Sets of Values
     * These test cases should cover all the lines in the class.
     * Additional lines in the underlying classes need not be tested with
     * the test case as there are other test cases/ test classes that test
     * those functionality
     */
    @Test
    void testPieceNotFound_WhenPopulatingBoard() {
        // Test for case which raises PiceNotFoundException
        boolean res = board.populateBoard(new String[]{"Zc1"}, new String[]{});
        assertFalse(res);

        // Test for valid case 1
        res = board.populateBoard(new String[]{"Pc1","Pc2","Pc3"}, new String[]{"Qd1,Kd2,Pd3"});
        assertTrue(res);

        // Test for valid case 2
        res = board.populateBoard(new String[]{"Pa1", "Pb2","Bc4"}, new String[]{});
        assertTrue(res);
    }
}