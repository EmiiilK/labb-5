package labb5.Simulation;

import labb5.Simulation.Events.Event;

import java.util.Observable;

public abstract class SimState extends Observable {
    protected double time;

    public SimState(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }
    public void setTime(double time) {
        this.time = time;
    }

    public void eventHandled(Event event) {
        setChanged();
        notifyObservers(event);
    }
}
