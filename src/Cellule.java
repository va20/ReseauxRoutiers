/**
 * Created by saif on 14/09/2016.
 */
public class Cellule {

    private boolean ville;
    private Route route;
    private boolean cellule_marque;
    private int i;
    private int j;

    public Cellule(int i,int j){
        this.ville=false;
        this.cellule_marque=false;
        this.route=null;
        this.i=i;
        this.j=j;
    }

    public Cellule(boolean ville,int i, int j){
        this.ville=ville;
        this.cellule_marque=false;
        this.i=i;
        this.j=j;
        this.route=null;
    }


    public boolean isCellule_marque() {
        return cellule_marque;
    }

    public void setCellule_marque(boolean cellule_marque) {
        this.cellule_marque = cellule_marque;
    }

    public boolean isVille() {

        return ville;
    }

    public void setVille(boolean ville) {

        this.ville = ville;

    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route direction) {
        this.route = direction;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setI(int i) {
        this.i = i;
    }
}
