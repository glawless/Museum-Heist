package dungeon;
import java.io.Serializable;
import java.util.Random;

public class Pyrotechnics implements Abilities, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6814445556127808814L;

	@Override
	public void attack(HeistCharacter character, HeistCharacter enemy) {
		Random rand = new Random(System.currentTimeMillis());
		int chanceToHit = 40;
		
		if (rand.nextInt(100)+1 <= chanceToHit)
		{
			int damage = rand.nextInt(35) + 45;
			System.out.println(character.getName() + " lights up fireworks at " + enemy.getName()+ " burning them for " + damage
								+ " damage!");
			enemy.subtractHitPoints(damage);
		}
		else
		{
			System.out.println(character.getName() + " pyrotechnics shoot too erratically failing to hit " + enemy.getName());
			System.out.println();
		}
	}

}