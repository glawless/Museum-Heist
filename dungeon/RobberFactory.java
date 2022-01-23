
public class RobberFactory {
	
	private static Robber theRobber;
	
	public static Robber robberFactory(int robberChoice, String name) {
		
		if(robberChoice == 1) {
			theRobber = new Gunslinger(name, AbilitiesPool.abililtyFactory("Gunslinger"));
		}else if(robberChoice == 2) {
			theRobber = new FemmeFatale(name, AbilitiesPool.abililtyFactory("FemmeFatale"));
		}else if(robberChoice == 3) {
			theRobber = new Medic(name, AbilitiesPool.abililtyFactory("Medic"));
		}else if(robberChoice == 4) {
			theRobber = new Demolitionist(name, AbilitiesPool.abililtyFactory("Demolitionist"));
		}else if(robberChoice == 5) {
			theRobber = new Pyromaniac(name, AbilitiesPool.abililtyFactory("Pyromaniac"));
		}else if(robberChoice == 1945) {
			theRobber = new BigBoomer(name, AbilitiesPool.abililtyFactory("BigBoomer"));
		}
		return theRobber;
	}

}
