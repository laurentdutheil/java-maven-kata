package fr.octo.puissance4;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Arbitre {

    private final static int NB_JOUEURS = 2;
    public final static String JOUEUR_JAUNE = "JAUNE";
    public final static String JOUEUR_ROUGE = "ROUGE";

    private Grille grille;
    private Analyseur analyseur;
    private String[] joueurs = new String[NB_JOUEURS];
    private Map<String, String> joueurEnSymboleJeton = new HashMap<>(NB_JOUEURS);
    private int nombreDeCoup = 0;

    public Arbitre(Grille grille, Analyseur analyseur) {
        this.grille = grille;
        this.analyseur = analyseur;
        joueurs[0] = JOUEUR_JAUNE;
        joueurs[1] = JOUEUR_ROUGE;

        joueurEnSymboleJeton.put(joueurs[0], Grille.JOUEUR_1);
        joueurEnSymboleJeton.put(joueurs[1], Grille.JOUEUR_2);
    }

    public String obtenirJoueurEnCours() {
        return joueurs[nombreDeCoup % NB_JOUEURS];
    }

    public void jouer(int indexColonne) {
        if (grille.jouer(indexColonne, joueurEnSymboleJeton.get(obtenirJoueurEnCours()))) {
            ++nombreDeCoup;
        }
    }

    public EtatPartie obtenirEtatPartie() {
        if(analyseur.partieGagnee()) {
            return EtatPartie.GAGNEE;
        }
        if (analyseur.partieNulle()) {
            return EtatPartie.NULLE;
        }

        return EtatPartie.EN_COURS;
    }

    public Optional<String> obtenirVainqueur() {
        if (obtenirEtatPartie().equals(EtatPartie.GAGNEE)) {
            return Optional.of(joueurs[(nombreDeCoup - 1) % NB_JOUEURS]);
        }

        return Optional.empty();
    }
}
