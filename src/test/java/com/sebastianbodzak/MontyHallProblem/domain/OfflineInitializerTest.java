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

    private final int QuantityOfGates = 10;
    private final int expectedEmptyGates = 9;
    private final int expectedGateWithReward = 1;

    @Test
    public void shouldPrepareGame() {
        Initializer initializer = new OfflineInitializer();

        initializer.prepareGame(QuantityOfGates);

        List<Gate> allGates = initializer.getGates();
        List<Gate> emptyGates = initializer.getGates().stream().filter(gate -> gate.isEmpty() == true).collect(Collectors.toList());
        List<Gate> gatesWithReward = initializer.getGates().stream().filter(gate -> gate.isEmpty() == false).collect(Collectors.toList());
        assertEquals(10, allGates.size());
        assertEquals(9, emptyGates.size());
        assertEquals(1, gatesWithReward.size());
    }
}
