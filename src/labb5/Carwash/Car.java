package labb5.Carwash;

public class Car {

    private static int prev_id;
    private int id;

    public Car() {
        id = prev_id++;
    }
    public int getId() {
        return id;
    }
}
