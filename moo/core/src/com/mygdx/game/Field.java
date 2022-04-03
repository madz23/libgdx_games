package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

public class Field implements Screen {

    final CowGame game;

    private final int COW_WIDTH = 100;
    private final int COW_HEIGHT = 100;

    private Cow cow;
    private Texture grassTile;
    private Texture dirtTile;

    Texture[][] tiles;

    public Field(final CowGame game){
        this.game = game;
        cow = new Cow(game, COW_HEIGHT, COW_WIDTH);

        grassTile = new Texture(Gdx.files.internal("grass_tile.png"));

    }

    @Override
    public void show() {

    }


    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        //ScreenUtils.clear(Color.WHITE);

        game.batch.begin();
        game.batch.draw(grassTile, 0, 0);



        cow.stand();

        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
                Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.DOWN) ||
                Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.W) ||
                Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            clearScreen();
            cow.walk();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) { cow.moo(); }

        game.batch.end();
    }

    private void clearScreen(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        game.batch.draw(grassTile, 0, 0);
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
        grassTile.dispose();
        dirtTile.dispose();
    }

}
