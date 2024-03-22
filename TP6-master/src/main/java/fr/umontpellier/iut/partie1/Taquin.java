package fr.umontpellier.iut.partie1;

import java.util.ArrayList;
import java.util.Arrays;

public class Taquin {
    private final int[][] tableau;

    public Taquin(int[][] tableau) {
        this.tableau = tableau;
    }

    public Taquin(Taquin taquin){

        this.tableau = new int[taquin.tableau.length][taquin.tableau[0].length];
        for ( int i = 0 ; i < tableau.length ; i ++){
            for ( int j = 0 ; j < tableau[0].length ; j++){
                this.tableau[i][j] = taquin.tableau[i][j];
            }
        }
    }

    /**
     * @return true si le Taquin courant est dans une configuration gagnante
     */
    public boolean estGagnant() {
        
        int cases = tableau.length * tableau[0].length;
        int valeur = 1;
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] != valeur % cases) {
                    return false;
                }
                valeur++;
            }
        }
        return true;
    }



   /**
     * @return la liste des configurations obtenues avec un seul mouvement
     * à partir du Taquin courant
     */
    public ArrayList<Taquin> genererFils() {

        ArrayList<Taquin> list = new ArrayList<>();
        int[] coord = trouverTrou();
        int l = coord[0];
        int c = coord[1];

        if (l > 0) {         //Haut
            list.add(deplacer(l, c, l - 1, c));
        }

        if (l < tableau.length - 1) {    //Bas
            list.add(deplacer(l, c, l + 1, c));
        }

        if (c > 0) {        //Gauche
            list.add(deplacer(l, c, l, c - 1));
        }

        if (c < tableau[0].length - 1) {     //Droite
            list.add(deplacer(l, c, l, c + 1));
        }

        return list;
    }

    private Taquin deplacer(int x1, int y1, int x2, int y2) {
        int[][] newTableau = copierTableau();
        echangerPositions(newTableau, x1, y1, x2, y2);
        return new Taquin(newTableau);
    }

    private int[][] copierTableau() {
        int[][] newTableau = new int[tableau.length][tableau[0].length];
        for (int i = 0; i < tableau.length; i++) {
            System.arraycopy(tableau[i], 0, newTableau[i], 0, tableau[i].length);
        }
        return newTableau;
    }

    private void echangerPositions(int[][] tableau, int x1, int y1, int x2, int y2) {
        int temp = tableau[x1][y1];
        tableau[x1][y1] = tableau[x2][y2];
        tableau[x2][y2] = temp;
    }
    
    /**
     * @return un tableau [i,j] si tableau[i][j]==0
     */
    public int[] trouverTrou() {
        
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
                if (tableau[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
    


    @Override
    public boolean equals(Object o){

        if ( this == o) return true;
        if ( o == null | getClass() != o.getClass()) return true;
        Taquin taquin = (Taquin) o ;
        return Arrays.deepEquals(tableau, taquin.tableau);
    }

    @Override
    public int hashCode(){
        return Arrays.deepHashCode(tableau);
    }

    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("+----------------+\n");
        for (int i = 0; i < tableau.length; i++) {
            sb.append("|");
            for (int j = 0; j < tableau[i].length; j++) {
                sb.append(String.format("%-3d", tableau[i][j]));
                if (j < tableau[i].length - 1) {
                    sb.append(" ");
                }
            }
            sb.append(" |\n");
        }
        sb.append("+----------------+\n");
        return sb.toString();
    }
}

