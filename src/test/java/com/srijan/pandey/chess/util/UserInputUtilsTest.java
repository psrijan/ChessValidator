package com.srijan.pandey.chess.util;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.engine.support.discovery.SelectorResolver;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matcher.*;

import java.util.List;
import java.util.Scanner;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserInputUtilsTest {

    @Mock Scanner scanner; // Mocks the scanner class
    @InjectMocks UserInputUtils userInputUtils; // Injects the scanner class inside of the UserInputUtils class

    /**
     * The use of mockito requires that you mock and inject the variables inside the class you are trying to test
     * Future Reference: With mockito, there are challenges when mocking static class. You need an additional lib
     * rary mockito-inline in order to mock final classes such as scanner. I changed the design of the application
     * to use instance userInputUtils instead of static to ensure ease of testing.
     *
     * Also, mockito can mock instance variables of a class and local variables which are assigned inside the function
     * may require additional steps to mock.
     *
     * For populating the mock you also require @ExtendWith(MockitoExtension.class) and @RunWith(MockitoJunitRunner.class)
     * when using junit-jupiter-5 and just @RunWith(MockitoJunitRunner.class) for Junit 4.
     *
     * The additional dependencies for these are mockito-junit-jupiter, junit-vintage-engine, junit-platform-runner
     *
     */
    @Test
    void getUserInputs() {
        when(scanner.nextLine()).thenReturn("Kc1,Qc2", "Bh1,Ph2", "Kc1");
        List<String> list = userInputUtils.getUserInput(false);
        assertThat(list, Matchers.hasItems("Kc1,Qc2", "Bh1,Ph2", "Kc1"));

        when(scanner.nextLine()).thenReturn("Kc2,Qc2,Ph1", "Ph5,Kb1", "Kb1");
        List<String> result = userInputUtils.getUserInput(false);
        assertThat(result, Matchers.hasItems("Kc2,Qc2,Ph1", "Ph5,Kb1", "Kb1"));
    }

    @Test
    void getUserInputsDefaults() {
        String blackPieces = "Kb8,Ne8,Pa7,Pb7,Pc7,Ra5";
        String whitePieces = "Rf1,Kg1,Pf2,Ph2,Pg3";
        String pieceToMove = "Kb8";
        List<String> list = userInputUtils.getUserInput(true);
        assertThat(list, Matchers.hasItems(blackPieces, whitePieces,pieceToMove));
    }
}