package com.zombie.animation.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class SelectionScreen implements Screen {

    final Animator animator;
    OrthographicCamera camera;
    RunningMan runningMan;

    public SelectionScreen(final Animator animator) {
        this.animator = animator;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 600);

        runningMan = new RunningMan(this);
    }



    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        animator.batch.setProjectionMatrix(camera.combined);

        animator.batch.begin();
        animator.font.draw(animator.batch, "This is the running man animator", 500, 300);
        animator.batch.end();

        if (Gdx.input.isTouched()) {
            runningMan.render();
            dispose();
        }

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
