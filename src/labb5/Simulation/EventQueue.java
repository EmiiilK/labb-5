package labb5.Simulation;

import labb5.Simulation.Events.Event;

public class EventQueue {
    private SortedSequence<Event> eventSequence = new SortedSequence<Event>(new SequenceComparer<Event>() {
        @Override
        public boolean compare(Event gt, Event lt) {
            return gt.getTime() > lt.getTime();
        }
    });

    public EventQueue() {
    }

    public void add(Event event) {
        eventSequence.add(event);
    }

    public Event next() {
        return eventSequence.pop();
    }
    public boolean hasNext() {
        return eventSequence.size() != 0;
    }
}
