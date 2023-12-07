package Etudiants;

public abstract class Etudiant {
    protected int identifiant;
    protected String nom;
    protected String prenom;
    protected float moyenne ;

    public Etudiant(int identifiant, String nom, String prenom, float moyenne) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }


    public String toString() {
        return "Etidant \n" + " id: " + identifiant +"  nom : "+nom + "prenom : "+prenom  + "  moyenne" + moyenne;
    }


    public boolean equals(Etudiant e) {

        return e.identifiant==identifiant && e.nom.equals(nom);
    }
     public abstract void ajouterUneAbsence();

    public float getMoyenne() {
        return moyenne;
    }
}
