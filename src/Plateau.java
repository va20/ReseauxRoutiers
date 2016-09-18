import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by saif on 14/09/2016.
 */
public class Plateau{

    private Cellule[][] terrain;
    private Joueur[] tab_joueur;

    public Plateau(int nb_joueur){

        this.terrain=new Cellule[15][15];
        this.tab_joueur=new Joueur[nb_joueur];
        for(int k=0;k<nb_joueur;k++){
            tab_joueur[k]=new Joueur();
        }
        for (int i=0;i<this.terrain.length;i++){
            for (int j=0;j<this.terrain.length;j++){
                this.terrain[i][j]=new Cellule(i,j);
                if(nb_joueur==2){
                    if(i==0){
                        this.terrain[i][j].setVille(true);
                        this.tab_joueur[0].getEnsemble_depart().add(this.terrain[i][j]);
                    }
                    if(j==0){
                        this.terrain[i][j].setVille(true);
                        this.tab_joueur[1].getEnsemble_arrive().add(this.terrain[i][j]);
                    }
                    if(i==this.terrain.length-1){
                        this.terrain[i][j].setVille(true);
                        this.tab_joueur[0].getEnsemble_arrive().add(this.terrain[i][j]);
                    }
                    if(j==this.terrain[i].length-1){
                        this.terrain[i][j].setVille(true);
                        this.tab_joueur[1].getEnsemble_depart().add(this.terrain[i][j]);
                    }
                }
            }
        }

    }



    public Cellule[][] getTerrain() {
        return terrain;
    }

    public void setTerrain(Cellule[][] terrain) {
        this.terrain = terrain;
    }

    public void affichage(){
        for (int i=0;i<this.terrain.length;i++){
            System.out.println(Line());
            for(int j=0;j<this.terrain.length;j++){
                System.out.print("|");
                if(this.terrain[i][j].isVille()){
                    System.out.print("*");
                }
                else if(this.terrain[i][j].getRoute()!=null && !this.terrain[i][j].isVille()){
                    System.out.print(this.terrain[i][j].getRoute().getDirection().toString());
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }
    public String Line(){
        String tiret="";
        for (int i=0;i<this.terrain.length;i++){
            tiret+="--";
        }
        tiret+="-";
        return tiret;
    }


    /*public void Mettre_route(int i,int j,String d){
        if(this.terrain[i][j].getDirection().equals("")){
            this.terrain[i][j].setDirection(d);
        }
        System.out.println("il existe une route sur cette case");
    }*/


    public boolean isPossible_direction(int i,int j,String d){
        if(i==0){
            if(j==0){
                return d.equals("h") && d.equals("g");
            }
            else if(j==this.terrain[0].length-1){
                return d.equals("h") && d.equals("d");
            }
            else{
                return d.equals("h");
            }
        }
        else if(i==this.terrain.length-1){
            if(j==0){
                return d.equals("b") && d.equals("g");
            }
            else if(j==this.terrain[0].length-1){
                return d.equals("b") && d.equals("d");
            }
            else{
                return d.equals("b");
            }
        }
        else{
            if(j==0){
                return d.equals("g");
            }
            else if(j==this.terrain[0].length-1) {
                return d.equals("d");
            }
        }
        return true;
    }

    public ArrayList Voisin_nonMarque(Cellule cellule,Joueur joueur){
        ArrayList voisin=new ArrayList();
        if(cellule.getI()-1>=1){
            if (this.terrain[cellule.getI() - 1][cellule.getJ()].getRoute() != null &&
                    joueur.getListe_route().contains(this.terrain[cellule.getI() - 1][cellule.getI()].getRoute())) {
                if(!this.terrain[cellule.getI() - 1][cellule.getJ()].isCellule_marque()){
                    voisin.add(this.terrain[cellule.getI() - 1][cellule.getJ()]);
                }
            }
        }
        if(cellule.getI()+1<this.terrain.length-1) {
            if (this.terrain[cellule.getI() + 1][cellule.getJ()].getRoute() != null &&
                    joueur.getListe_route().contains(this.terrain[cellule.getI() + 1][cellule.getI()].getRoute())) {
                if (!this.terrain[cellule.getI() + 1][cellule.getJ()].isCellule_marque()) {
                    voisin.add(this.terrain[cellule.getI() + 1][cellule.getJ()]);
                }
            }
        }
        if(cellule.getJ()-1>=1) {
            if (this.terrain[cellule.getI() ][cellule.getJ()-1].getRoute() != null &&
                    joueur.getListe_route().contains(this.terrain[cellule.getI()][cellule.getI()-1].getRoute())) {
                if (!this.terrain[cellule.getI()][cellule.getJ()-1].isCellule_marque()) {
                    voisin.add(this.terrain[cellule.getI()][cellule.getJ()-1]);
                }
            }
        }
        if(cellule.getJ()-1<this.terrain.length-1) {
            if (this.terrain[cellule.getI()][cellule.getJ()+1].getRoute() != null &&
                    joueur.getListe_route().contains(this.terrain[cellule.getI()][cellule.getI()+1].getRoute())) {
                if (!this.terrain[cellule.getI()][cellule.getJ()+1].isCellule_marque()) {
                    voisin.add(this.terrain[cellule.getI()][cellule.getJ()+1]);
                }
            }
        }
        return voisin;
    }

    public boolean fin_partie(Joueur joueur){
        if(joueur.getId_joueur()==1){
            int i=0;
            while(!joueur.getEnsemble_depart().isEmpty()){
                Cellule tmp= (Cellule) joueur.getEnsemble_depart().remove(i);
                tmp.setCellule_marque(true);
                ArrayList v=Voisin_nonMarque(tmp,joueur);
                for(int j=0;j<v.size();j++){
                    if(joueur.getEnsemble_arrive().contains(v.get(j))){
                        System.out.println("Victoire de joueur n° : "+joueur.getId_joueur());
                        return true;
                    }
                    joueur.getEnsemble_depart().add(j);
                }
            }
        }
        return false;
    }

    public boolean coordonnees_Possible(int i,int j){
        if((i-1)<0 || (i+1)>this.terrain.length || (j-1)<0 || (j+1)>this.terrain[0].length){
            return false;
        }
        return true;
    }
    public boolean case_Adjacente(int i,int j,Joueur joueur){
        int cmpt=0;
        if(coordonnees_Possible(i,j)){
            if(i-1>=1) {
                if (this.terrain[i - 1][j].getRoute() != null && joueur.getListe_route().contains(this.terrain[i - 1][j].getRoute())) {
                    cmpt++;
                }
            }
            if(i+1<this.terrain.length-1) {
                if (this.terrain[i + 1][j].getRoute() != null && joueur.getListe_route().contains(this.terrain[i + 1][j].getRoute())) {
                    cmpt++;
                }
            }
            if(j+1<this.terrain[i].length-1) {
                if (this.terrain[i][j + 1].getRoute() != null && joueur.getListe_route().contains(this.terrain[i][j + 1].getRoute())) {
                    cmpt++;
                }
            }
            if(j-1>=1) {
                if (this.terrain[i][j - 1].getRoute() != null && joueur.getListe_route().contains(this.terrain[i][j - 1].getRoute())) {
                    cmpt++;
                }
            }
        }
        if(cmpt>=2){
            return true;
        }
        return false;
    }

    public Joueur[] getTab_joueur() {
        return tab_joueur;
    }

    public void setTab_joueur(Joueur[] tab_joueur) {
        this.tab_joueur = tab_joueur;
    }
}
