package net.kalangos.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.kalangos.main.Game;

public class Spawner extends Entity{
	
	private int timer = 60;
	private int curTimer = 0;

	public Spawner(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
		//criar inimigos
		curTimer++;
		if(curTimer == timer) {
			//hora de criar o inimigo
			curTimer = 0;
			timer = Entity.rand.nextInt(60 - 30) + 30;
			Enemy enemy = new Enemy(x,y, 16, 16, Entity.rand.nextGaussian(), Entity.ENEMY_RIGHT);
			Game.entities.add(enemy);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
	}

}
