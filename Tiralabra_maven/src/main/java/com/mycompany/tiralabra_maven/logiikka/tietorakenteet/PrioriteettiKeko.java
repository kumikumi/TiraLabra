package com.mycompany.tiralabra_maven.logiikka.tietorakenteet;

import java.util.Comparator;

/**
 * Tietorakenne, jota käytetään tähän varastoitujen elementtien tallettamiseen
 * ja ulos ottamiseen priorisoidussa järjestyksessä. Elementtien järjestämiseen
 * voidaan käyttää konstruktorin parametrina annettua Comparator-rajapinnan
 * toteuttavaa oliota, tai tämän puuttuessa elementtien luonnollista
 * järjestystä.
 *
 * @author mikko
 * @param <E> varastoitavien elementtien tyyppi
 */
public class PrioriteettiKeko<E> {

    private Object[] taulukko;
    private int taulukonKoko;
    private int koko;
    private Object temp;

    private final Comparator<? super E> vertailija;

    /**
     * Parametriton konstruktori luo tyhjän prioriteettikeon, josta elementtejä
     * saadaan ulos käyttäen niitten luonnollista järjestystä.
     */
    public PrioriteettiKeko() {
        this(null);
    }

    /**
     * Konstruktori, jolle annetaan parametrina Comparator-rajapinnan toteuttava
     * vertailija, jota elementtien järjestämisessä käytetään.
     *
     * @param vertailija
     */
    public PrioriteettiKeko(Comparator<? super E> vertailija) {
        this.vertailija = vertailija;
        this.taulukonKoko = 11;
        this.taulukko = new Object[taulukonKoko];
    }

    /**
     * Palauttaa ja poistaa keosta seuraavan elementin.
     * @return elementti
     */
    public E seuraava() {
        if (koko == 0) {
            return null;
        }
        E max = (E) (taulukko[0]);
        taulukko[0] = taulukko[koko - 1];
        koko--;
        heapify(0);
        return max;
    }
    
    /**
     * Palauttaa tiedon siitä onko jono tyhjä
     * @return onko tyhjä vai eikö ole
     */
    public boolean tyhja() {
        return koko == 0;
    }

    /**
     * Lisää kekoon elementin
     * @param lisattava 
     */
    public void lisaa(E lisattava) {
        koko++;
        if (koko == taulukonKoko) {
            Object[] uusiTaulukko = new Object[2*taulukonKoko];
            System.arraycopy(taulukko, 0, uusiTaulukko, 0, taulukonKoko);
            taulukonKoko = 2*taulukonKoko;
            taulukko = uusiTaulukko;
        }
        int i = koko - 1;
        taulukko[i] = lisattava;

        while (i > 0 && (suurempi(i, vanhempi(i)) == i)) {
            swap(i, vanhempi(i));
            i = vanhempi(i);
        }
        taulukko[i] = lisattava;
    }

    private int vanhempi(int indeksi) {
        return indeksi / 2;
    }

    private int vasenLapsi(int indeksi) {
        return 2 * indeksi;
    }

    private int oikeaLapsi(int indeksi) {
        return 2 * indeksi + 1;
    }

    private void swap(int i, int j) {
        this.temp = taulukko[i];
        taulukko[i] = taulukko[j];
        taulukko[j] = this.temp;
    }

    private void heapify(int i) {

        int right = oikeaLapsi(i);
        int left = vasenLapsi(i);
        if (right <= koko) {
            int largest = suurempi(left, right);

            if (suurempi(largest, i) == largest) {
                swap(i, largest);
                heapify(largest);
            }

        } else if (left == koko && (suurempi(left, i) == left)) {
            swap(i, left);
        }
    }

    private int suurempi(int i, int j) {
        if (vertailija == null) {
            if (((Comparable<? super E>) (taulukko[i])).compareTo((E) (taulukko[j])) < 0) {
                return i;
            } else {
                return j;
            }
        } else {

            if (vertailija.compare((E) taulukko[i], (E) taulukko[j]) < 0) {
                return i;
            } else {
                return j;
            }
        }
    }
}
