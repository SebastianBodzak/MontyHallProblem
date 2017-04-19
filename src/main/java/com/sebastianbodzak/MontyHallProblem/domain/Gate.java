package com.sebastianbodzak.MontyHallProblem.domain;

/**
 * Created by sbod on 18.04.2017.
 */
public class Gate {

    private int number;
    private boolean empty;
    private boolean checked;

    private Gate(boolean empty, int number) {
        this.empty = empty;
        this.number = number;
    }

    public static Gate createEmptyGate(int number) {
        return new Gate(true, number);
    }

    public void createGateWithReward() {
        this.empty = false;
    }

    public void resetGateToEmpty(Gate gate) {
        gate.empty = true;
        gate.checked = false;
    }

    public void setGateAsChecked() {
        this.checked = true;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isChecked() {
        return checked;
    }

    public int getNumber() {
        return number;
    }
}
