package net.kalangos.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.kalangos.main.Game;
import net.kalangos.world.AStar;
import net.kalangos.world.Vector2i;
import net.kalangos.world.World;

public class Enemy extends Entity {

	public boolean right = true, left = false;

	public double life = 30;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
		path = AStar.findPath(Game.world, new Vector2i(World.xINITIAL, World.yINITIAL),
				new Vector2i(World.xFINAL, World.yFINAL));
	}

	public void tick() {
		
		//life -= 0.1;
		followPath(path);
		
		if(x >= Game.WIDTH) {
			//System.out.println("perdemos vida");
			Game.life -= Entity.rand.nextDouble();
			Game.entities.remove(this);
			
			return;
		}
		if(life <= 0) {
			Game.entities.remove(this);
			Game.money++;
			return;
		}
	}
	
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.red);
		g.fillRect((int)x, (int)(y-5), 30, 5);
		
		g.setColor(Color.green);
		g.fillRect((int)x, (int)(y-5), (int)((life/30)*30), 5);
		
	}

}
