package fr.umontpellier.iut.partie1;

import java.util.ArrayList;

public class Couple {

    private final Taquin taquin;
    private Couple predecesseur;

    public Couple(Taquin taquin, Couple predecesseur) {
        this.taquin = taquin;
        this.predecesseur = predecesseur;
    }

    /**
     * Vérifie si les fils du taquin sont déjà vus et met à jour la frontière
     * et l'ensemble des configurations déjà vues.
     */ 
    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<Taquin> dejaVus) {    // CHECK

        if (!taquin.estGagnant()) {                                // Taquin pas Gagnant
            ArrayList<Taquin> list = taquin.genererFils();         // Génére une list de fils du Taquin
            for (Taquin taquin : list) {                           // Parcours cette liste
                if (!dejaVus.contains(taquin)) {                   // Si la liste dejaVus ne contiens pas ce Taquin
                dejaVus.add(taquin);                               // Ajoute ce taquin a la liste
                frontiere.add(new Couple(taquin, this));           // Ajoute à la frontière le couple Taquin avec ca référence d'objet.
                }
            }
        }
    
    }
    /**
     * @return la liste des taquins intermédiaires à partir du taquin initial
     * et jusqu'au taquin courant
     */
    public ArrayList<Taquin> getListeDeMouvements() {
        
        ArrayList<Taquin> list = new ArrayList<>();
        Couple c = this;

        while ( c != null) {
            list.add(0 , c.getTaquin());
            c = c.predecesseur;
        }
        return list;
    }

    public Taquin getTaquin() {
        return taquin;
    }
}
