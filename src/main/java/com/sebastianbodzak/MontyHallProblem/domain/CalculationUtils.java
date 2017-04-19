package com.sebastianbodzak.MontyHallProblem.domain;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by sbod on 18.04.2017.
 */
public class CalculationUtils {

    public static int getRandomNumberBetween(int minValue, int maxValue) {
        return ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
    }
}
