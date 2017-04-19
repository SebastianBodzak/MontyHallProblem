package com.sebastianbodzak.MontyHallProblem.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by sbod on 18.04.2017.
 */
public class OfflineInitializerTest {

    private final int quantityOfGates = 10;
    private final int expectedEmptyGates = 9;
    private final int expectedGateWithReward = 1;

    @Test
    public void shouldPrepareGame() {
        Initializer initializer = new OfflineInitializer();

        List<Gate> allGates = initializer.prepareGame(quantityOfGates);

        List<Gate> emptyGates = allGates.stream().filter(gate -> gate.isEmpty() == true).collect(Collectors.toList());
        List<Gate> gatesWithReward = allGates.stream().filter(gate -> gate.isEmpty() == false).collect(Collectors.toList());
        assertEquals(quantityOfGates, allGates.size());
        assertEquals(expectedEmptyGates, emptyGates.size());
        assertEquals(expectedGateWithReward, gatesWithReward.size());
    }
}
