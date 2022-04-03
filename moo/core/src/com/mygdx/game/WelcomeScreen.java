package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class WelcomeScreen implements Screen {

    final CowGame game;
    private Stage stage;
    private Table table;
    private Skin skin;

    private Sound moo;
    private TextButton play;

    public WelcomeScreen (final CowGame game) {
        this.game = game;

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("skin/flat-earth-ui.json"));

        table = new Table(skin);
        table.setFillParent(true);
        stage.addActor(table);

//        table.setDebug(true);

        //table.setBackground(skin.getTiledDrawable("tile-a"));

        Label moo = new Label("MOO!", skin, "title");
        table.add(moo);
        table.row();

        Label welcome = new Label("Play my free cow simulator!", skin);
        table.add(welcome).padBottom(50);
        table.row();

        play = new TextButton("Play Game", skin);
        table.add(play).width(400);
        table.row();

        Label attribution = new Label("Art and Game by Madison.", skin);
        table.add(attribution).padTop(10);




    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(new Color(1, 1, 1, 1));

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        if (play.isPressed()) {

            Sound moo = Gdx.audio.newSound(Gdx.files.internal("sounds/moo.ogg"));
            moo.play();

            game.setScreen(new Field(game));
            dispose();
        }


    }

    @Override
    public void resize(int width, int height) { stage.getViewport().update(width, height, true); }

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
        stage.dispose();
    }
}
