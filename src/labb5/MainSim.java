package labb5;

import labb5.Simulation.Simulator;

public class MainSim {
    public static void main(String[] args) {
        Simulator sim;
        try {
            sim = new Simulator();
            sim.run();
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
