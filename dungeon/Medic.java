import java.io.Serializable;

public class Medic extends Robber implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2059334816021294728L;

	public Medic(String name, Abilities specialMove) {
		super(name, 160, 3, 60, 25, 60, 40, specialMove);
	}
	
	public void attack(HeistCharacter enemy) {
		System.out.println(this.getName() + " lines up her syringe gun at " + enemy.getName());
		super.attack(enemy);
	}

}
