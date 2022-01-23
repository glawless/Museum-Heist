package dungeon;
import java.io.Serializable;

public class Archrival extends LawMan implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7377412715121473956L;

	public Archrival(Abilities specialMove) {
		super("Indiana Jones your archrival", 500, 5, 75, 65, 35, 65, 80, 500, specialMove);
	}
	
	public void attack(HeistCharacter opponent) {
		System.out.println(getName() + " cracks his whip at " + opponent.getName() + ":");
		super.attack(opponent);

	}
	
	public void heal() {
		System.out.println(this.getName() + " uses a trauma kit healing for: ");
		super.heal();
	}
}