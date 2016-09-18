import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by saif on 15/09/2016.
 */
public class Joueur {

    private static int numero_joueur=0;
    private int id_joueur;
    private int i;
    private int j;
    private ArrayList liste_route;
    private ArrayList ensemble_depart;
    private ArrayList ensemble_arrive;


    public Joueur(){
        this.liste_route=new ArrayList();
        Joueur.numero_joueur++;
        this.id_joueur=Joueur.numero_joueur;
        this.ensemble_arrive=new ArrayList();
        this.ensemble_depart=new ArrayList();

    }
    public int getId_joueur() {
        return this.id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public ArrayList getListe_route() {
        return liste_route;
    }

    public void setListe_route(ArrayList liste_route) {
        this.liste_route = liste_route;
    }

    public void ajouter_Route(Route route){
        this.liste_route.add(route);
    }

    public ArrayList getEnsemble_depart() {
        return ensemble_depart;
    }

    public void setEnsemble_depart(ArrayList ensemble_depart) {
        this.ensemble_depart = ensemble_depart;
    }

    public ArrayList getEnsemble_arrive() {
        return ensemble_arrive;
    }

    public void setEnsemble_arrive(ArrayList ensemble_arrive) {
        this.ensemble_arrive = ensemble_arrive;
    }
}
