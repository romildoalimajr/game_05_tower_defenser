package net.kalangos.entities;

import java.awt.image.BufferedImage;

import net.kalangos.main.Game;
import net.kalangos.world.AStar;
import net.kalangos.world.Vector2i;
import net.kalangos.world.World;

public class Enemy extends Entity {

	public boolean right = true, left = false;

	public int life = 3;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
		path = AStar.findPath(Game.world, new Vector2i(World.xINITIAL, World.yINITIAL),
				new Vector2i(World.xFINAL, World.yFINAL));
	}

	public void tick() {

		followPath(path);
		
		if(x >= Game.WIDTH) {
			//System.out.println("perdemos vida");
			Game.life -= Entity.rand.nextDouble();
			Game.entities.remove(this);
			return;
		}
	}

}
