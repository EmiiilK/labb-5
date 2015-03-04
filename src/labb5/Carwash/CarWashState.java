package labb5.Carwash;

import labb5.Random.ExponentialRandomStream;
import labb5.Random.UniformRandomStream;
import labb5.Simulation.SimState;


public class CarWashState extends SimState {

    private SlowCarWash[] slowCarWashes;
    private FastCarWash[] fastCarWashes;

    private CarWash[] carWashes;

    private int rejected = 0;
    private double idleTime = 0;
    private double queueTime = 0;

    private int seed = 1234;
    public int getSeed() {
        return seed;
    }

    private double slowDistribuationLower = 3.5;
    private double slowDistribuationHigher = 6.7;
    private double fastDistribuationLower = 2.8;
    private double fastDistribuationHigher = 4.6;

    public double getSlowDistribuationLower() { return slowDistribuationLower; }
    public double getSlowDistribuationHigher() { return slowDistribuationHigher; }
    public double getFastDistribuationLower() { return fastDistribuationLower; }
    public double getFastDistribuationHigher() { return fastDistribuationHigher; }

    private UniformRandomStream slowDistribuation = new UniformRandomStream(slowDistribuationLower, slowDistribuationHigher, seed);
    private UniformRandomStream fastDistribuation = new UniformRandomStream(fastDistribuationLower, fastDistribuationHigher, seed);

    private CarQueue carQueue = new CarQueue();

    private double lambda = 2.0;
    public double getLambda() { return lambda; }
    private ExponentialRandomStream arrivalCalculator = new ExponentialRandomStream(lambda, seed);
    public double getNextArrival() {
        return arrivalCalculator.next();
    }

    public CarWashState(int fast, int slow) {
        super(0);

        slowCarWashes = new SlowCarWash[slow];
        fastCarWashes = new FastCarWash[fast];
        carWashes = new CarWash[slow+fast];

        for(int i = 0; i<slowCarWashes.length; i++) {
            slowCarWashes[i] = new SlowCarWash(slowDistribuation);
        }
        for(int i = 0; i<fastCarWashes.length; i++) {
            fastCarWashes[i] = new FastCarWash(fastDistribuation);
        }

        int i;
        for(i = 0; i<fastCarWashes.length; i++) {
            carWashes[i] = fastCarWashes[i];
        }
        for(int j = 0; j<slowCarWashes.length; j++, i++) {
            carWashes[i] = slowCarWashes[j];
        }
    }

    public void reject() {
        rejected++;
    }
    public int getRejected() {
        return rejected;
    }

    public int getAvaliableFastCarWashes() {
        int i = 0;
        for(FastCarWash fcw : fastCarWashes)  {
            if(fcw.avaliable())
                i++;
        }

        return i;
    }
    public int getAvaliableSlowCarWashes() {
        int i = 0;
        for(SlowCarWash scw : slowCarWashes)  {
            if(scw.avaliable())
                i++;
        }

        return i;
    }

    public CarWash getAvaliableCarWash() {
        for(CarWash cw : carWashes) {
            if(cw.avaliable())
                return cw;
        }

        return null;
    }

    public boolean canQueueCar() {
        return carQueue.canQueue();
    }
    public void queueCar(Car car) {
        carQueue.queueCar(car);
    }
    public Car getQueuedCar() {
        return carQueue.next();
    }
    public int queuedCars() {
        return carQueue.size();
    }

    public double getIdleTime() {
        return idleTime;
    }
    public double getQueueTime() {
        return queueTime;
    }
    public int getQueueSize() {
        return carQueue.size();
    }
    public int getMaxQueueSize() {
        return carQueue.MAX_SIZE;
    }
}