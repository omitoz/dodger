package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Player extends GameObject {

	Handler handler;
	int health;
	int hudX;
	HUD hud;


	public Player(int x, int y, String type, Handler handler, int health, int hudX) {
		super(x, y, type);
		this.handler = handler;
		this.health = health;
		this.hudX = hudX;
		hud = new HUD(hudX);

		
		//velX =5;
		//velY =5;
	}

	
	public void tick() {
		x +=velX;
		y +=velY;
		// je kan niet buiten de grenzen van het spel
		x = Game.border(x, 0, Game.WIDTH-37); //als je volgende x positie buiten veld is, dan terug naar vorige x positie
		y = Game.border(y, 0, Game.HEIGHT-60); // idem x
		collisionCheck();
		if(health<=0) {
			health = 0;
			//Game over code nog aanvullen
		}
	}

	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
		updateHud(g);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,32,32);
	}
	
	public void setHealth(int hp) {
		health = hp;
		
	}
	
	public int getHealth() {
		return health;
	}
	
	public void collisionCheck() {
		LinkedList<GameObject> list = handler.getObjects();
		for(int i =2;i<list.size();i++) {
			GameObject tempObject = list.get(i);
			if(getBounds().intersects(tempObject.getBounds())){
				switch(tempObject.getType()) {
						case "Enemy": health-=2;
							System.out.println("Botsing");
							break;
						case "HealthBox": 
							if(health<81) {
								health+=20;
							}else {
								health=100;
							}
							handler.removeObject(tempObject);
							break;
				}
			}
		}
	}
	
	public void updateHud(Graphics g) {
		hud.setHealth(health);
		hud.render(g);
	}

}
