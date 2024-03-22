package fr.umontpellier.iut.partie2;

public class AppJeuxPuzzle {
    public static void main(String[] args) {
        int[][] tableau = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        JeuPuzzle<Taquin> jeuPuzzle = new Taquin(tableau);
        Contexte contexte = new Contexte(jeuPuzzle);
        contexte.resoudre();
        System.out.println(contexte.getSolution());
    }
}