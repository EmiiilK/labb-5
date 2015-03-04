package labb5.Simulation.Events;

import labb5.Simulation.Simulator;

public class StopEvent extends Event {

    public StopEvent(double time) {
        super(time, "Stop");
    }

    @Override
    public void execute(Simulator simulator) {
        update(simulator);
        simulator.stop();
    }
}
