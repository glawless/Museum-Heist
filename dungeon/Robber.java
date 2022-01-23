package dungeon;

import java.io.Serializable;
import java.util.*;
public class Robber extends HeistCharacter implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8170282039793280624L;
	private double chanceToDodge;
	private int numTurns;
	private int pillarCount = 0;
	private int medKit = 0;
	private int logicBomb =  0;
	private Abilities specialMove;
	
	
	public Robber (String name, int hitPoints, int attackSpeed, 
	double chanceToHit, int damageMin, int damageMax, 
	double chanceToDodge, Abilities specialMove) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, new BasicAttack());
		this.chanceToDodge = chanceToDodge;
		this.specialMove = specialMove;
	}

	public int getNumTurns() {
		return numTurns;
	}

	public void setNumTurns(int numTurns) {
		this.numTurns = numTurns;
	}
	public int getPillarCount() {
		return this.pillarCount;
	}

	public int getMedKit() {
		return this.medKit;
	}
	
	public void decreaseMedKit() {
		this.medKit--;
	}
	
	public void addMedKit() {
		this.medKit++;
	}
	
	public void addPillars(){
		this.pillarCount++;
	}
	
	public boolean maxPillars(){
		return this.pillarCount == 4;
	}
	
	public boolean dodge() {
		Random rand = new Random(System.currentTimeMillis());
		int dodge = rand.nextInt(100)+1;
		return dodge <= this.chanceToDodge;
	}
	
	public void SpecialAttack(HeistCharacter enemy) {
		specialMove.attack(this, enemy);
	}
	
	public void subtractHitPoints(int damage) {
		
		if(dodge()) {
			System.out.println(this.getName() + " managed to dodge the attack");
		}else {
			super.subtractHitPoints(damage);
		}
	}

}
