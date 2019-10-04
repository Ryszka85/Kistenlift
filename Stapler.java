package com.Kistenlift;

import java.util.List;
import java.util.Stack;

public class Stapler {
    private Stack<Kiste> leftRow;
    private Stack<Kiste> rightRow;
    private Lift lift;

    public Stapler(Lift lift, List<Kiste> boxes) {
        this.leftRow = new Stack<>();
        this.leftRow.addAll(boxes);
        this.rightRow = new Stack<>();
        this.lift = lift;
    }

    public int starten() {
        // validating weight of boxes
        for (Kiste kiste : leftRow) {
            if (kiste.gewicht > lift.maximalGewicht) {
                System.out.println("Gewicht von Kiste : " + kiste.farbe + " -- " + kiste.gewicht  + "kg unzulässig!");
                return -1;
            }
        }
        while (leftRow.size() > 0 || rightRow.size() > 0) {
            if (leftRow.size() != 0) {
                if (lift.einladen(leftRow.peek())) {
                    leftRow.pop();
                } else {
                    rightRow.push(leftRow.peek());
                    leftRow.pop();
                }
            } else {
                // if last box can t be combined
                if (rightRow.size() == 1 && !lift.einladen(rightRow.peek())) {
                    Lift.anzahlFahrten++;
                    return Lift.anzahlFahrten;
                }
                if (lift.einladen(rightRow.peek())) {
                    rightRow.pop();
                }
            }
        }
        return Lift.anzahlFahrten;
    }
}
