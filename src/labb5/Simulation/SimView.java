package labb5.Simulation;

import labb5.Simulation.Events.Event;

import java.util.Observable;
import java.util.Observer;

public abstract class SimView implements Observer {

    protected SimState state;

    public SimView(SimState state) {
        this.state = state;
        state.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Event e = (Event)arg;


    }

    protected void write(Object o) {
        System.out.println(o);
    }
    protected void write(String str, Object... args) {
        System.out.println(String.format(str, args));
    }
}
