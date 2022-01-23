package dungeon;
import java.io.Serializable;
import java.util.Random;

public class ArcOfTheCovenant implements Abilities, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8440372396291450830L;

	@Override
	public void attack(HeistCharacter character, HeistCharacter enemy) {
		Random rand = new Random(System.currentTimeMillis());
		int damage = 2;

		if (rand.nextInt(101) <= 3) {
			damage = 501;
			System.out.println(character.getName() + " unveils the Arc Of The Covenant and melts " + enemy.getName()
					+ "'s face off, dealing" + damage + " damage!");
			enemy.subtractHitPoints(damage);
		} else if (rand.nextInt(101) + 3 <= 50) {
			damage = 50;
			System.out.println(character.getName() + " unveils the Arc Of The Covenant but " + enemy.getName()
					+ " was able quickly shuts their eyes but was still partially blinded" + " dealing" + damage
					+ " damage!");

		} else {
			System.out.println(character.getName() + " fumbles his bag. Being unable to open his satchel.");
		}
	}

}