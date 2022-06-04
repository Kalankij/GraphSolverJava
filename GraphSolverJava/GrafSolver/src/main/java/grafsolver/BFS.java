package grafsolver;

public class BFS {

    public static boolean run(Graf graf) {
        if(graf.getWidth() == 1 && graf.getLength() == 1)
            return true;
        final int ilosc_wierzcholkow = graf.getRozmiar();
        int[][] zwiedzone;
        zwiedzone = new int[ilosc_wierzcholkow][2];
        for (int i = 0; i < ilosc_wierzcholkow; i++) {
            zwiedzone[i][0] = i;
            zwiedzone[i][1] = 0;
        }
        zwiedzone[0][1] = 1;
        int[] v;
        v = new int[ilosc_wierzcholkow];
        int vs = 1, vz = 0, i;
        v[0] = 0;
        int nrw = 0;
        while (vz < vs) {
            i = 0;
            Wierzcholek x = graf.getWierzcholek(v[vz]);
            while (x.krawedzi.size() > i) {
                nrw = x.krawedzi.get(i).getTo();
                if (zwiedzone[nrw][1] == 0) {
                    v[vs++] = nrw;
                    zwiedzone[nrw][1] = 1;
                }
                i++;
            }
            vz++;
        }
        int wynik = 0;
        for (int koniec = 0; koniec < ilosc_wierzcholkow; koniec++) {
            if (zwiedzone[koniec][1] == 1)
                wynik++;
        }
        return wynik == ilosc_wierzcholkow;
    }
}
