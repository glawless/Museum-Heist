package dungeon;
import java.io.Serializable;

public class Gunslinger extends Robber implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1627712380976819543L;

	public Gunslinger(String name, Abilities specialMove) {
		super(name, 125, 4, 80, 35, 60, 20, specialMove);		
	}
	
	public void attack(HeistCharacter enemy) {
		System.out.println(this.getName() + " slashes at "+ enemy.getName() + " with his hidden blade");
		super.attack(enemy);
	}
	
}
