import java.util.Random;

/**
 * 
 */

/**
 * @author gayk_t
 *
 */
public class Player {

	/**
	 * 
	 */
	public Player() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean result = false;
		int counter=0;
		int counter2 =0;
		
		Game game = new Game();
		
		Random r = new Random();
		
		int gespielt = r.nextInt(3);
		
		for (int i = 0; i < 1000; i++) {
			 result =game.playTheGame(gespielt, false,false);
			 if(result){
				 
				 counter ++;
			 }
			
		}
		for (int i = 0; i < 1000; i++) {
			 result =game.playTheGame(gespielt, true,true);
			 if(result){
				 
				 counter2 ++;
			 }
			
		}
		
		 
		
		
		System.out.println("Das Ergebniss für einmal "+counter+" mal gewonnen. Das Ergebniss für ZONK = "+counter2 +"mal gewonnen");
		
		
		
		

	}

}
