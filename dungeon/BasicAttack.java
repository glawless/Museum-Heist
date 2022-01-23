package dungeon;
import java.io.Serializable;
import java.util.*;

public class BasicAttack implements Abilities, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3306046344594884564L;
	private Random rand = new Random(System.currentTimeMillis());

	@Override
	public void attack(HeistCharacter character, HeistCharacter enemy) {
		boolean canAttack;
		int damage;

		canAttack = rand.nextInt(100) + 1 <= character.getChanceToHit();

		if (canAttack) {
			damage = (int) (Math.random() * (character.getDamageMax() - character.getDamageMin() + 1))
					+ character.getDamageMin();
			enemy.subtractHitPoints(damage);

			System.out.println();

		} else {

			System.out.println(character.getName() + "'s attack on " + enemy.getName() + " failed!");
			System.out.println();
		}

	}

}
