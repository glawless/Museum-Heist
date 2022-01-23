package dungeon;
import java.io.Serializable;
import java.util.*;
public class Room implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -2593466774711894430L;
	//integers to keep track of n, s, e, w
	private int northWall, eastWall, southWall, westWall;
	private boolean visited = false;
	private static Random rand = new Random();
// hashmap to keep track of Objects in the room
	private HashMap<String, Object> roomContents = new HashMap<>();
	
	public Room(int northWall, int eastWall, int southWall, int westWall) {
		this.northWall = northWall;
		this.eastWall = eastWall;
		this.southWall = southWall;
		this.westWall = westWall;
		if (rand.nextInt(100)  <= 40) {
			roomContents.put("LawMan", LawManFactory.lawFactory(rand.nextInt(5) + 1));
		}
		if (rand.nextInt(100) <= 20) {
			roomContents.put("Laser Grid", 1);
		}
		if (rand.nextInt(100) <= 20) {
			roomContents.put("Med Kit", new Item("medKit", "Heals"));
		}
		if (rand.nextInt(100) <= 15) {
			roomContents.put("Map Fragment", new Item("mapFragment", "Reveals the map"));
		}
		if (rand.nextInt(100)  <= 1) {
			roomContents.put("Waldo", 1);
		}
	

	}
	
	public HashMap getContents() {
		return roomContents;
	}
	
	public int getNorthWall() {
		return northWall;
	}

	public int getEastWall() {
		return eastWall;
	}

	public int getSouthWall() {
		return southWall;
	}
	
	public int getWestWall() {
		return westWall;
	}
	
	public boolean isVisited() {
		return this.visited;
	}
	
	public void setVisited() {
		this.visited = true;
	}
	
	public boolean isDoor(int wall) {
		return wall == 1;
	}
	public void randomizeContents() {
	
	}
		
	
	public String roomTop() {
		String top = "";
		if(this.isDoor(northWall)) {
			top = "* - *"; 
		}else {
			top = "* * *";
		}
		return top;
	}
	
	public String roomMid(String object) {
		String east = "";
		String west = "";
		if(this.isDoor(this.westWall)) {
			west = "| ";
		}else {
			west = "* ";
		}
		
		if(this.roomContents.size() > 1) {
			object = "M";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("LawMan")) {
			object = "X";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Laser Grid")) {
			object = "L";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Map Fragment")) {
			object = "V";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Med Kit")) {
			object = "H";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Waldo")) {
			object = "W";
		}else if(this.roomContents.size() == 1 && this.roomContents.containsKey("Pillar")) {
			object = "P";
		}
		else {
			object = "E";
		}
		
		if(this.isDoor(this.eastWall)) {
			east = " |";
		}else {
			east= " *";
		}
		return west + object + east;
	}
	
	public String roomBottom() {
		String bottom = "";
		
		if(this.isDoor(this.southWall)) {
			bottom = "* - *";
		}else {
			bottom = "* * *";
		}
		
		return bottom;
	}

	

	public String toString() 
	{
		String result = "\n" + this.roomTop() 
				 +  "\n" + this.roomMid("") 
				+ "\n" + this.roomBottom();

		return result;   
	}
}
