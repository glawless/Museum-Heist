package dungeon;
import java.io.Serializable;
import java.util.Random;

public class FlashLight implements Abilities, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7589689128441151529L;

	@Override
	public void attack(HeistCharacter character, HeistCharacter enemy) {
		Random rand = new Random(System.currentTimeMillis());

		if (rand.nextInt(100) + 1 <= 45) {
			System.out.println(character.getName() + " blinded " + enemy.getName() + " with his flashlight."
					+ character.getName() + " get's another turn.");
			((LawMan) character).setNumTurns(((LawMan) character).getNumTurns() + 1);
			character.attack(enemy);
		} else {
			System.out.println(character.getName() + " failed to blind " + enemy.getName());

		}
	}
}