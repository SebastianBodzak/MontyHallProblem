package com.sebastianbodzak.MontyHallProblem.api;

import com.sebastianbodzak.MontyHallProblem.domain.Gate;
import com.sebastianbodzak.MontyHallProblem.domain.Initializer;
import com.sebastianbodzak.MontyHallProblem.domain.OfflineInitializer;

import java.util.List;

/**
 * Created by sbod on 18.04.2017.
 */
public class MontyHallGame {

    public List<Gate> getListOfGatesInOfflineGame(int quantityOfGates) {
        Initializer initializer = new OfflineInitializer();
        return initializer.prepareGame(quantityOfGates);
    }
}
