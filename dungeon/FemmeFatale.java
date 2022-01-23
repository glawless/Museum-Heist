package dungeon;
import java.io.Serializable;

public class FemmeFatale extends Robber implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7703492342535165442L;

	public FemmeFatale(String name, Abilities specialMove) {
		super(name, 90, 6, 75, 30, 65, 45, specialMove);
	}
	
	public void attack(HeistCharacter enemy) {
		System.out.println(this.getName() + " slashes her whip at " + enemy.getName());
		super.attack(enemy);
	}

}
