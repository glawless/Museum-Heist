package dungeon;

public class LawManFactory {
	
	private static LawMan theLaw;
	
	public static LawMan lawFactory(int lawChoice) {
		
		if(lawChoice == 1){
			theLaw = new DonutSlinger(AbilitiesPool.abililtyFactory("DonutSlinger"));
		}else if(lawChoice == 2) {
			theLaw = new GuardDog(AbilitiesPool.abililtyFactory("GuardDog"));
		}else if(lawChoice == 3) {
			theLaw = new Swat(AbilitiesPool.abililtyFactory("Swat"));
		}else if(lawChoice == 4) {
			theLaw = new Archrival(AbilitiesPool.abililtyFactory("Archrival"));
		}else if(lawChoice == 5) {
			theLaw = new MuseumSecurity(AbilitiesPool.abililtyFactory("MuseumSecurity"));
		}
		
		return theLaw;
	}

}
