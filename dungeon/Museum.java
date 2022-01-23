package dungeon;
import java.io.Serializable;
import java.util.*;
public class Museum implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2999982143697119088L;

	private int pillars = 0;
	
	private int playerRow = 0;
	private int playerColumn = 0;
	
	private Room[][] museum = new Room [5][5]; 
	
	private static Random rand = new Random();
	
	public Museum(){
		for(int i = 0; i < museum.length; i++) {
			for(int j = 0; j < museum.length; j++) {
				museum[i][j] = new Room(1, 1, 1, 1);
				museum[i][j].randomizeContents();
			}
		}
		addBorders();
		museum[0][0] = new EntranceRoom();
		museum[4][4] = new ExitRoom();
		addPillars();
	}
	
	public Room[][] getMuseum(){
		return this.museum;
	}
	
	public void addPillars() {
		for(int i = 0; i < 4; i++) {
			Room pillar = museum[rand.nextInt(5)][rand.nextInt(5)];
			
			if(pillar instanceof ExitRoom || pillar instanceof EntranceRoom){
				pillar = museum[rand.nextInt(5)][rand.nextInt(5)];
			}
			
			if(!pillar.getContents().containsKey("Pillar"))
			{
				pillar.getContents().put("Pillar", 1);
			}
			this.pillars++;
		}
	}
	
	public void addBorders() {
		for(int i = 0; i < museum.length; i++) {
			museum[0][i] = new Room(0, 1, 1, 1);
			museum[4][i] = new Room(1, 1, 0, 0);
			museum[i][0] = new Room(1, 1, 1, 0);
			museum[i][4] = new Room(1, 0, 1, 1);			
		}
		
		museum[0][4] = new Room(0, 0, 1, 1);
		museum[4][0] = new Room(1, 1, 0, 0);
		
		
	}
	
	public void printMuseum() {
		
		for (int i = 0; i < this.museum.length; i++) {
			for (int j = 0; j < this.museum.length; j++) {
				System.out.print( this.museum[i][j].roomTop()+" ");
			}
			System.out.println();
			for (int k = 0; k < this.museum.length; k++) {
				System.out.print( this.museum[i][k].roomMid("")+" ");
			}
			System.out.println();
			for (int l = 0; l < this.museum.length; l++) {
				System.out.print( this.museum[i][l].roomBottom()+" ");
			}
			System.out.println();
			
				
		}	
		
	}
	

	public void enterRoom(Robber robber) {
		Room curRoom = museum[this.playerColumn][this.playerRow];
		System.out.println(curRoom.toString());
		
		if(curRoom.isVisited()){
			System.out.println("Looks like you've already been in this room");
		}
		
		if(curRoom.getContents().containsKey("Waldo")){
			System.out.println(robber.getName() + " enters the room to find Waldo standing under a spotlight, Waldo snaps his fingers");
			System.out.println(robber.getName() + " slowly dissapeares into the abys \nThe Heist was a failure");
			System.exit(0);

		}
		
		if(curRoom.getContents().containsKey("Laser Grid")){
			System.out.println(robber.getName() + " has triggerd a laser Grid");
			robber.subtractHitPoints(20);
		}
		
		if(curRoom.getContents().containsKey("LawMan")){
			battle(robber, (LawMan) curRoom.getContents().get("LawMan"));

			
		}
		
		if(curRoom.getContents().containsKey("Med Kit")){ 
			System.out.println(robber.getName() + " found a Med Kit and added it to his inventory");
			robber.addMedKit();
			
		}
		
		if(curRoom.getContents().containsKey("Map Fragment")){ 
		}
		
		if(curRoom.getContents().containsKey("Pillar")){ 
			System.out.println(robber.getName() + " found a pillar and added it to his inventory");
			robber.addPillars();
			if(robber.maxPillars()) {
				System.out.println(robber.getName() + " found all the pillars now to find the exit");
			}
		}
		
		if(curRoom instanceof ExitRoom)
		{ 
			if(robber.maxPillars()) {
				System.out.println("Congratulations you found all the pillars Job well done");
				printMuseum();
				System.exit(0);
			}else{
				System.out.println("You Dont have all the pillars yet come back when you find them all");
			}
		}
		
		if(curRoom.getContents().isEmpty() && !curRoom.isVisited()){
			System.out.println("This room is empty nothing to find");
			
		}
		
		if(!curRoom.isVisited()){
			curRoom.setVisited();
		}
		curRoom.getContents().clear();
		
	}
	
	public static void battle(Robber robber, LawMan theMan)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println(robber.getName() + " battles " +
							theMan.getName());

		
		while (robber.isAlive() && theMan.isAlive())
		{
		    
			battleChoices(robber, theMan);

			
			if (theMan.isAlive())
			{
				if(rand.nextInt(100)+1 <= 20)
				{
					theMan.SpecialAttack(robber);
				}
				theMan.attack(robber);
			}


		}

		if (!theMan.isAlive()) {
			System.out.println(robber.getName() + " was victorious!");
			}
		else if(!robber.isAlive())
		{
			System.out.println(robber.getName() + " was defeated");
		}

	}
	
	public static void battleChoices(Robber robber, LawMan theMan) {
		Scanner kb = new Scanner(System.in);
		robber.setNumTurns(robber.getAttackSpeed()/theMan.getAttackSpeed());

		if (robber.getNumTurns() == 0)
			robber.setNumTurns(robber.getNumTurns()+ 1);

		System.out.println("Number of turns this round is: " + robber.getNumTurns());


		do
		{
			attackMenu(robber);
			while(!kb.hasNextInt()) {
				System.out.print("Please enter a vlaid option: ");
				System.out.println();
			    kb.next();
			}
			int input = kb.nextInt();

		    
		    switch (input)
		    {
			    case 1: robber.attack(theMan);
			        break;
			    case 2: robber.SpecialAttack(theMan);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }

			robber.setNumTurns(robber.getNumTurns()-1);
			if (robber.getNumTurns() > 0)
			    System.out.println("Number of turns remaining is: " + robber.getNumTurns());

		} while(robber.getNumTurns() > 0);
	}

	public static void attackMenu(Robber robber)
	{
		if(robber instanceof Gunslinger)
		{
			System.out.println("1. Attack Opponent");
		    System.out.println("2. Gunzerker Attaack");
		    System.out.print("Choose an option: ");
		}
		else if(robber instanceof FemmeFatale)
		{
			System.out.println("1. Attack Opponent");
		    System.out.println("2. Perform a Distraction");
		    System.out.print("Choose an option: ");
		}
		else if(robber instanceof Medic)
		{
			System.out.println("1. Attack Opponent");
		    System.out.println("2. Health Grenade");
		    System.out.print("Choose an option: ");
		}
		else if(robber instanceof Pyromaniac)
		{
			System.out.println("1. Attack Opponent");
		    System.out.println("2. Pyrotechnics Attack");
		    System.out.print("Choose an option: ");
		}
		else if(robber instanceof Demolitionist)
		{
			System.out.println("1. Attack Opponent");
		    System.out.println("2. MOAB");
		    System.out.print("Choose an option: ");
		}else if(robber instanceof BigBoomer) {
			
			System.out.println("1. Attack Opponent");
		    System.out.println("2. Use your Entitlement");
		    System.out.print("Choose an option: ");
		}
	}
	
	
	public void advanceEastWest(String direction) {
		Room curRoom = museum[this.playerColumn][this.playerRow];
		curRoom.roomMid("P");
		if (direction.equals("West") && curRoom.isDoor(curRoom.getWestWall())) {
			this.playerRow--;
			
		} else if (direction.equals("East") && curRoom.isDoor(curRoom.getEastWall())) {
			this.playerRow++;
		} else {
			System.out.println("Cannot move this way there is no door");
		}

	}
	
	public void advanceNorthSouth(String direction) {

		Room curRoom = museum[this.playerColumn][this.playerRow];
		curRoom.roomMid("P");
		if (direction.equals("North") && curRoom.isDoor(curRoom.getNorthWall())) {
			this.playerColumn--;
		} else if (direction.equals("South") && curRoom.isDoor(curRoom.getSouthWall())) {
			this.playerColumn++;
		} else {
			System.out.println("Cannot move this way there is no door");
		}
	}
	
	
}
