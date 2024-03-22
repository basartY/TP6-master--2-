package fr.umontpellier.iut.partie1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CoupleTest {
    @Disabled
    @Test
    public void test_couple_getListeDeMouvements() {
        int[][] data1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Taquin taquin1 = new Taquin(data1);

        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Taquin taquin2 = new Taquin(data2);

        Couple couple2 = new Couple(taquin2, null);
        Couple couple1 = new Couple(taquin1, couple2);

        ArrayList<Taquin> res = couple1.getListeDeMouvements();
        ArrayList<Taquin> res2 = new ArrayList<>();
        res2.add(taquin2);
        res2.add(taquin1);
        assertEquals(res, res2);
    }

    @Disabled
    @Test
    public void test_couple_mise_a_jour() {
        int[][] data = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
        Taquin taquin = new Taquin(data);
        Couple c = new Couple(taquin, null);


        int[][] datafils1 = {{1, 2, 3}, {4, 5, 0}, {7, 8, 6}};
        Taquin fils1 = new Taquin(datafils1);
        ArrayList<Taquin> dejavu = new ArrayList<>();
        dejavu.add(fils1);

        ArrayList<Couple> frontiere = new ArrayList<>();

        c.mettreAJour(frontiere, dejavu);
        assertTrue(frontiere.size() == 1 && dejavu.size() == 2);
    }
}