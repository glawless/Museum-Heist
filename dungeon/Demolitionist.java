package dungeon;
import java.io.Serializable;

public class Demolitionist extends Robber implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6048665046111822497L;

	public Demolitionist(String name, Abilities specialMove) {
		super(name, 100, 4, 85, 40, 65, 30, specialMove);
	}

	public void attack(HeistCharacter enemy) {
		System.out.println(this.getName() + " lobs dynamite at " + enemy.getName());
		super.attack(enemy);
	}
}
