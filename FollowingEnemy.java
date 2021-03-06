package SoftwareProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FollowingEnemy extends GameObject{
		

		private GameObject player;

		public FollowingEnemy(int x, int y, String type, Handler handler, String link) {
										
			super(x, y, type);							//Link = de naam van het type dat deze enemy moet volgen
			
			
			for(int i =0; i<handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getType().equals(link)) player = handler.object.get(i);		//Zoekt de link in de objectenlijst
			}
			
			
		}
		
		public Rectangle getBounds(){
			return new Rectangle(x,y,16,16);
		}

		public void tick() {
			
			x += velX;
			y += velY;
			
			
			float dx = x - player.getX() -8;		//Positiebijsturing relatief aan de link
			float dy = y - player.getY() -8;
			float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) +  (y-player.getY())*(y-player.getY()));
			
			velX = (int) ((-1.0/distance)*dx*5/2);		//Snelheid en richting worden bepaald door de positie van de link
			velY = (int) ((-1.0/distance)*dy*5/2);
			
			
		}

		public void render(Graphics g) {

			g.setColor(Color.pink);
			g.fillRect(x, y, 16, 16);
			
		}

		
		
	}
