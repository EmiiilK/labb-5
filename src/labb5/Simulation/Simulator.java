package labb5.Simulation;

import labb5.Carwash.Events.ArrivalEvent;
import labb5.Carwash.CarWashState;
import labb5.Carwash.CarWashView;
import labb5.Simulation.Events.StartEvent;
import labb5.Simulation.Events.StopEvent;

public class Simulator {

    public SimState state;
    public SimView view;
    public EventQueue queue;

    private boolean running = false;

    public Simulator() {
        state = new CarWashState(2, 2);
        view = new CarWashView(state);
        queue = new EventQueue();

        queue.add(new StopEvent(15));
        queue.add(new ArrivalEvent(((CarWashState)state).getNextArrival()));
    }
    public void run() throws InterruptedException {
        running = true;

        queue.add(new StartEvent());

        while(running) {
            if(queue.hasNext()) {
                queue.next().execute(this);
            } else {
                Thread.sleep(100);
            }
        }
    }
    public void stop() {
        running = false;
    }

}
