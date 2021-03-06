import java.awt.Color;
import java.util.ArrayList;

import acm.util.RandomGenerator;

public abstract class LifeForm {
	
	protected World myWorld;
	protected int myLifeSpan;
	protected Location myLocation;
	protected Color myColor;
	protected int myAge;
	protected boolean alive;
	
	// lifeform constructors
	public LifeForm(int myLifeSpan, Location myLocation, Color myColor, World myWorld) {
		super();
		this.myLifeSpan = myLifeSpan;
		this.myLocation = myLocation;
		this.myColor = myColor;
		this.myWorld = myWorld;
		alive = true;
	}
	
	public LifeForm(Location myLocation, World myWorld) {
		super();
		this.myWorld = myWorld;
		this.myLocation = myLocation;
		alive = true;
	}
	
	/* all the basic lifeform functions
	 * 		getOlder
	 * 		reproduce
	 */
	
	// we all age the same, time clicks forward and we all age one unit of time
/*	public void age(int time){
		myAge+=time;
		if (myAge>myLifeSpan)
			alive=false;
	}
	*/
	
	// to be alive you have to be able to reproduce....
	public abstract void reproduce();
	
	public boolean isDead(){
		return !alive;
	}
	
	// getter and setters (aka accessors and mutators)
	public int getMyLifeSpan() {
		return myLifeSpan;
	}
	
	public void setMyLifeSpan(int myLifeSpan) {
		this.myLifeSpan = myLifeSpan;
	}
	
	public Location getMyLocation() {
		return myLocation;
	}
	
	public void setMyLocation(Location myLocation) {
		this.myLocation = myLocation;
	}
	
	public void move() {
		int y; 
		int x;
		x= getMyLocation().getX()+rgen.nextInt(-1, 1);
		y= getMyLocation().getY()+rgen.nextInt(-1, 1);
		
		Location L = new Location(x, y);
		
		setMyLocation(L);
		
	}
	
	public void infect(int i) {
		int infectivity;
			if(myWorld.getCreatureList().get(i).getAge()>70) {
				infectivity=rgen.nextInt(0, 2);
				if (infectivity==1) {
					//creature is dead, new symptomatic
					myWorld.getCreatureList().get(i).isDead();
					myWorld.getCreatureList().add( new Symptomatic( new Location(30,40), myWorld ));
				}
			}
			else if(myWorld.getCreatureList().get(i).getAge()>30) {
					infectivity=rgen.nextInt(0, 10);
					if (infectivity==1 || infectivity==2) {
						//creature is dead, new asymptomatic
						myWorld.getCreatureList().get(i).isDead();
						myWorld.getCreatureList().add( new Symptomatic( new Location(30,40), myWorld ));
					}
					if(infectivity==3) {
						//creature is dead, new asymptomatic
						myWorld.getCreatureList().get(i).isDead();
						myWorld.getCreatureList().add( new Asymptomatic( new Location(30,40), myWorld ));
			}
			else {
					infectivity=rgen.nextInt(0, 10);
					if (infectivity==1) {
						//creature is dead, new symptomatic
						myWorld.getCreatureList().get(i).isDead();
						myWorld.getCreatureList().add( new Symptomatic( new Location(30,40), myWorld ));
					}
					if (infectivity==2) {
						myWorld.getCreatureList().get(i).isDead();
						myWorld.getCreatureList().add( new Asymptomatic( new Location(30,40), myWorld ));
						//creature is dead, new asymptomatic
					}
			}
				
		}
	}
	
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
public void checkSurroundings() {
		
		for(int i = 0; i < myWorld.getCreatureList().size(); i++) {
			
			for(int j = i+1; j < myWorld.getCreatureList().size(); j++) {
				
				//Checks if on the same box
				if((myWorld.getCreatureList().get(i).myLocation.getX() == myWorld.getCreatureList().get(j).myLocation.getX()) && (myWorld.getCreatureList().get(i).myLocation.getY() == myWorld.getCreatureList().get(j).myLocation.getY())) {
					
					System.out.println("There is a creature on me");
					
				}
				
				//Checks box on top
				if((myWorld.getCreatureList().get(i).myLocation.getX() == myWorld.getCreatureList().get(j).myLocation.getX()) && (myWorld.getCreatureList().get(i).myLocation.getY() == myWorld.getCreatureList().get(j).myLocation.getY()-1)) {
					
					System.out.println("There is a creature under me");
					
				}
				
				//Checks box under
				if((myWorld.getCreatureList().get(i).myLocation.getX() == myWorld.getCreatureList().get(j).myLocation.getX()) && (myWorld.getCreatureList().get(i).myLocation.getY() == myWorld.getCreatureList().get(j).myLocation.getY()+1)) {
					
					System.out.println("There is a creature above me");
					
				}
				
				//Checks box to the right
				if((myWorld.getCreatureList().get(i).myLocation.getX() == myWorld.getCreatureList().get(j).myLocation.getX()+1) && (myWorld.getCreatureList().get(i).myLocation.getY() == myWorld.getCreatureList().get(j).myLocation.getY())) {
					
					System.out.println("There is a creature to my left");
					
				}
				
				//Checks box to the left
				if((myWorld.getCreatureList().get(i).myLocation.getX() == myWorld.getCreatureList().get(j).myLocation.getX()-1) && (myWorld.getCreatureList().get(i).myLocation.getY() == myWorld.getCreatureList().get(j).myLocation.getY())) {
					
					System.out.println("There is a creature to my right");
					
				}
			}
			
		}
		
	}
	
	public Color getMyColor() {
		return myColor;
	}
	
	public void setMyColor(Color myColor) {
		this.myColor = myColor;
	}
	
	public int getAge() {
		return myAge;
	}

	public void setAge(int age) {
		this.myAge = age;
	}
	
	@Override
	public String toString() {
		return "LifeForm [myLifeSpan=" + myLifeSpan + ", myLocation="
				+ myLocation + ", myColor=" + myColor + "]";
	}
}
