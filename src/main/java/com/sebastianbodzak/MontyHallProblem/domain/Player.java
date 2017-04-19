package com.sebastianbodzak.MontyHallProblem.domain;

import java.util.Optional;

/**
 * Created by sbod on 18.04.2017.
 */
public interface Player {

    boolean changeLastGate();
    int chooseGate(int amountOfGates, Optional<Integer> numberOfGate);
}
