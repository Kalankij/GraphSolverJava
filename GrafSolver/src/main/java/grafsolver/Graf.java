package grafsolver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Graf implements Iterable<Wierzcholek>{
    private final int rozmiar;
    private int length;
    private int width;
    Wierzcholek [] wierzcholki;

    public Graf(int length, int width) {
        this.width = width;
        this.length = length;
        this.rozmiar = width*length;
        wierzcholki= new Wierzcholek[rozmiar];
        for ( int i = 0; i < rozmiar; i++) {
            Wierzcholek tmp = new Wierzcholek(i);
            wierzcholki[i] = tmp;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
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
