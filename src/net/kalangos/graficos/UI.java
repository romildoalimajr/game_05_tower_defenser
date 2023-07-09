package net.kalangos.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.kalangos.main.Game;

public class UI {

	public static BufferedImage HEART = Game.spritesheet.getSprite(0, 16, 8, 9);
	public void render(Graphics g) {
		for(int i = 0; i < (int)Game.life; i++) {
			g.drawImage(HEART, 15 + (i * 40), 10, 36, 36, null);
		}
		
		g.setFont(new Font("arial", Font.BOLD,24));
		g.setColor(Color.WHITE);
		g.drawString("$" + Game.money, (Game.WIDTH * Game.SCALE) - 80, 30);
	}
	
}
