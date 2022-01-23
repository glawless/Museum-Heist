package dungeon;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.io.*; 

import org.junit.jupiter.api.Test;

class HeistJunitTests {
	
	public final Museum museumTest = new Museum();

	@Test
	void enterExitRoomTest() {
		//arrange
		
		//act
		
		//assert
		int enter = 0;
		int exit = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(museumTest.getMuseum()[i][j] instanceof EntranceRoom) {
					enter++;
				}else if(museumTest.getMuseum()[i][j] instanceof ExitRoom) {
					exit++;
				}
				
					
			}
			
		}
		
		assertTrue(enter == 1 && exit == 1);
	}
	
	@Test
	void roomConstructorTest() {
		//arrange
		
		//act
		
		//assert
		Room room1 = new Room(0,0,0,0);
		
		assertFalse(room1.isDoor(room1.getWestWall()) && room1.isDoor(room1.getEastWall()) && room1.isDoor(room1.getSouthWall()) && room1.isDoor(room1.getNorthWall()));
	}
	
	@Test
	void pillarCount() {
		//arrange
		
		//act
		
		//assert
		int pillarsInMaze = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(museumTest.getMuseum()[i][j].getContents().containsKey("Pillar")) {
					pillarsInMaze++;
				}
				
					
			}
			
		}
		
		assertTrue(pillarsInMaze == 4);
	}
	
	//sometimes this test will fail as it is random
	@Test
	void randomRoomContents() {
		//arrange
		
		//act
		
		//assert
		Room room1 = new Room(0,0,0,0);
		room1.randomizeContents();
		Room room2 = new Room(0,0,0,0);
		room2.randomizeContents();
		
		assertFalse(room1.toString().equals(room2.toString()));
	}
	
	@Test
	void robberFactoryTest() {
		//arrange
		
		//act
		
		//assert
		Robber rob1 = new Gunslinger("Chad", AbilitiesPool.abililtyFactory("Gunslinger"));
		Robber rob2 = RobberFactory.robberFactory(1, "Chad");
		
		assertTrue(rob1.getName().contentEquals(rob2.getName()) && rob1 instanceof Gunslinger && rob2 instanceof Gunslinger);
	}
	
	@Test
	void lawManFactoryTest() {
		//arrange
		
		//act
		
		//assert
		LawMan law1 = new DonutSlinger( AbilitiesPool.abililtyFactory("DonutSlinger"));
		LawMan law2 = LawManFactory.lawFactory(1);
		
		assertTrue(law1.getName().contentEquals(law2.getName()) && law1 instanceof DonutSlinger && law2 instanceof DonutSlinger);
	}
	
	@Test
	void abilityFactoryTest() {
		//arrange
		
		//act
		
		//assert
		Abilities ab1 =  AbilitiesPool.abililtyFactory("Gunslinger");
		Abilities ab2 = new GunzerkerAttack();
		
		assertTrue(ab1 instanceof GunzerkerAttack &&  ab2 instanceof GunzerkerAttack);
	}

}
