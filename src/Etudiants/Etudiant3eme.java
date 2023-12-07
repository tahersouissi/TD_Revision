package Etudiants;

public class Etudiant3eme  extends Etudiant{
    private String branche;

    public Etudiant3eme(int identifiant, String nom, String prenom, float moyenne, String branche) {
        super(identifiant, nom, prenom, moyenne);
        this.branche = branche;
    }

    @Override
    public void ajouterUneAbsence() {
        super.moyenne -= 0.5;
    }
}
