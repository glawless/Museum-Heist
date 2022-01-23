package dungeon;

import java.io.Serializable;
import java.util.Random;

public class CinnamonTwistARang implements Abilities, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4023458924686149126L;

	@Override
	public void attack(HeistCharacter character, HeistCharacter enemy) {
		Random rand = new Random(System.currentTimeMillis());
		int chanceToHit = 55;

		if (rand.nextInt(100) + 1 <= chanceToHit) {
			int damage = rand.nextInt(65) + 35;
			System.out.println(character.getName() + " throws his Cinnamon Twist-A-Rang at " + enemy.getName()
					+ " dealing" + damage + " damage!");
			enemy.subtractHitPoints(damage);
		} else {
			System.out.println(character.getName()
					+ " throws his Cinnamon Twist-A-Rang in a too wide of an arc missing completely.");
		}
	}

}