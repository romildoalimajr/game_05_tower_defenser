package net.kalangos.entities;

import java.awt.image.BufferedImage;

import net.kalangos.main.Game;
import net.kalangos.world.World;

public class TowerController extends Entity {

	public boolean isPressed = false;
	public int xTarget, yTarget;

	public TowerController(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}

	public void tick() {
		if (isPressed) {
			isPressed = false;
			boolean liberado = true;
			// crair algo no mapa
			int xx = (xTarget / 16) * 16;
			int yy = (yTarget / 16) * 16;
			Player player = new Player(xx, yy, 16, 16, 0, Game.spritesheet.getSprite(17, 17, 16, 16));
			for (int i = 0; i < Game.entities.size(); i++) {
				Entity e = Game.entities.get(i);
				if (e instanceof Player) {
					if (Entity.isColidding(e, player)) {
						liberado = false;
						System.out.println("Não posso adicionar nesta posição, já tem torre");
					} 
				}
			}
			
			if(World.isFree(xx, yy)) {
				liberado = false;
				System.out.println("posição ocupada");
			}
			
			if (liberado) {
				if(Game.money >= 2) {
					Game.entities.add(player);
					Game.money -= 2;
				}else {
					System.out.println("sem dinheiro");
				}
			}
		}
		/*
		if(isPressed) {
			int xx = (xTarget / 16) * 16;
			int yy = (yTarget / 16) * 16;
			Player player = new Player(xx, yy, 16,16,0, Game.spritesheet.getSprite(16, 16, 16, 16));
			Game.entities.add(player);
		}*/
	}
	

}
