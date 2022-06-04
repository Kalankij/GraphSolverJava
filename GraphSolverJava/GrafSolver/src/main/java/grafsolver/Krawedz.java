package grafsolver;

import java.util.Iterator;

public class Krawedz {
    private final double waga;
    private final int to;

    public Krawedz(int to, double waga) {
        this.waga = waga;
        this.to = to;
    }

    public int getTo() {
        return to;
    }

    public double getWaga() {
        return waga;
    }

}
