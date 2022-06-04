package grafsolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Dijkstra {

    public static ArrayList<Wierzcholek> run (Graf graf,int start,int end) {
        Kolejka kolejka = new Kolejka(graf.getRozmiar());
        int[] QS = new int[graf.getRozmiar()];
        ArrayList<Wierzcholek> wynik = new ArrayList<>();
        int v = start;
        kolejka.d[v] = 0;
        int tmp = kolejka.q[0].getTop();
        kolejka.q[0].setTop(kolejka.q[v].getTop());
        kolejka.q[v].setTop(tmp);
        kolejka.q[v].setPlace(0);
        kolejka.q[0].setPlace(v);
        int u;
        int i;
        for (i = 0; i < graf.getRozmiar(); i++) {
            u = kolejka.pop();
            QS[u] = 1;
            Wierzcholek iterator = graf.getWierzcholek(u);
            for ( Krawedz k : iterator) {
                if (QS[k.getTo()] == 0 && ( kolejka.d[k.getTo()] > (kolejka.d[u] + k.getWaga()))) {
                    kolejka.d[k.getTo()] = kolejka.d[u] + k.getWaga();
                    kolejka.p[k.getTo()] = u;
                    kolejka.fix(k.getTo());
                }
            }
        }
        i = end;
        wynik.add(graf.getWierzcholek(end));
        while (kolejka.p[i] != -1) {
            wynik.add(graf.getWierzcholek(kolejka.p[i]));
            i = kolejka.p[i];
        }
        return wynik;
    }
}
class Kolejka implements Iterable<Elem>{

    private int rozmiar;
    public Elem [] q;
    private int n;
    public double [] d;
    public int [] p;

    public Kolejka (int rozmiar) {
        this.rozmiar = rozmiar;
        q = new Elem[rozmiar];
        d = new double[rozmiar];
        p = new int[rozmiar];
        for ( int i = 0; i < rozmiar; i++) {
            d[i] = Double.MAX_VALUE;
            p[i] = -1;
        }
        n = 0;
        add();
    }
    private void add() {
        int i = n;
        for (int l = 0; l < q.length; l++,i=n) {
            Elem e = new Elem(i,i);
            q[l] = e;
            n++;
        }
    }

    public int pop() {
        int ret = q[0].getTop();
        q[0].setTop(q[--n].getTop());
        q[q[0].getTop()].setPlace(0);
        int i = 0,l,j;
        int right = 0;
        int left = 0;
        while ( true ) {
            j = 2*i+1;
            l = 2*i+2;
            if ( j >= n ) break;
            if ( d[q[j].getTop()] < d[q[l].getTop()] ) {
                left = 1;
            }
		    else right = 1;
            if ( right == 1 ) j++;
            if ( d[q[i].getTop()] <= d[q[j].getTop()] ) break;
            int tmp = q[i].getTop();
            q[i].setTop(q[j].getTop());
            q[j].setTop(tmp);
            q[i].setPlace(i);
            q[j].setPlace(j);
            i = j;
            right = 0;
            left = 0;
        }
        return ret;
    }
    void fix ( int x) {
        int i,j;
        i = q[x].getPlace();
        while ( i != 0 ) {
            j = (i-1)/ 2;
            if ( d[q[j].getTop()] <=  d[q[i].getTop()] ) break;
            int tmp = q[j].getTop();
            q[j].setTop(q[i].getTop());
            q[i].setTop(tmp);
            q[q[j].getTop()].setPlace(j);
            q[q[i].getTop()].setPlace(i);
            i = j;
        }
    }
    @Override
    public Iterator<Elem> iterator() {
        return Arrays.stream(q).iterator();
    }
}

class Elem {
    private int place;
    private int top;
    public Elem (int place,int top) {
        this.place = place;
        this.top = top;
    }

    public int getPlace() {
        return place;
    }

    public int getTop() {
        return top;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setTop(int top) {
        this.top = top;
    }
}