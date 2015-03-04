package labb5.Simulation;

import java.util.ArrayList;

public class SortedSequence<T> {

    private ArrayList<T> sequence = new ArrayList<T>();
    private SequenceComparer<T> comparer;

    public SortedSequence(SequenceComparer<T> comp) {
        comparer = comp;
    }

    public void add(T element) {

        for(int i = 0; i<sequence.size(); i++) {
            T ei = sequence.get(i);
            if(comparer.compare(ei, element)) {
                sequence.add(i, element);
                return;
            }
        }

        sequence.add(element);
    }
    public boolean empty() {
        return sequence.size() == 0;
    }
    public T getFirst() {
        return empty() ? null : sequence.get(0);
    }
    public void removeFirst() {
        if(!empty())
            sequence.remove(0);
    }
    public T pop() {
        return empty() ? null : sequence.remove(0);
    }
    public int size() {
        return sequence.size();
    }
}
