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

    private Sound moo;

    private float stateTime;

    public Cow(final CowGame game, int height, int width) {
        this.game = game;
        this.height = height;
        this.width = width;

        posX = 50;
        posY = 50;
        flip = false;

        stateTime = 0f;

        moo = Gdx.audio.newSound(Gdx.files.internal("sounds/moo.ogg"));

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
        walkAnimation = new Animation<TextureRegion>(.3f, walkFrames);
        standAnimation = new TextureRegion(new Texture(Gdx.files.internal("cow_stand.png")));
    }

    public void walk() {
        game.batch.begin();

        stateTime += Gdx.graphics.getDeltaTime();
        // Get current frame of animation for the current stateTime
        TextureRegion frame = (TextureRegion) walkAnimation.getKeyFrame(stateTime, true);
        game.batch.draw(frame, flip ? posX + width : posX, posY, flip ? -width : width, height);
        // https://stackoverflow.com/questions/28000623/libgdx-flip-2d-sprite-animation/28000689#28000689

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            flip = false;
            posX += walkSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            flip = true;
            posX -= walkSpeed;
        }
        if (posX >= Gdx.graphics.getWidth() - width) { posX = Gdx.graphics.getWidth() - width; }
        if (posX <= 0) { posX = 0; }


        game.batch.end();
    }

    public void stand() {
        game.batch.begin();

        stateTime += Gdx.graphics.getDeltaTime();
        game.batch.draw(standAnimation, flip ? posX + width : posX, posY, flip ? -width : width, height);

        game.batch.end();
    }

    public void moo() {
        moo.play();
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public int getWalkSpeed() { return walkSpeed; }

    public void setWalkSpeed(int walkSpeed) { this.walkSpeed = walkSpeed; }

    public int getPosX() { return posX; }

    public int getPosY() { return posY; }
}
