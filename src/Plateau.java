import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * Created by saif on 14/09/2016.
 */
public class Plateau{

    private Cellule[][] terrain;

    public Plateau(){

        this.terrain=new Cellule[15][15];

        for (int i=0;i<this.terrain.length;i++){
            for (int j=0;j<this.terrain.length;j++){
                this.terrain[i][j]=new Cellule();
            }
        }
        this.terrain[0][7].setVille(true);
        this.terrain[14][7].setVille(true);
        this.terrain[7][0].setVille(true);
        this.terrain[7][14].setVille(true);
    }

    public void affichage(){
        for (int i=0;i<this.terrain.length;i++){
            for(int j=0;j<this.terrain.length;j++){
                System.out.print("|");
                if(this.terrain[i][j].isVille()){
                    System.out.print("*");
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
            tiret+="-";
        }
        return tiret;
    }
}
