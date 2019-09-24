package bowling;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
        Vector<Integer> score;
        int quillesRestantes=10;
        int boulesRestantes=2;
        int indice=-1;
        boolean sp=false;
        boolean st=false;
    
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            score=new Vector<Integer>();
            
            
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            indice+=1;
            quillesRestantes-=nombreDeQuillesAbattues;
            
            if(sp==true){
                spare(nombreDeQuillesAbattues);
                //score.add(nombreDeQuillesAbattues);
            }
            
            if(st==true){
                
            }
            if(nombreDeQuillesAbattues==10 && boulesRestantes==1){
                sp=true;
                score.add(nombreDeQuillesAbattues);
                boulesRestantes=2;
            }
            
            else{
                boulesRestantes-=1;
                score.add(nombreDeQuillesAbattues);
                if(boulesRestantes==0){
                    boulesRestantes=2;
                }
            }
	}

        public void spare(int x){
            int sc = score.get(indice-1)+x;
            score.set(indice-1, sc);
            //System.out.println(score);
            //score.add(x);
            sp=false;
        }
        
        
	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            try{
                int s=0 ;
                for(int i=0;i<score.size();i++){
                    s+=score.get(i);
                }
                return s;
            }catch(Exception e){
                throw new UnsupportedOperationException("Pas encore implémenté");
            }
        }
}
