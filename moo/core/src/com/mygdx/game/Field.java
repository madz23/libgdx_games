package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Field implements Screen {

    final CowGame game;

    private final int COW_WIDTH = 75;
    private final int COW_HEIGHT = 75;

    private Cow cow;
    private Texture grassTile;
    private Texture dirtTile;

    private OrthographicCamera camera;
    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;

    private int width;
    private int height;

    public Field(final CowGame game){
        this.game = game;

        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        camera.update();

        tiledMap = new TmxMapLoader().load("tiles/less_basic_field.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        TiledMapTileLayer mainLayer = (TiledMapTileLayer) tiledMap.getLayers().get(0);

        cow = new Cow(game, COW_HEIGHT, COW_WIDTH, mainLayer.getHeight() * mainLayer.getTileWidth(),
                mainLayer.getHeight() * mainLayer.getTileHeight());

    }

    @Override
    public void show() {

    }


    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        ScreenUtils.clear(Color.WHITE);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cameraBoundary();

        camera.update();
        tiledMapRenderer.setView(camera);
        game.batch.setProjectionMatrix(camera.combined);
        tiledMapRenderer.render();

        game.batch.begin();

        cow.getTummies().setPosX(camera.position.x - (Gdx.graphics.getWidth() / 2f) + 10);
        cow.getTummies().setPosY(camera.position.y + (Gdx.graphics.getHeight() / 2f) - cow.getTummies().getHeight() - 10);
        cow.getTummies().displayTummies();

        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT) || Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
                Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.DOWN) ||
                Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.W) ||
                Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.D)) {

            cow.walk();


            camera.position.x = cow.getPosX();
            camera.position.y = cow.getPosY();
            camera.update();

        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (isGrass(cow.getPosX() / 100, cow.getPosY() / 100)) {
                cow.eat();
            } else {
                cow.stand();
            }
        }
        else {
            cow.stand();
        }

        game.batch.end();
    }


    private void cameraBoundary() {

        float left_lim = 0 + (camera.viewportHeight * .5f);
        float right_lim = 3200 - (camera.viewportHeight * .5f);
        float bottom_lim = 0 + (camera.viewportHeight * .5f);
        float top_lim = 3200 - (camera.viewportHeight * .5f);

        if (camera.position.y > top_lim) { camera.position.set(camera.position.x, top_lim, 0); }
        if (camera.position.y < bottom_lim) { camera.position.set(camera.position.x, bottom_lim, 0); }
        if (camera.position.x > right_lim) {camera.position.set(right_lim, camera.position.y, 0); }
        if (camera.position.x < left_lim) {camera.position.set(left_lim, camera.position.y, 0); }


        camera.update();
    }


    private boolean isGrass(int x, int y) {
        int[] grassIDs = {12, 11, 10, 8};
        TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
        boolean grass = false;
        for (int grassID : grassIDs) {
            if (!grass) {
                grass = layer.getCell(x, y).getTile().getId() == grassID;
            }
        }
        return grass;
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
