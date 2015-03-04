package labb5.Simulation.Events;

import labb5.Simulation.Simulator;

public abstract class Event {

    protected double time;
    protected String name;

    public abstract void execute(Simulator simulator);

    public Event(double time, String name) {
        this.time = time;
        this.name = name;

    }

    protected void update(Simulator simulator) {
        simulator.state.setTime(time);
        simulator.state.eventHandled(this);
    }

    public double getTime() {
        return time;
    }
    public String getName() {
        return name;
    }

}
