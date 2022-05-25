package grafsolver;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Graf implements Iterable<Wierzcholek>{
    private final int rozmiar;
    Wierzcholek [] wierzcholki;

    public Graf(int rozmiar) {
        this.rozmiar = rozmiar;
        wierzcholki= new Wierzcholek[rozmiar];
        for ( int i = 0; i < rozmiar; i++) {
            Wierzcholek tmp = new Wierzcholek(i);
            wierzcholki[i] = tmp;
        }
    }

    public Wierzcholek getWierzcholek(int numer) {
        return wierzcholki[numer];
    }

    @Override
    public Iterator<Wierzcholek> iterator() {
        return Arrays.stream(wierzcholki).iterator();
    }
}

