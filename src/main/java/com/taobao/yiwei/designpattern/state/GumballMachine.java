package com.taobao.yiwei.designpattern.state;

import lombok.Getter;
import lombok.Setter;

public class GumballMachine {
    @Getter
    private State soldOutState;
    @Getter
    private State noQuarterState;
    @Getter
    private State hasQuarterState;
    @Getter
    private State soldState;
    @Getter
    private State winnerState;
    @Getter
    private int count;
    @Setter
    private State state;

    public GumballMachine(int numberGumballs) {
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count--;
        }
    }

    @Override
    public String toString() {
        return "\n=================================\n"
                + "Mighty Gumball, Inc\n"
                + "Java-enabled Standing Gumball Model #2004\n"
                + "Inventory:" + count + " gumballs\n"
                + "Machine is waiting for quarter\n"
                + "---------------------------------";
    }
}
