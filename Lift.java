package com.Kistenlift;

import java.util.ArrayList;
import java.util.List;

public class Lift {
    public int minimalGewicht;
    public int maximalGewicht;
    public static int anzahlFahrten = 0;
    private List<Kiste> anzahlKisten;

    public Lift(int min, int max) {
        this.minimalGewicht = min;
        this.maximalGewicht = max;
        this.anzahlKisten = new ArrayList<>();
    }

    private int calculateWeight() {
        return anzahlKisten
                .stream()
                .map(x -> x.gewicht)
                .reduce(0, Integer::sum);
    }

    public boolean einladen(Kiste k) {
        if (k.gewicht > maximalGewicht) return false;
        if (anzahlKisten.size() == 0 && k.gewicht >= minimalGewicht && k.gewicht <= maximalGewicht) {
            Lift.anzahlFahrten++;
            return true;
        }
        int totalWeight = calculateWeight() + k.gewicht;
        if (totalWeight < minimalGewicht) {
            anzahlKisten.add(k);
            return true;
        }
        if (totalWeight <= maximalGewicht) {
            anzahlKisten.clear();
            Lift.anzahlFahrten++;
            return true;
        }
        return false;
    }
}
