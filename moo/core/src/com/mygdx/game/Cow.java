package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.File;

public class Cow {

    final CowGame game;

    private int height;
    private int width;

    private int posX;
    private int posY;

    private int walkSpeed = 6;
    private boolean flip;

    private Animation walkAnimation;
    private TextureRegion standAnimation;

    private float stateTime;

    public Cow(final CowGame game, int height, int width) {
        this.game = game;
        this.height = height;
        this.width = width;

        posX = 50;
        posY = 50;
        flip = false;

        stateTime = 0f;

        TextureRegion[] walkFrames = new TextureRegion[8];

        String file_name = "walk/walk%s.png";
        File[] files = new File("walk").listFiles();

        int count = 0;
        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                walkFrames[count] = new TextureRegion(new Texture(String.format(file_name, count + 1)));
            }
            count += 1;
        }
        walkAnimation = new Animation<TextureRegion>(.2f, walkFrames);
        standAnimation = new TextureRegion(new Texture(Gdx.files.internal("cow_stand.png")));
    }

    public void walk() {

        stateTime += Gdx.graphics.getDeltaTime();
        // Get current frame of animation for the current stateTime
        TextureRegion frame = (TextureRegion) walkAnimation.getKeyFrame(stateTime, true);
        game.batch.draw(frame, flip ? posX + width : posX, posY, flip ? -width : width, height);
        // https://stackoverflow.com/questions/28000623/libgdx-flip-2d-sprite-animation/28000689#28000689

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            flip = false;
            posX += walkSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            flip = true;
            posX -= walkSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) {
            posY += walkSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) {
            posY -= walkSpeed;
        }
        if (posX >= Gdx.graphics.getWidth() - width) { posX = Gdx.graphics.getWidth() - width; }
        if (posX <= 0) { posX = 0; }
        if (posY >= Gdx.graphics.getHeight() - height) { posY = Gdx.graphics.getHeight() - height; }
        if (posY <= 0) { posY = 0; }


    }

    public void stand() {

        stateTime += Gdx.graphics.getDeltaTime();
        game.batch.draw(standAnimation, flip ? posX + width : posX, posY, flip ? -width : width, height);

    }

    public void moo() {
        game.moo.play();
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public int getWalkSpeed() { return walkSpeed; }

    public void setWalkSpeed(int walkSpeed) { this.walkSpeed = walkSpeed; }

    public int getPosX() { return posX; }

    public int getPosY() { return posY; }
}
