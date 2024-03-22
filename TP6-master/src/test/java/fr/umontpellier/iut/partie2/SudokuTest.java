package fr.umontpellier.iut.partie2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    public static int[][] grille_sudoku22_incomplete2() {
        return new int[][]{
                {4, 1, 2, 3},
                {0, 0, 1, 4},
                {0, 3, 4, 1},
                {1, 4, 3, 2}
        };
    }

    static int[][] grille_sudoku22_gagnante() {
        return new int[][]{
                {4, 1, 2, 3},
                {3, 2, 1, 4},
                {2, 3, 4, 1},
                {1, 4, 3, 2}};
    }

    static int[][] grille_sudoku_nongagnante_ligne() {
        return new int[][]{
                {4, 1, 2, 3},
                {3, 2, 1, 4},
                {2, 3, 4, 2},
                {1, 4, 3, 1}};
    }

    @Disabled
    @Test
    public void test_sudoku22_est_gagnant_vrai() {
        Sudoku sudoku = new Sudoku(grille_sudoku22_gagnante());
        assertTrue(sudoku.estGagnant());
    }

    @Disabled
    @Test
    public void test_sudoku22_est_gagnant_faux_pbLignes() {
        Sudoku sudoku = new Sudoku(grille_sudoku_nongagnante_ligne());
        assertFalse(sudoku.estGagnant());
    }

}
