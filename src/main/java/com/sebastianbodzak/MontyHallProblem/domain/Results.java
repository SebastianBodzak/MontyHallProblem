package com.sebastianbodzak.MontyHallProblem.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbod on 18.04.2017.
 */
public class Results {

    private static final java.math.BigDecimal ONE_HUNDRED = new BigDecimal(100);
    private BigDecimal totalWins;
    private BigDecimal totalLosses;
    private BigDecimal totalWinsPercent;
    private BigDecimal totalLossesPercent;

    public Results() {
        this.totalWins = new BigDecimal(BigInteger.ZERO);
        this.totalLosses = new BigDecimal(BigInteger.ZERO);
    }

    public void addWin() {
        this.totalWins = this.totalWins.add(new BigDecimal(1));
    }

    public void addLoss() {
        this.totalLosses = this.totalLosses.add(new BigDecimal(1));
    }

    public Map<String, BigDecimal> computeResults() {
        BigDecimal totalResult = totalWins.add(totalLosses);
        MathContext rounding = new MathContext(4, RoundingMode.HALF_UP);
        totalWinsPercent = (totalWins.divide(totalResult, rounding)).multiply(ONE_HUNDRED).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        totalLossesPercent = ONE_HUNDRED.subtract(totalWinsPercent).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        Map<String, BigDecimal> results = new HashMap<>();
        results.put("wins", totalWinsPercent);
        results.put("losses", totalLossesPercent);
        return results;
    }
}
