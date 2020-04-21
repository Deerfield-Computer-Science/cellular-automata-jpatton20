import java.awt.Color;

public class Asymptomatic extends Person {
	
	public Asymptomatic(Location l, World w) {
		super(l,w);
		myLifeSpan = 3;
		myColor=Color.orange;
	}
	
	public void reproduce() {

	}

}