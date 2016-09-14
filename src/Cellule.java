/**
 * Created by saif on 14/09/2016.
 */
public class Cellule {

    private boolean ville;

    public Cellule(){
        this.ville=false;
    }

    public Cellule(boolean ville){
        this.ville=ville;
    }

    public boolean isVille() {
        return ville;
    }

    public void setVille(boolean ville) {
        this.ville = ville;
    }

}
