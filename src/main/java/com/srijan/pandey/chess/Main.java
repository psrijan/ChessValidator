package com.srijan.pandey.chess;

import com.srijan.pandey.chess.core.Board;
import com.srijan.pandey.chess.core.ValidationEngineMain;
import com.srijan.pandey.chess.util.UserInputUtils;

import java.util.List;

public class Main {

    /**
     * This is the main method from which you run the application
     */
    public static void main(String[] args) {
        ValidationEngineMain validationEngineMain = new ValidationEngineMain(new Board());
        UserInputUtils userInputUtils = new UserInputUtils();
        List<String> userInputs = userInputUtils.getUserInput(false);
        validationEngineMain.startValidationEngine(userInputs.get(0), userInputs.get(1), userInputs.get(2));
    }
}
