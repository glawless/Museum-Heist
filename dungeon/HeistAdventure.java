import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class HeistAdventure {
	private static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		Museum java;
		Robber theRobber;

		do {
			java = startGame();
			theRobber = chooseCharacter();
			theHeist(java, theRobber);
			

		} while (playAgain());

	}
	
	public static void saveGame(Museum museum, Robber robber) throws Exception {
		if(museum == null) throw new Exception("The passed in museum object is null");
		if(robber == null) throw new Exception("The passed in robber object is null");
		
		if(saveExists()) {
			System.out.print("Would you like to overwrite your previous save? Y/N: ");
			switch(kb.next().toUpperCase()) {
			case "Y":
				try {
					ObjectOutputStream museumOut = new ObjectOutputStream(new FileOutputStream("SaveMuseum.txt"));
					ObjectOutputStream robberOut = new ObjectOutputStream(new FileOutputStream("SaveRobber.txt"));
					
					museumOut.writeObject(museum);
					robberOut.writeObject(robber);
					museumOut.close();
					robberOut.close();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			break;
			case"N":
				return;
			default:
				System.out.println("Please choos a valid option");
				
			}
		}else {
			try {
				ObjectOutputStream museumOut = new ObjectOutputStream(new FileOutputStream("SaveMuseum.txt"));
				ObjectOutputStream robberOut = new ObjectOutputStream(new FileOutputStream("SaveRobber.txt"));
				
				museumOut.writeObject(museum);
				robberOut.writeObject(robber);
				museumOut.close();
				robberOut.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public static void loadGame() throws Exception {
		
		ObjectInputStream musuemIn = new ObjectInputStream(new FileInputStream("SaveMuseum.txt"));
		ObjectInputStream robberIn = new ObjectInputStream(new FileInputStream("SaveRobber.txt"));
		
		Museum museum = (Museum) musuemIn.readObject();
		Robber theRobber = (Robber) robberIn.readObject();
		
		theHeist(museum, theRobber);
	}
	
	public static boolean saveExists() {
		File f = new File("SaveMuseum.txt");
		if(f.exists())
		{
			return true;
		}
		return false;
	}
	
	public static Museum startGame() throws Exception {
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Museum Heist");
		System.out.println("***********************");
		System.out.println("1.) Start a new game");
		System.out.println("2.) Load a saved game");
		System.out.println("3.) Exit");
		System.out.println("***********************");
        System.out.print("Make a selection: ");
        Museum museum;
        
        switch (kb.nextInt()) {
        	case 1:
        		return new Museum();
            case 2:
                loadGame();
                break;
            case 3:
                System.exit(0);
            default:
            	System.out.println("Please enter a valid option");
        }
		return null;
	}
	
	public static Robber chooseCharacter(){
		
		System.out.println("Robbers for hire");
		System.out.println("***********************");
		System.out.println("1.) Gunslinger");
		System.out.println("2.) Femme Fatale");
		System.out.println("3.) Medic");
		System.out.println("4.) Demolitionist");
		System.out.println("5.) Pyromaniac");
		System.out.println("***********************");
		System.out.print("Choose a character: ");
		System.out.println();
		int choice = kb.nextInt();
		String name = "";
		if(choice <= 5) {
			System.out.print("Enter the name of your Robber: ");
			name = kb.next();
		}
		
		return characterCreator(choice, name);
		
	}
	
	public static Robber characterCreator(int choice, String name) {
		
		switch (choice) {
		case 1:
			return RobberFactory.robberFactory(1, name);
			
		case 2:
			return RobberFactory.robberFactory(2, name);
			
		case 3:
			return RobberFactory.robberFactory(3, name);
			
		case 4:
			return RobberFactory.robberFactory(4, name);
			
		case 5:
			return RobberFactory.robberFactory(5, name);
			
		case 1945:
			return RobberFactory.robberFactory(1945, "Donald");
		
		default:
			return RobberFactory.robberFactory(1, "Spike");
		}
	}
	
	public static void theHeist(Museum museum, Robber theRobber) throws Exception {
		
		System.out.println("you have entered the musuem. Time to find the pillars");
		String choice = "";
		while(theRobber.isAlive()) {
			System.out.println("***********************");
			System.out.println("N) move North");
			System.out.println("E) move East");
			System.out.println("S) move South");
			System.out.println("W) move West");
			System.out.println("M) use a medKit");
			System.out.println("Q) Save the game");
			System.out.println("L) Exit the game");
			System.out.println("***********************");
			System.out.print("Pick an option: ");
			
			choice = kb.next().toUpperCase();
			switch(choice) {
			case "N":
				museum.advanceNorthSouth("North");
				museum.enterRoom(theRobber);
				break;
			case "E":
				museum.advanceEastWest("East");
				museum.enterRoom(theRobber);
				break;
			case "S":
				museum.advanceNorthSouth("South");
				museum.enterRoom(theRobber);
				break;
			case "W":
				museum.advanceEastWest("West");
				museum.enterRoom(theRobber);
				break;
			case "M":
				if (theRobber.getMedKit() > 0) {
					System.out.println(theRobber.getName() + " used a med kit");
					theRobber.addHitPoints(50);
					theRobber.decreaseMedKit();
					System.out.println(theRobber.getName() + " now has " + theRobber.getMedKit() + "'s left");
				}else {
					System.out.println("You don't have any Med Kit's to use");
				}
				
				break;
			case "Q":
				saveGame(museum, theRobber);
				break;
			case "L":
				System.exit(0);
				break;
				
			default:
				System.out.println(theRobber.getName() + "Stands there looking confused");
			}
		}
	}

	public static boolean playAgain() {
		String choice = "";
		while(true){
			System.out.print("Would you like to perform the next heist y/n: ");
			choice = kb.nextLine().toUpperCase();
			switch(choice) {
			case "Y":
				return true;
			case "N":
				return false;
			default:
				System.out.println("Please enter a valid selection");
			
			}
			
		}
	}
}
