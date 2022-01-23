import java.io.Serializable;

public class MuseumSecurity extends LawMan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5812441185658254879L;

	public MuseumSecurity(Abilities specialMove) {
		super("Paul",  100, 3, 80, 30, 40, 50, 30, 50, specialMove);
	}
	
	public void attack(HeistCharacter opponent) {
		System.out.println(getName() + " revs up his segway and runs " + opponent.getName()
			+ "over.");
		super.attack(opponent);
	}
	
	public void heal() {
		System.out.println(this.getName() + "swaps out his batteries healing for: ");
		super.heal();
	}
}
