package fr.umontpellier.iut.partie2;

import java.util.ArrayList;

public interface JeuPuzzle<T extends JeuPuzzle<T>> {
    boolean estGagnant();
    ArrayList<T> genererFils();
}
