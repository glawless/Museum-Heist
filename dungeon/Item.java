package dungeon;
import java.io.Serializable;
import java.util.Random;

public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3660593805040474169L;
	private String type;
	private String description;
	
	public Item(String type, String description) {
		this.type = type;
		this.description = description;
	}
	
	public void useMedKit(Robber robber, Item item) {
		if(item.type.equals("medKit")) {
			robber.addHitPoints(50);
			System.out.println("You use a med kit and gain 50 health");
		}
	}
	
	public void useMapFragment(Robber robber) {
		System.out.println("You glance at a map fragment to see the rooms around you and then destroy it.");
		
	}
	
	public void tripLaserGrid(Robber robber, Item item) {
		Random rand = new Random(System.currentTimeMillis());
		if(item.type.equals("laserGrid")) {
			int damage = rand.nextInt(25) + 1;
			robber.subtractHitPoints(damage);
			System.out.println("You trip a laser grid and get burned, taking " + damage + " damage");
		}
	}
	
	public Item medKit() {
        return new Item ("medKit", "Adds health to the player");
    }
	
	public Item mapFragment() {
		return new Item ("mapFragment", "Shows contents of adjacent rooms");
	}
	
	public Item laserGrid() {
		return new Item ("laserGrid", "Trap that deals damage to the player");
	}
	
}
