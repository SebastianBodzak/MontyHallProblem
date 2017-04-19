package com.sebastianbodzak.MontyHallProblem.domain;

import java.util.ArrayList;
import java.util.List;

import static com.sebastianbodzak.MontyHallProblem.domain.CalculationUtils.getRandomNumberBetween;
import static com.sebastianbodzak.MontyHallProblem.domain.Gate.createEmptyGate;

/**
 * Created by sbod on 18.04.2017.
 */
public class OfflineInitializer implements Initializer {

    private final static int SMALLEST_NUMBER_OF_THE_GATE = 1;
    private List<Gate> gates;

    @Override
    public void prepareGame(int quantityOfGates) {
        this.gates = new ArrayList<>();
        for(int counter = SMALLEST_NUMBER_OF_THE_GATE; counter <= quantityOfGates; counter++)
            this.gates.add(createEmptyGate(counter));
        fillGateWithReward(gates);
    }

    @Override
    public List<Gate> getGates() {
        return gates;
    }

    private int fillGateWithReward(List<Gate> gates) {
        int randomGateNumber = getRandomNumberBetween(SMALLEST_NUMBER_OF_THE_GATE, gates.size());
        gates.get(randomGateNumber - 1).createGateWithReward();
        return randomGateNumber;
    }
}
