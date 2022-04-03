package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.ScreenUtils;

public class Field implements Screen {

    final CowGame game;

    private final int COW_WIDTH = 100;
    private final int COW_HEIGHT = 100;

    private Cow cow;


    public Field(final CowGame game){
        this.game = game;
        cow = new Cow(game, COW_HEIGHT, COW_WIDTH);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        ScreenUtils.clear(Color.WHITE);

        cow.stand();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
            cow.walk();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) { cow.moo(); }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
