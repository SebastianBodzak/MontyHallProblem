package com.sebastianbodzak.MontyHallProblem.app;

/**
 * Created by sbod on 19.04.2017.
 */
public class ConsoleTextDisplayer {

    public static void askAboutQuantityOfGates() {
        System.out.println("Hi, type how many doors should be in the game");
    }

    public static void askAboutNumberOfGames() {
        System.out.println("Now type how many games do you want to check");
    }

    public static void askAboutAutoPlayerDecision() {
        System.out.println("The game will be played by the autoplayer. \n" +
                "Should he change his mind in the last question? [type Y or N]");
    }
}
