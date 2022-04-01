package com.soundboard.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class SoundTable implements Screen {

    private Stage stage;
    private Table table;
    private OrthographicCamera camera;

    private TextButton chimeButtom;
    private TextButton jumpButton;
    private TextButton ribbitButton;
    private TextButton robotButton;
    private TextButton shootButton;
    private TextButton bangerButton;
    private TextButton happyButton;
    private TextButton stop;

    private Sound chime;
    private Music banger;
    private Music happy;
    private Sound jump;
    private Sound ribbit;
    private Sound robot;
    private Sound shoot;


    SoundBoard soundboard;

    public SoundTable(final SoundBoard soundboard) {
        this.soundboard = soundboard;

        camera = new OrthographicCamera();


        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

//        table.setDebug(true); // this puts those ugly blue lines around the table for development

        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        // sounds
        chime = Gdx.audio.newSound(Gdx.files.internal("chime.wav"));
        jump = Gdx.audio.newSound(Gdx.files.internal("jump.wav"));
        ribbit = Gdx.audio.newSound(Gdx.files.internal("ribbit.ogg"));
        robot = Gdx.audio.newSound(Gdx.files.internal("robot.mp3"));
        shoot = Gdx.audio.newSound(Gdx.files.internal("shoot.mp3"));

        banger = Gdx.audio.newMusic(Gdx.files.internal("banger.wav"));
        happy = Gdx.audio.newMusic(Gdx.files.internal("happy.wav"));

        // add the widgets

        Label title = new Label("The Super Fun Soundboard", skin);
        Label instructions = new Label("Click a button to hear a sound", skin);
        Label songs = new Label("Songs", skin);
        Label sounds = new Label("Sounds", skin);

        chimeButtom = new TextButton("Chime", skin);
        jumpButton = new TextButton("Jump", skin);
        ribbitButton = new TextButton("Ribbit", skin);
        robotButton = new TextButton("Robot", skin);
        shootButton = new TextButton("Gun", skin);

        bangerButton = new TextButton("An Absolute Banger", skin);
        happyButton = new TextButton("Happy Little Song", skin);

        stop = new TextButton("STOP", skin);

        table.columnDefaults(1);
        table.add(title).colspan(5);
        table.row();
        table.add(instructions).colspan(5);
        table.row();
        table.add(sounds).colspan(5);
        table.row().width(100);
        table.add(chimeButtom).width(50);
        table.add(jumpButton).width(50);
        table.add(ribbitButton).width(50);
        table.add(robotButton).width(50);
        table.add(shootButton).width(50);
        table.row();
        table.add(songs).colspan(50);
        table.row();
        table.add(bangerButton).colspan(2).width(150);
        table.add(new Label("", skin)).colspan(1).width(50);
        table.add(happyButton).colspan(2).width(150);
        table.row();
        table.add(new Label("", skin)).colspan(2);
        table.add(stop);

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

//        ScreenUtils.clear(0, 0, 0.1f, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        if (chimeButtom.isPressed()) chime.play();
        if (jumpButton.isPressed()) jump.play();
        if (ribbitButton.isPressed()) ribbit.play();
        if (robotButton.isPressed()) robot.play();
        if (shootButton.isPressed()) shoot.play();
        if (bangerButton.isPressed()) banger.play();
        if (happyButton.isPressed()) happy.play();
        if (stop.isPressed()) {
            banger.stop();
            happy.stop();
        }


    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        banger.dispose();
        happy.dispose();
    }
}
