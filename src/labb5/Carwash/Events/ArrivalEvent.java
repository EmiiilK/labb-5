package labb5.Carwash.Events;

import labb5.Carwash.Car;
import labb5.Carwash.CarWash;
import labb5.Carwash.CarWashState;
import labb5.Simulation.Events.Event;
import labb5.Simulation.Simulator;

public class ArrivalEvent extends Event {

    private Car car;
    public Car getCar() {
        return car;
    }

    public ArrivalEvent(double time) {
        super(time, "Arrival");
        car = new Car();
    }

    @Override
    public void execute(Simulator simulator) {

        CarWashState cws = (CarWashState)simulator.state;

        update(simulator);

        simulator.queue.add(new ArrivalEvent(cws.getTime() + cws.getNextArrival()));

        CarWash cw;

        if((cw = cws.getAvaliableCarWash()) != null) {
            cw.clean(car);
            simulator.queue.add(new LeaveEvent(cws.getTime() + cw.getWashTime(), cw));
        } else {
            if(cws.canQueueCar()) {
                cws.queueCar(car);
            } else {
                cws.reject();
            }
        }

    }
}
