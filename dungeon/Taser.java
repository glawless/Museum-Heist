package dungeon;
import java.io.Serializable;
import java.util.Random;

public class Taser implements Abilities, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4172746139405253853L;

	@Override
	public void attack(HeistCharacter character, HeistCharacter enemy) {
		Random rand = new Random(System.currentTimeMillis());
		int chanceToHit = 45;

		if (rand.nextInt(100) + 1 <= chanceToHit) {
			int damage = rand.nextInt(101);
			System.out.println(
					character.getName() + " closes in and tases " + enemy.getName() + " dealing" + damage + " damage!");
			enemy.subtractHitPoints(damage);
		} else {
			System.out.println(character.getName() + " oversteps and misses their attack.");
		}
	}

}