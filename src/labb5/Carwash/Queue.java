package labb5.Carwash;

import java.util.ArrayList;

public class Queue<T> {

    protected ArrayList<T> queue = new ArrayList<T>();

    public void add(T element) {
        queue.add(element);
    }
    public T pop() {
        return (queue.size() < 1) ? null : queue.remove(0);
    }
    public T getFirst() {
        return queue.get(0);
    }
    public void removeFirst() {
        if(queue.size() > 0)
            queue.remove(0);
    }
    public int size() {
        return queue.size();
    }
}
