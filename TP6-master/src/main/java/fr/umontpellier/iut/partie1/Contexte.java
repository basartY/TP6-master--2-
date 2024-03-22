package fr.umontpellier.iut.partie1;

import java.util.ArrayList;

public class Contexte {

    private final Taquin taquinInitial;
    private ArrayList<Taquin> solution;

    public Contexte(Taquin taquinInitial) {
        this.taquinInitial = taquinInitial;
        solution = new ArrayList<>();
    }

    public void resoudre() {

        ArrayList<Couple> frontiere = new ArrayList<>();
        
        ArrayList<Taquin> dejaVus = new ArrayList<>();

        frontiere.add(new Couple(taquinInitial, null));            // Ajout Taquin initial à la frontière

        while (!frontiere.isEmpty()) {
            Couple couple = frontiere.remove(0);                   // Retirer le premier élément de la frontière
            Taquin taquin = couple.getTaquin();

            if (taquin.estGagnant()) {

                solution = couple.getListeDeMouvements();                       // Récupére la liste des mouvements pour obtenir la solution
                return;                                                         // Lorsque une solution est trouvée sort des deux boucles                      
            }
            couple.mettreAJour(frontiere, dejaVus);                             // Frontière et dejaVus à jour
        }
        solution = new ArrayList<>();                                           // Si aucune solution trouvée alors liste vide
    }

    public ArrayList<Taquin> getSolution() {
        return solution;
    }
}
