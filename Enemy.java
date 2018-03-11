package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject {
	
	
	
	public Enemy(int x, int y, String type) {
		super(x, y , type);
		
		
		velX = 5;
		velY = 5;
	}
	
	public Enemy(int x, int y, int velX, int velY, String type) {
		super(x, y , type);
		
		this.velX = velX;
		this.velY = velY;
	}
	
	public void tick() {
		x += velX;
		y += velY;
		if(y <= 0 || y>= Game.HEIGHT - 32)	velY *= -1;  //keert terug als rand van scherm raakt
		if(x <= 0 || x>= Game.WIDTH - 16)	velX *= -1;  //keert terug als rand van scherm raakt
	}
	
	public void render(Graphics g) { 
		g.setColor(Color.red);
		g.fillRect(x,y,16,16);
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,16,16);
	}


}
