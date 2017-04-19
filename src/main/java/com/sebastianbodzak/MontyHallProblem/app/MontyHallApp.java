package com.sebastianbodzak.MontyHallProblem.app;

import com.sebastianbodzak.MontyHallProblem.domain.*;

import java.math.BigDecimal;
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


        Initializer initializer = new OfflineInitializer();
        Scanner scanner = new Scanner(System.in);
        Player player;
        MontyHall montyHall;
        Results results = new Results();
        int chosenGate;
        String placeHolder;

        askAboutQuantityOfGates();
        initializer.prepareGame(Integer.parseInt(scanner.next()));

        askAboutNumberOfGames();
        int numberOfGames = Integer.parseInt(scanner.next());

        askAboutAutoPlayerDecision();
        placeHolder = scanner.next();
        if (placeHolder.equals("Y") || placeHolder.equals("y")) {
            player = new AutoPlayer(true);
            montyHall = new MontyHall(initializer, player, null);
        } else {
            player = new AutoPlayer(false);
            montyHall = new MontyHall(initializer, player, null);
        }


        for (int counterOfGames = 1; counterOfGames <= numberOfGames; counterOfGames++) {
            chosenGate = player.chooseGate(initializer.getGates().size(), null);
            System.out.println("NR OF GAME: " + counterOfGames);
            System.out.println("CHOSEN GATE: " + chosenGate);

            if (montyHall.getAmountOfUncheckedGates() > 3) {
                int emptyGate = montyHall.openEmptyGate();
                System.out.println("OK. Monty opened gate no " + emptyGate + " and it's empty!");
            } else {
                if (player.changeLastGate()) {
                    System.out.println("OK. There are only 2 gates left. Should he change his mind? Your player decision is: " + player.changeLastGate());
                    if (initializer.getGates().get(chosenGate - 1).isEmpty()) {
                        results.addWin();
                    } else {
                        results.addLoss();
                    }
                } else {
                    System.out.println("OK. There are only 2 gates left. Should he change his mind? Your player decision is: " + player.changeLastGate());
                    if (initializer.getGates().get(chosenGate - 1).isEmpty()) {
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
