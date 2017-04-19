package com.sebastianbodzak.MontyHallProblem.domain;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sbod on 18.04.2017.
 */
public class AutoPlayer implements Player {

    private boolean alwaysChangeMind;

    public AutoPlayer(boolean alwaysChangeMind) {
        this.alwaysChangeMind = alwaysChangeMind;
    }

    @Override
    public boolean changeLastGate() {
        return alwaysChangeMind;
    }

    @Override
    public int chooseGate(int amountOfGates, Optional<Integer> numberOfGate) {
        return ThreadLocalRandom.current().nextInt(1, amountOfGates + 1);
    }
}
