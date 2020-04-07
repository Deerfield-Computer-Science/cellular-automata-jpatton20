import java.util.ArrayList;

public class Hawk extends Animal {
	
	public Hawk(Location l, World w) {
		super(l,w);
		myLifeSpan = 3;
	}
	
	public void reproduce() {
		// this is silly code really, but as an example
		int newX = (int)(Math.random()*17);
		int newY = (int)(Math.random()*17); 
		
		myWorld.getCreatureList().add(new Hawk(new Location(newX,newY), myWorld));
	}

}
