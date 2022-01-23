import java.io.Serializable;
import java.util.Random;

public class MOAB implements Abilities, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6048277389484590991L;

	@Override
	public void attack(HeistCharacter character, HeistCharacter enemy) {
		Random rand = new Random(System.currentTimeMillis());
		int chanceToHit = 75;

		if (rand.nextInt(100) + 1 <= chanceToHit) {
			int damage = rand.nextInt(65) + 65;
			System.out.println(character.getName() + " ducks behind cover and lobs the MOAB at " + enemy.getName()
					+ "'s feet, dealing" + damage + " damage!");
			enemy.subtractHitPoints(damage);
		} else {
			System.out.println(character.getName() + "'s MOAB failed to properly ignite, fizzles out before reaching the destination.");
		}
	}

}
