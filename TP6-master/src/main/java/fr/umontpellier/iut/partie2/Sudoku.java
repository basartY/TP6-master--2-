package fr.umontpellier.iut.partie2;
import java.util.ArrayList;
import java.util.Arrays;




public class Sudoku implements JeuPuzzle<Sudoku> {
    private final int[][] grille;

    public Sudoku(int[][] g) {
        this.grille = g;
    }

    @Override
    public boolean estGagnant() {
        return estComplete() && estPossible();
    }

    @Override
    public ArrayList<Sudoku> genererFils() {
        ArrayList<Sudoku> fils = new ArrayList<>();
        int[] coordonnees = trouverCaseVide();
        int i = coordonnees[0];
        int j = coordonnees[1];
        if (i != -1 && j != -1) {
            for (int k = 1; k <= grille.length; k++) {
                if (estNombreValide(i, j, k)) {
                    int[][] nouvelleGrille = copierGrille();
                    nouvelleGrille[i][j] = k;
                    fils.add(new Sudoku(nouvelleGrille));
                }
            }
        }
        return fils;
    }

    private boolean estComplete() {
        for (int[] ligne : grille) {
            for (int cellule : ligne) {
                if (cellule == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean estPossible() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                if (!estCasePossible(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean estCasePossible(int i, int j) {
        int num = grille[i][j];
        grille[i][j] = 0;
        boolean estPossible = estNombreValide(i, j, num);
        grille[i][j] = num;
        return estPossible;
    }

    private int[] trouverCaseVide() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                if (grille[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private boolean estNombreValide(int i, int j, int num) {
        return !estPresentSurLigne(i, num) && !estPresentSurColonne(j, num) && !estPresentDansBloc(i, j, num);
    }

    private boolean estPresentSurLigne(int i, int num) {
        for (int valeur : grille[i]) {
            if (valeur == num) {
                return true;
            }
        }
        return false;
    }

    private boolean estPresentSurColonne(int j, int num) {
        for (int i = 0; i < grille.length; i++) {
            if (grille[i][j] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean estPresentDansBloc(int i, int j, int num) {
        int n = (int) Math.sqrt(grille.length);
        int startRow = i - i % n;
        int startCol = j - j % n;
        for (int row = startRow; row < startRow + n; row++) {
            for (int col = startCol; col < startCol + n; col++) {
                if (grille[row][col] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] copierGrille() {
        int[][] copie = new int[grille.length][grille[0].length];
        for (int i = 0; i < grille.length; i++) {
            System.arraycopy(grille[i], 0, copie[i], 0, grille[0].length);
        }
        return copie;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] ligne : grille) {
            for (int valeur : ligne) {
                sb.append(valeur).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}