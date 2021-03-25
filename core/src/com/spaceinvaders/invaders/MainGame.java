package com.spaceinvaders.invaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import screen.GameScreen;
import screen.ScreenManager;

public class MainGame extends ApplicationAdapter {

	public static int WIDTH = 1200, HEIGHT = 800;
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ScreenManager.setScreen(new GameScreen());
	}


	@Override
	public void dispose () {
		if(ScreenManager.getCurrent_screen() != null) {
			ScreenManager.getCurrent_screen().dispose();
		}
		batch.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if(ScreenManager.getCurrent_screen() != null) {
			ScreenManager.getCurrent_screen().update();
		}

		if(ScreenManager.getCurrent_screen() != null) {
			ScreenManager.getCurrent_screen().render(batch);
		}

	}

	@Override
	public void pause () {
		if(ScreenManager.getCurrent_screen() != null) {
			ScreenManager.getCurrent_screen().pause();
		}
	}

	@Override
	public void resume () {
		if(ScreenManager.getCurrent_screen() != null) {
			ScreenManager.getCurrent_screen().resume();
		}
	}

	@Override
	public void resize (int width, int height) {
		if(ScreenManager.getCurrent_screen() != null) {
			ScreenManager.getCurrent_screen().resize(width, height);
		}
	}
}
