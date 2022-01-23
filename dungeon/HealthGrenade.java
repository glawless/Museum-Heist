import java.io.Serializable;
import java.util.Random;

public class HealthGrenade implements Abilities, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -128638398205022761L;

	@Override
	public void attack(HeistCharacter character, HeistCharacter enemy) {
		Random rand = new Random(System.currentTimeMillis());
		
		int chanceToHit = 80;
	
		if (rand.nextInt(100)+1 <= chanceToHit)
		{
			int healthPoints = rand.nextInt(21) + 55;
			character.addHitPoints(healthPoints);
			System.out.println(character.getName() + " tosses a healing grenade at their feet healing them "
					+ "for " + healthPoints + " bringing the their HP to " + character.getHitPoints());
		}
		else
		{
			System.out.println(character.getName() + " fumbles the health grenade and rolls away into a corner.");
			System.out.println();
		}
	}

}
