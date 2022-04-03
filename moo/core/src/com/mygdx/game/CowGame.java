package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class CowGame extends Game {

	public SpriteBatch batch;

	public Sound moo;
	public Music menuTune;

	@Override
	public void create() {
		batch = new SpriteBatch();

		moo = Gdx.audio.newSound(Gdx.files.internal("sounds/moo.ogg"));
		menuTune = Gdx.audio.newMusic(Gdx.files.internal("sounds/menu_tune.wav"));
		menuTune.setLooping(true);
		//batch.begin();
		this.setScreen(new WelcomeScreen(this));

	}

	public void render() { super.render(); }

	public void dispose() {
		moo.dispose();
		batch.dispose();
	}
}
