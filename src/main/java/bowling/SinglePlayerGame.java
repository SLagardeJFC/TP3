package bowling;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
        int t;
        int score;
        int quilles;
        boolean sec;
        int compteDouble;
        int cpt;
    
        final Integer MAX = 300;
        
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            this.t=10;
            this.score=0;
            this.quilles=10;
            this.sec=false;
            this.compteDouble=0;
            this.cpt=0;
            
            
	}

        public void spare(){
            sec=false;
            if(t==1){
                t++;
                sec=true;
            }
            else{
                cpt=1;
                }
        }

        public void strike(){
            if(t==1){
                t++;
            }
            else{
                cpt=2;
            }
        }
        
	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            //int cpt=0;
            quilles-=nombreDeQuillesAbattues;
            
            if(quilles==0){
                if(sec){
                    //On a 0 boules restantes  et le booléen sec est vrai donc on a tombé toutes les quilles
                    //spare
                    spare();
                }else{
                    //strike
                    strike();
                }
            }else{
                sec=!sec;
            }
            
            if(compteDouble!=0){
                if(compteDouble>=3 && cpt==2){
                    score+=nombreDeQuillesAbattues*3;
                }else{
                    score+=nombreDeQuillesAbattues*2;
                }
                compteDouble--;
            }else{
                score+=nombreDeQuillesAbattues;
            }
            compteDouble+=cpt;
            if(sec==false){
                t--;
                quilles=10;
            }
            cpt=0;
        }
	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            try{
                return score;
            }catch(Exception e){
                throw new UnsupportedOperationException("Pas encore implémenté");
            }
        }
}
