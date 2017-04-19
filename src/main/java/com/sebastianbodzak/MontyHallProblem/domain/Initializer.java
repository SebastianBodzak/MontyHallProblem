package com.sebastianbodzak.MontyHallProblem.domain;

import java.util.List;

/**
 * Created by sbod on 18.04.2017.
 */
public interface Initializer {

    List<Gate> prepareGame(int quantityOfGates);
}
