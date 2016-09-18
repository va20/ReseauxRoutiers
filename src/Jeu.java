import java.util.Scanner;

/**
 * Created by saif on 14/09/2016.
 */
public class Jeu {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choisissez le nombre de joueurs : ");
        int choix_joueur=sc.nextInt();
        while(choix_joueur < 2){
            System.out.println("NoooooP");
            System.out.println("Choisissez le nombre de joueurs : ");
            choix_joueur=sc.nextInt();
        }
        Plateau p=new Plateau(choix_joueur);
        p.affichage();
        while(true){
            for(int i=0;i<p.getTab_joueur().length;i++){
                System.out.println("A vous de jouer joueur n° : "+(i+1));
                System.out.println("Precisez la direction parmi les suivantes : " +
                        "NORD-SUD appuyez sur b et EST-OUEST appuyez sur g");
                String d=sc.next();
                Direction dir;
                System.out.print("Precisez les coordonnees i entre 1 et "+p.getTerrain().length+" : ");
                int k=sc.nextInt();
                System.out.print("Precisez les coordonnees j entre 1 et "+p.getTerrain().length+" : ");
                int h=sc.nextInt();
                if(p.getTerrain()[k-1][h-1].getRoute()!=null || p.getTerrain()[k-1][h-1].isVille()){
                    System.out.println("Rater, cette case est deja occupee. Vous avez ratez votre tour joueur n° "+(i+1)+" ;) ");
                    continue;
                }

                if(p.case_Adjacente(k-1,h-1,p.getTab_joueur()[i])){
                    System.out.println("impossible de relier cette case car il existe 2 case adjacente d'un autre joueur");
                    while(p.case_Adjacente(k-1,h-1,p.getTab_joueur()[i])){
                        System.out.print("Precisez les coordonnees i entre 1 et "+p.getTerrain().length+" : ");
                        k=sc.nextInt();
                        System.out.print("Precisez les coordonnees j entre 1 et "+p.getTerrain().length+" : ");
                        h=sc.nextInt();
                    }
                }
                if(p.coordonnees_Possible(k-1,h-1)) {
                    switch (d) {
                        case "b":
                            dir = Direction.NORD_SUD;
                            if (p.coordonnees_Possible(k,h-1)){

                                Route route_bas = new Route(dir, p.getTab_joueur()[i], k-1, h-1);
                                p.getTab_joueur()[i].ajouter_Route(route_bas);
                                p.getTerrain()[k-1][h-1].setRoute(route_bas);
                                //p.getTerrain()[k][h-1].setRoute(route_bas);
                                break;
                            }
                            else{
                                System.out.println("Impossible de relier ces 2 cases NORD-SUD!");
                                return;
                            }
                        /*case "h":
                            dir=Direction.SUD_NORD;
                            if (p.coordonnees_Possible(k-2,h-1)){
                                Route route_bas = new Route(dir, p.getTab_joueur()[i], k-1, h-1);
                                p.getTab_joueur()[i].ajouter_Route(route_bas);
                                p.getTerrain()[k-1][h-1].setRoute(route_bas);
                                p.getTerrain()[k-2][h-1].setRoute(route_bas);
                                break;
                            }
                            else{
                                System.out.println("Impossible de relier ces 2 cases SUD-NORD!");
                                return;
                            }
                        case "d":
                            dir = Direction.OUEST_EST;
                            if (p.coordonnees_Possible(k-1,h)) {
                                Route route_bas = new Route(dir, p.getTab_joueur()[i], k - 1, h - 1);
                                p.getTab_joueur()[i].ajouter_Route(route_bas);
                                p.getTerrain()[k - 1][h - 1].setRoute(route_bas);
                                p.getTerrain()[k - 1][h].setRoute(route_bas);
                                break;
                            }
                            else{
                                System.out.println("Impossible de relier ces 2 cases OUEST-EST!");
                                return;
                            }*/
                        case "g":
                            dir = Direction.EST_OUEST;
                            if (p.coordonnees_Possible(k-1,h-2)){
                                Route route_gauche = new Route(dir, p.getTab_joueur()[i], k-1, h-1);
                                p.getTab_joueur()[i].ajouter_Route(route_gauche);
                                p.getTerrain()[k-1][h-1].setRoute(route_gauche);
                                //p.getTerrain()[k-1][h-2].setRoute(route_gauche);
                                break;
                            }
                            else{
                                System.out.println("Impossible de relier ces 2 cases EST-OUEST!");
                                return;
                            }
                        default:
                            dir = null;
                            break;
                    }
                }
                else{
                    System.out.println("Coordonnees ne correspondent pas !");
                    return ;
                }
                p.affichage();
            }
        }

    }
}
