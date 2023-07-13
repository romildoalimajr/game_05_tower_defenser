package net.kalangos.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.kalangos.main.Game;

public class Player extends Entity {

	public int xTarget, yTarget;
	public boolean isAtack = false;
	
	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	}

	public void tick() {
		Enemy enemy = null;
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Enemy) {
				int xEnemy = e.getX();
				int yEnemy = e.getY();
				if(Entity.calculateDistance(this.getX(), this.getY(), xEnemy, yEnemy) < 40) {
					enemy = (Enemy)e;
					
				}
			}
		}
		if(enemy != null) {
			isAtack = true;
			xTarget = enemy.getX();
			yTarget = enemy.getY();
			if(Entity.rand.nextInt(100) < 30) {
				enemy.life -= Entity.rand.nextDouble();
			}
		}else {
			isAtack = false;
		}
	}
	
	public void render(Graphics g) {
		super.render(g);
		//mostrar ataque as torres
		
		if(isAtack) {
			g.setColor(Color.yellow);
			g.drawLine((int)x+7, (int)y+7, yTarget+7, xTarget+7);
		}
	}

}
