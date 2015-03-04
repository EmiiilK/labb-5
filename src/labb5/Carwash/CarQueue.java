package labb5.Carwash;

public class CarQueue {

    public final int MAX_SIZE = 5;
    private Queue<Car> queue = new Queue<Car>();

    public Car next() {
        return queue.pop();
    }

    public boolean queueCar(Car car) {
        if(canQueue()) {
            queue.add(car);
            return true;
        }

        return false;
    }

    public boolean canQueue() {
        return queue.size() < MAX_SIZE;
    }
    public int size() {
        return queue.size();
    }
}
