import java.io.Serializable;

public class BigBoomer extends Robber implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5369714399877074745L;

	public BigBoomer(String name, Abilities specialMove) {
		super(name, 1000, 1, 100, 500, 999, 99, specialMove);
	}

	public void attack(HeistCharacter enemy) {
		System.out.println(this.getName() + " OK boomer'd " + enemy.getName() + "it was super effective.");
		super.attack(enemy);
	}
}