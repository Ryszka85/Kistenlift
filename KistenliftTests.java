package com.Kistenlift;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KistenliftTests {

    @org.junit.jupiter.api.Test
    void oneBox() {
        Lift lift = new Lift(40, 60);
        List<Kiste> kisten = new ArrayList<>();
        kisten.add(new Kiste(50, "rot"));
        Stapler stapler = new Stapler(lift, kisten);
        assertEquals(1,stapler.starten());
    }

    @Test
    void threeBoxes() {
        Lift lift = new Lift(80, 100);
        List<Kiste> kisten = new ArrayList<>();
        kisten.add(new Kiste(50, "rot"));
        kisten.add(new Kiste(20, "blau"));
        kisten.add(new Kiste(25, "grün"));
        Stapler stapler = new Stapler(lift, kisten);
        assertEquals(1,stapler.starten());
    }

    @Test
    void threeBoxesLowerRange() {
        Lift lift = new Lift(40, 60);
        List<Kiste> kisten = new ArrayList<>();
        kisten.add(new Kiste(50, "rot"));
        kisten.add(new Kiste(20, "blau"));
        kisten.add(new Kiste(25, "grün"));
        Stapler stapler = new Stapler(lift, kisten);
        assertEquals(2,stapler.starten());
    }

    @Test
    void exampleFromPic() {
        Lift lift = new Lift(80, 100);
        List<Kiste> kisten = new ArrayList<>();
        kisten.add(new Kiste(15, "grün"));
        kisten.add(new Kiste(30, "blau"));
        kisten.add(new Kiste(25, "grün"));
        kisten.add(new Kiste(10, "blau"));
        kisten.add(new Kiste(30, "rot"));
        kisten.add(new Kiste(45, "grau"));
        kisten.add(new Kiste(23, "rosa"));
        kisten.add(new Kiste(50, "grün"));
        kisten.add(new Kiste(55, "blau"));
        kisten.add(new Kiste(34, "rot"));
        kisten.add(new Kiste(20, "grau"));
        kisten.add(new Kiste(40, "rosa"));
        Stapler stapler = new Stapler(lift, kisten);
        assertEquals(4,stapler.starten());
    }

    @Test
    void ownExample() {
        Lift lift = new Lift(60, 80);
        List<Kiste> kisten = new ArrayList<>();
        kisten.add(new Kiste(77, "rot"));
        kisten.add(new Kiste(35, "blau"));
        kisten.add(new Kiste(36, "grün"));
        kisten.add(new Kiste(25, "blau"));
        kisten.add(new Kiste(40, "grün"));
        Stapler stapler = new Stapler(lift, kisten);
        assertEquals(3,stapler.starten());
    }
}