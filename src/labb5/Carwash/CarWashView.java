package labb5.Carwash;

import labb5.Carwash.Events.ArrivalEvent;
import labb5.Carwash.Events.LeaveEvent;
import labb5.Simulation.Events.Event;
import labb5.Simulation.SimState;
import labb5.Simulation.SimView;
import labb5.Simulation.Events.StopEvent;

import java.util.Observable;

public class CarWashView extends SimView {

    private CarWashState cwState;

    public CarWashView(SimState state) {
        super(state);

        cwState = (CarWashState)state;
        printSettings();
    }

    private void printSettings() {
        write("Fast machines: %d", cwState.getAvaliableFastCarWashes());
        write("Slow machines: %d", cwState.getAvaliableSlowCarWashes());

        write("Fast distribution: (%.1f, %.1f)", cwState.getFastDistribuationLower(), cwState.getFastDistribuationHigher());
        write("Slow distribution: (%.1f, %.1f)", cwState.getSlowDistribuationLower(), cwState.getSlowDistribuationHigher());
        write("Exponential distribution with lambda = %.1f", cwState.getLambda());

        write("Seed = %d", cwState.getSeed());
        write("Max Queue size: %d", cwState.getMaxQueueSize());

        write("-----------------------------------");
        write("%-8s%-6s%-6s%-5s%-11s%-10s%-11s%-11s%-10s", "Time", "Fast", "Slow", "Id", "Event", "IdleTime", "QueueTime", "QueueSize", "Rejected");

    }
    private void printFinalResults() {
        write("---------------------------");
        write("Total idle matchine time: %.2f", cwState.getIdleTime());
        write("Total queueing time: %.2f", cwState.getQueueTime());
        write("Mean queueing time: %.2f", 2.0);
        write("Rejected cars: %d", cwState.getRejected());
    }

    @Override
    public void update(Observable o, Object arg) {
        super.update(o, arg);

        Event e = (Event)arg;

        String id = "-";
        if(e instanceof ArrivalEvent) {
            id = ((ArrivalEvent)e).getCar().getId()+"";
        }
        if(e instanceof LeaveEvent) {
            id = ((LeaveEvent)e).getCar().getId()+"";
        }

        write("%-8.2f%-6d%-6d%-5s%-11s%-10.2f%-11.2f%-11d%-10d",
                e.getTime(),
                cwState.getAvaliableFastCarWashes(),
                cwState.getAvaliableSlowCarWashes(),
                id,
                e.getName(),
                cwState.getIdleTime(),
                cwState.getQueueTime(),
                cwState.getQueueSize(),
                cwState.getRejected());

        if(e instanceof StopEvent) {
            printFinalResults();
        }
    }
}
