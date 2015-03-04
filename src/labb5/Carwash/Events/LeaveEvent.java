package labb5.Carwash.Events;

import labb5.Carwash.Car;
import labb5.Carwash.CarWash;
import labb5.Carwash.CarWashState;
import labb5.Simulation.Events.Event;
import labb5.Simulation.Simulator;

public class LeaveEvent extends Event {

    private CarWash carWash;

    public Car getCar() {
        return carWash.getCar();
    }

    public LeaveEvent(double time, CarWash carWash) {
        super(time, "Leave");

        this.carWash = carWash;
    }

    @Override
    public void execute(Simulator simulator) {

        CarWashState cws = (CarWashState)simulator.state;
        update(simulator);

        Car car;

        if((car = cws.getQueuedCar()) != null) {
            carWash.clean(car);
            simulator.queue.add(new LeaveEvent(cws.getTime() + carWash.getWashTime(), carWash));
        } else {
            carWash.setAvaliable(true);
        }

    }
}
