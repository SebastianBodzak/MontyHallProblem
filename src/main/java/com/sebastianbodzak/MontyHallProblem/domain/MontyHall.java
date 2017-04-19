package com.sebastianbodzak.MontyHallProblem.domain;

import java.util.List;
import java.util.Optional;

/**
 * Created by sbod on 18.04.2017.
 */
public class MontyHall {

    private final static int SMALLEST_NUMBER_OF_THE_GATE = 1;
    private List<Gate> gates;
    private int playerChoice;
    private int amountOfUncheckedGates;

    public MontyHall(Initializer initializer, Player player, Optional<Integer> chosenGate) {
        this.gates = initializer.getGates();
        this.playerChoice = player.chooseGate(gates.size(), chosenGate);
        this.amountOfUncheckedGates = gates.size();
    }

    public int openEmptyGate() {
        while (true) {
            int randomNumber = CalculationUtils.getRandomNumberBetween(SMALLEST_NUMBER_OF_THE_GATE, gates.size());
            Gate gate = gates.get(randomNumber - 1);
            if (checkIfGateCanBeOpen(gate)) {
                gate.setGateAsChecked();
                amountOfUncheckedGates =- 1;
                return randomNumber;
            }
        }
    }

    private boolean checkIfGateCanBeOpen(Gate gate) {
        return !gate.isChecked() && gate.getNumber() != playerChoice && gate.isEmpty();
    }

    public int getAmountOfUncheckedGates() {
        return amountOfUncheckedGates;
    }
}
