package grafsolver;

import java.util.ArrayList;
import java.util.Iterator;

public class Wierzcholek implements Iterable<Krawedz>{
    ArrayList<Krawedz> krawedzi = new ArrayList<>();
    private final int numer;

    public Wierzcholek(int numer) {
        this.numer = numer;
    }
    public void addKrawedz ( int to, double waga) {
        Krawedz krawedz = new Krawedz(to,waga);
        krawedzi.add(krawedz);
    }

    public ArrayList<Krawedz> getKrawedzi() {
        return krawedzi;
    }

    @Override
    public Iterator<Krawedz> iterator() {
        return krawedzi.iterator();
    }
}
