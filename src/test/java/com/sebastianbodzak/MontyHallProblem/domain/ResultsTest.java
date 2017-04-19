package com.sebastianbodzak.MontyHallProblem.domain;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by sbod on 18.04.2017.
 */
public class ResultsTest {

    public final int totalWins = 107;
    public final int totalLosses = 40;
    public final BigDecimal totalWinsPercentage = new BigDecimal(72.79).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    public final BigDecimal totalLossesPercentage = new BigDecimal(27.21).setScale(2, BigDecimal.ROUND_HALF_EVEN);

    @Test
    public void shouldComputeResults() {
        Results results = new Results();
        addTotalWins(results, totalWins);
        addTotalLosses(results, totalLosses);

        Map<String, BigDecimal> resultMap = results.computeResults();

        BigDecimal winsPerc = resultMap.get("wins");
        BigDecimal lossesPerc = resultMap.get("losses");
        assertEquals(totalWinsPercentage, winsPerc);
        assertEquals(totalLossesPercentage, lossesPerc);

    }

    private void addTotalWins(Results results, int totalWins) {
        for(int counter = 0; counter < totalWins; counter++)
            results.addWin();
    }

    private void addTotalLosses(Results results, int totalLosses) {
        for(int counter = 0; counter < totalLosses; counter++)
            results.addLoss();
    }
}
