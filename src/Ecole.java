import Etudiants.Etudiant;
import Etudiants.Etudiant3eme;
import Etudiants.EtudiantAlternance;
import EtudiantsExecptions.EtudiantExisteException;

import java.util.Arrays;

public class Ecole {
    private String nom;
    public static  int maxEtudiant = 500;
    private  int conteur = 0;
    private Etudiant [] tabEtudiant=new Etudiant[maxEtudiant];
    public Ecole(String nom) {
        this.nom = nom;
    }
    public void ajouterEtudiant(Etudiant e)    throws EtudiantExisteException
    {
        if(conteur<maxEtudiant) {
    int et =rechercher_Etudiant(e);
            if(et != -1) {
                tabEtudiant[conteur] = e;
                conteur++;
                System.out.println("Etudiant ajouté");
            }else{
                System.out.println("l'etudiant  existe déjà");
                throw new EtudiantExisteException("ce object  existe déja");
            }
          }
        else{
            System.out.println("Ecole pleine");
        }
    }



    public int rechercher_Etudiant(Etudiant e)
    {
        for (int i=0;i<maxEtudiant;i++)
        {
            if(tabEtudiant[i].equals(e))
                return i;
        }
        return -1;
    }


        public float getMoyenneDes3A(){
        float x=0.f;
        int c=0;
            for (int i=0;i<maxEtudiant;i++)
            {
                if(tabEtudiant[i] instanceof Etudiant3eme){
                    c++;
                    x += tabEtudiant[i].getMoyenne();
                }

            }
            return x/c;

        }

  public float  moyenneSalaireAlternants(){
        float x=0.f;
        int c=0;
        for (int i=0;i<maxEtudiant;i++)
        {
            if(tabEtudiant[i] instanceof EtudiantAlternance){
                c++;
                x += ((EtudiantAlternance) tabEtudiant[i]).getSalaire()  ;
            }

        }
        return x/c;


    }


    public String toString() {
        return "Ecole{" +
                "nom='" + nom + '\'' +
                ", nbre=" + conteur +
                ", tabEtudiant=" + Arrays.toString(tabEtudiant) +
                '}';
    }
    public void changerEcole(Etudiant etd, Ecole e){
        try {
        Etudiant etudiant = tabEtudiant[rechercher_Etudiant(etd)  ]; // for error catch
            supprimer(etd);
            e.ajouterEtudiant(etudiant);

        } catch (ArrayIndexOutOfBoundsException | EtudiantExisteException a) {
            System.out.println("Error: there is no one in the ecole " + a.getMessage());
        }

    }

    public boolean supprimer(Etudiant p)  throws EtudiantExisteException
    {
        boolean test=false;
        int indice=rechercher_Etudiant(p);

        if (indice==-1){
            test=false;
            throw new EtudiantExisteException("ce object n existe pas");
        }
        else {

            for (int i=indice;i<conteur-1;i++)
            {
                tabEtudiant[i]=tabEtudiant[i+1];
                tabEtudiant[i]=null;
            }
            conteur--;
            test=true;
        }
        return test;
    }
}
