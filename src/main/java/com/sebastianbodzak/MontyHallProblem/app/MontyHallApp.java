package com.sebastianbodzak.MontyHallProblem.app;

import com.sebastianbodzak.MontyHallProblem.api.MontyHallGame;
import com.sebastianbodzak.MontyHallProblem.domain.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.sebastianbodzak.MontyHallProblem.app.ConsoleTextDisplayer.askAboutAutoPlayerDecision;
import static com.sebastianbodzak.MontyHallProblem.app.ConsoleTextDisplayer.askAboutNumberOfGames;
import static com.sebastianbodzak.MontyHallProblem.app.ConsoleTextDisplayer.askAboutQuantityOfGates;

/**
 * Created by sbod on 18.04.2017.
 */
public class MontyHallApp {

    public static void main(String[] args) {

        MontyHallGame montyHallGame = new MontyHallGame();
        Scanner scanner = new Scanner(System.in);
        Player player;
        Results results = new Results();
        int chosenGate;

        askAboutQuantityOfGates();
        List<Gate> gameGates = montyHallGame.getListOfGatesInOfflineGame(Integer.parseInt(scanner.next()));

        askAboutNumberOfGames();
        int numberOfGames = Integer.parseInt(scanner.next());

        MontyHall montyHall = new MontyHall(gameGates);

        askAboutAutoPlayerDecision();
        String placeHolder = scanner.next();
        if (placeHolder.equals("Y") || placeHolder.equals("y")) {
            player = new AutoPlayer(true);
        } else {
            player = new AutoPlayer(false);
        }


        for (int counterOfGames = 1; counterOfGames <= numberOfGames; counterOfGames++) {
            chosenGate = player.chooseGate(gameGates.size(), null);
            montyHall.setPlayerChoice(chosenGate);
            System.out.println("NR OF GAME: " + counterOfGames);
            System.out.println("CHOSEN GATE: " + chosenGate);

            if (montyHall.getAmountOfUncheckedGates() > 3) {
                int emptyGate = montyHall.openEmptyGate();
                System.out.println("OK. Monty opened gate no " + emptyGate + " and it's empty!");
            } else {
                if (player.changeLastGate()) {
                    System.out.println("OK. There are only 2 gates left. Should he change his mind? Your player decision is: " + player.changeLastGate());
                    if (gameGates.get(chosenGate - 1).isEmpty()) {
                        results.addWin();
                    } else {
                        results.addLoss();
                    }
                } else {
                    System.out.println("OK. There are only 2 gates left. Should he change his mind? Your player decision is: " + player.changeLastGate());
                    if (gameGates.get(chosenGate - 1).isEmpty()) {
                        results.addLoss();
                    } else {
                        results.addWin();
                    }
                }
                Map<String, BigDecimal> mapResult = results.computeResults();
                System.out.println("Percentage of wins: " + mapResult.get("wins"));
                System.out.println("Percentage of losses: " + mapResult.get("losses"));
            }

        }

    }
}
