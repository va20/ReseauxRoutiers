/**
 * Created by saif on 15/09/2016.
 */
public class Route {
    private Joueur joueur;
    private Direction direction;
    private int i;
    private int j;

    public Route(Direction d,Joueur joueur,int i,int j) {
        this.direction=d;
        this.joueur=joueur;
        this.i=i;
        this.j=j;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
