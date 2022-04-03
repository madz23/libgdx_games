package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class CowGame extends Game {

	public SpriteBatch batch;


	@Override
	public void create() {
		batch = new SpriteBatch();
		//batch.begin();
		this.setScreen(new WelcomeScreen(this));

	}

	public void render() { super.render(); }

	public void dispose() {
		batch.dispose();
	}
}
