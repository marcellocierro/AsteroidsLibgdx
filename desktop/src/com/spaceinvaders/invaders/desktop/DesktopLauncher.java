package com.spaceinvaders.invaders.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.spaceinvaders.invaders.MainGame;

public class dDesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Space Invaders";
		//config.useGL30 = true;
		config.width = MainGame.WIDTH;
		config.height = MainGame.HEIGHT;

		new LwjglApplication(new MainGame(), config);
	}
}
