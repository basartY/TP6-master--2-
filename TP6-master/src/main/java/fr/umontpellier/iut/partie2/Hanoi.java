package fr.umontpellier.iut.partie2;

import java.util.ArrayList;

public class Hanoi implements JeuPuzzle<Hanoi> {

    private int taille;
    private ArrayList<Integer> tour1;
    private ArrayList<Integer> tour2;
    private ArrayList<Integer> tour3;

    public Hanoi(int taille) {
        /* crée un hanoi avec la configuration suivante :
                * sur la tour 1 les disques [taille,taille-1, .., 1]
                * rien sur les tour 2 et 3 (elles sont vides)
         */
        this.taille = taille;
        this.tour1 = new ArrayList<>();
        this.tour2 = new ArrayList<>();
        this.tour3 = new ArrayList<>();
    }


    public Hanoi(ArrayList<Integer> tour1, ArrayList<Integer> tour2, ArrayList<Integer> tour3, int taille) {
        /*
        Crée un hanoi où la tour 1 (resp. tour 2 et tour 3) contient les entiers de tour1 (resp. tour2 et tour3). Par exemple,
        si tour1 est une ArrayList contenant [3,2,1], et tour2 et tour3 sont des ArrayList vides, alors
        Hanoi(tour1, tour2, tour3) doit créer la même configuration que Hanoi(3).
         */
        this.tour1 = new ArrayList<>(tour1);
        this.tour2 = new ArrayList<>(tour2);
        this.tour3 = new ArrayList<>(tour3);

        for ( int i = 0 ; i < tour1.size() ; i++){
            this.tour1.add(this.tour1.get(i));
        }
        for ( int i = 0 ; i < tour2.size() ; i++){
            this.tour2.add(this.tour2.get(i));
        }
        for ( int i = 0 ; i < tour3.size() ; i++){
            this.tour3.add(this.tour3.get(i));
        }
    }

    public ArrayList<Hanoi> genererFils() {
           ArrayList<Hanoi> listeFils = new ArrayList<>();
           ArrayList<Integer> newTour1, newTour2, newTour3;

           // Déplacements possibles à partir de tour 1
           if (!tour1.isEmpty()) {
               if (tour2.isEmpty()) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour2.add(newTour1.remove(newTour1.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
               else if (tour1.get(tour1.size() - 1) < tour2.get(tour2.size() - 1)) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour2.add(newTour1.remove(newTour1.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }

               if (tour3.isEmpty()) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour3.add(newTour1.remove(newTour1.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
               else if (tour1.get(tour1.size() - 1) < tour3.get(tour3.size() - 1)) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour3.add(newTour1.remove(newTour1.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
           }

           // Déplacements possibles à partir de tour 2
           if (!tour2.isEmpty()) {
               if (tour1.isEmpty()) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour1.add(newTour2.remove(newTour2.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
               else if (tour2.get(tour2.size() - 1) < tour1.get(tour1.size() - 1)) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour1.add(newTour2.remove(newTour2.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
               if(tour3.isEmpty()) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour3.add(newTour2.remove(newTour2.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
               else if (tour2.get(tour2.size() - 1) < tour3.get(tour3.size() - 1)) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour3.add(newTour2.remove(newTour2.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
           }


           // Déplacements possibles à partir de tour 3
           if (!tour3.isEmpty()) {
               if (tour1.isEmpty()) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour1.add(newTour3.remove(newTour3.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
               else if (tour3.get(tour3.size() - 1) < tour1.get(tour1.size() - 1)) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour1.add(newTour3.remove(newTour3.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
               if (tour2.isEmpty()) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour2.add(newTour3.remove(newTour3.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
               else if (tour3.get(tour3.size() - 1) < tour2.get(tour2.size() - 1)) {
                   newTour1 = new ArrayList<>(tour1);
                   newTour2 = new ArrayList<>(tour2);
                   newTour3 = new ArrayList<>(tour3);
                   newTour2.add(newTour3.remove(newTour3.size() - 1));
                   listeFils.add(new Hanoi(newTour1, newTour2, newTour3, taille));
               }
           }
           return listeFils;
       }

       @Override
       public boolean estGagnant() {
           // Implémenter la logique de vérification de la condition de victoire pour le jeu des tours de Hanoi
           return false;
       }
   }

