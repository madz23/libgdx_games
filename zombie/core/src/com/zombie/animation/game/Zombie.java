package com.zombie.animation.game;

import static com.badlogic.gdx.math.MathUtils.floor;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import java.io.File;

public class Zombie implements ApplicationListener {
    
    final SelectionScreen screen;


    Animation<TextureRegion> walkAnimation;
    Texture walkSheet;
    SpriteBatch spriteBatch;



    float stateTime;

    public Zombie(final SelectionScreen screen) {
        this.screen = screen;

        TextureRegion[] walkFrames = new TextureRegion[10];

        String file_name = "zombie_walk/walk%s.png";
        File[] files = new File("zombie_walk").listFiles();

        int count = 0;
        for (File file : files) {
            if (file.isFile()) {
                walkFrames[count] = new TextureRegion(new Texture(String.format(file_name, count + 1)));
            }
            count += 1;
        }
        walkAnimation = new Animation<TextureRegion>(0.075f, walkFrames);

        spriteBatch = new SpriteBatch();
        stateTime = 0f;
        
    }
    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        spriteBatch.begin();
        spriteBatch.draw(currentFrame, 50, 50); // Draw current frame at (50, 50)

        spriteBatch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    @Override
    public void dispose() {
        spriteBatch.dispose();
        walkSheet.dispose();
    }


}
