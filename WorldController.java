import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class WorldController extends GraphicsProgram {
	
	private World theWorld;
	private GCanvas theWorldCanvas;
	public static final int APPLICATION_WIDTH = 700;
	public static final int APPLICATION_HEIGHT = 700;
	
	public void run(){	
		setUpWorld();
		runWorld();
	}
	
	public void init(){
	    resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
	}
	
	public void setUpWorld(){
		theWorld = new World(70,70);
		theWorld.getCreatureList().add( new Symptomatic( new Location(50,60), theWorld ));
		theWorld.getCreatureList().add( new Symptomatic( new Location(40,50), theWorld ));
		theWorld.getCreatureList().add( new Symptomatic( new Location(30,40), theWorld ));
		theWorld.getCreatureList().add(new Asymptomatic(new Location(20,30), theWorld));
		theWorld.getCreatureList().add(new Asymptomatic(new Location(10,20), theWorld));

		theWorldCanvas = this.getGCanvas();
	}
	
	public void runWorld(){
		drawWorld();
		for(int i=0; i<50;i++){
			theWorld.letTimePass();
			pause(500);
			drawWorld();
		}
	}	
	
	public void drawWorld(){
		drawBlankWorld();
		drawCreatures();
		move();
	}
	
	public void move() {
		for(int m=0; m<theWorld.getCreatureList().size(); m++) {
			theWorld.getCreatureList().get(m).move();
		}
	}
	
	public void drawBlankWorld(){
		for(int row = 0 ; row<theWorld.getWidth(); row++)
			for(int col=0; col<theWorld.getHeight(); col++){
				GRect r = new GRect(row*10, col*10, 10, 10);
				r.setFillColor(Color.WHITE);
				r.setFilled(true);
				theWorldCanvas.add(r);
			}
	}
	
	public void drawCreatures(){
		for(LifeForm x: theWorld.getCreatureList()){
			GRect r = new GRect (x.getMyLocation().getX()*10, x.getMyLocation().getY()*10,10,10);
			r.setFillColor(x.getMyColor());
			r.setFilled(true);
			theWorldCanvas.add(r);
		}
	}
}
