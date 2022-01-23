package dungeon;

import java.io.Serializable;
import java.util.*;
public class LawMan extends HeistCharacter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7676343455353331043L;
	private int numTurns;
	private int chanceToHeal;
	private int maxHeal;
	private int minHeal;
	private Abilities specialMove;
	
	
	public LawMan(String name, int hitPoints, int attackSpeed, int chanceToHit, int chanceToHeal, int damageMin,
			int damageMax, int minHeal, int maxHeal, Abilities specialMove) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, new BasicAttack());
		
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
		this.specialMove = specialMove;

	}

	public int getNumTurns() {
		return numTurns;
	}

	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}

	public void SpecialAttack(HeistCharacter enemy) {
		this.specialMove.attack(this, enemy);
	}
	
	public void subtractHitPoints(int damage) {
		super.subtractHitPoints(damage);
	}

	public void heal() {
		boolean canHeal;
		int healPoints;
		Random rand = new Random(System.currentTimeMillis());

		canHeal = (rand.nextInt(100)+1 <= chanceToHeal) && (getHitPoints() > 0);

		if (canHeal) {
			healPoints = (int) (rand.nextInt(100)+1 * (maxHeal - minHeal + 1)) + minHeal;
			addHitPoints(healPoints);
			System.out.println(getName() + " healed themselves for " + healPoints + " points.\n"
					+ "Total hit points remaining are: " + getHitPoints());
			System.out.println();
		}

	}
}

