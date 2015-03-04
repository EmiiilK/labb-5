package labb5.Carwash;

import labb5.Random.UniformRandomStream;

public class CarWash {

    protected Car car;
    protected double lastWash = 0;
    public void setLastWash(double time) {
        lastWash = time;
    }
    public double getLastWash() {
        return lastWash;
    }

    protected boolean avaliable = true;
    protected UniformRandomStream distribution;

    public CarWash(UniformRandomStream stream) {
        this.distribution = stream;
    }

    public double getWashTime() {
        return distribution.next();
    }

    public boolean avaliable() {
        return avaliable;
    }
    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }
    public void clean(Car car) {
        this.car = car;
        avaliable = false;
    }

    public Car getCar() {
        return car;
    }
}
