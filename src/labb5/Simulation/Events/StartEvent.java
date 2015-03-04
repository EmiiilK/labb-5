package labb5.Simulation.Events;

import labb5.Simulation.Simulator;

public class StartEvent extends Event {

    public StartEvent() {
        super(0, "Start");
    }

    @Override
    public void execute(Simulator simulator) {
        update(simulator);
    }
}
