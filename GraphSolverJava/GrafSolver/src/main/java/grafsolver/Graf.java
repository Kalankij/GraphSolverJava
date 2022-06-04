package grafsolver;

import java.util.Arrays;
import java.util.Iterator;

public class Graf implements Iterable<Wierzcholek>{
    public final int rozmiar;
    private  int length;
    private  int width;
    private double from;
    private double to;
    Wierzcholek [] wierzcholki;

    public Graf(int length, int width,double from, double to) {
        this.width = width;
        this.length = length;
        this.rozmiar = width*length;
        this.from = from;
        this.to = to;
        wierzcholki= new Wierzcholek[rozmiar];
        for ( int i = 0; i < rozmiar; i++) {
            Wierzcholek tmp = new Wierzcholek(i);
            wierzcholki[i] = tmp;
        }
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public  int getWidth() {
        return width;
    }

    public  int getLength() {
        return length;
    }

    public Wierzcholek getWierzcholek(int numer) {
        return wierzcholki[numer];
    }

    @Override
    public Iterator<Wierzcholek> iterator() {
        return Arrays.stream(wierzcholki).iterator();
    }
}

