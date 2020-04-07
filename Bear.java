import java.util.ArrayList;

public class Bear extends Animal {
	
	public Bear(Location l, World w) {
		super(l,w);
		myLifeSpan = 3;
	}
	
	public void reproduce() {
		// this is silly code really, but as an example
		int newX = (int)(Math.random()*12);
		int newY = (int)(Math.random()*12); 
		
		myWorld.getCreatureList().add(new Bear(new Location(newX,newY), myWorld));
	}

}
