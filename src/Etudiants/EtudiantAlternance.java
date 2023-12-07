package Etudiants;

public class EtudiantAlternance extends Etudiant{
    private int salaire;

    public EtudiantAlternance(int identifiant, String nom, String prenom, float moyenne , int salaire) {
        super(identifiant, nom, prenom, moyenne);
        this.salaire = salaire;
    }

    @Override
    public void ajouterUneAbsence() {
    salaire -= 50;
    }


    public String toString() {
        return super.toString() + "\n" + "salaire : "+salaire;
    }

    public int getSalaire() {
        return salaire;
    }
}
