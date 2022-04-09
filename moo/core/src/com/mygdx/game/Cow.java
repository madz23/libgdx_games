package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.File;

/** @author madz
 * Cows say MOOOOOOOO
 */


public class Cow {

    final CowGame game;

    private int height;
    private int width;

    private int topLim;
    private int leftLim;

    private int posX;
    private int posY;

    private float walkSpeed = 7;

    private Tummies tummies;

    private boolean flip;

    private Animation walkAnimation;
    private TextureRegion standAnimation;
    private Animation eatAnimation;

    private float stateTime;

    public Cow(final CowGame game, int height, int width, int topLim, int leftLim) {
        this.game = game;
        this.height = height;
        this.width = width;
        this.leftLim = leftLim;
        this.topLim = topLim;

        posX = 50;
        posY = 50;
        flip = false;

        stateTime = 0f;

        tummies = new Tummies(game, 4, 50, 50);

        String walk_file_name = "walk/walk%s.png";
        String eat_file_name = "eat/eat_%s.png";

        walkAnimation = new Animation<TextureRegion>((1 / walkSpeed), getAnimation(walk_file_name));
        eatAnimation = new Animation<TextureRegion>(.2f, getAnimation(eat_file_name));

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
        if (posX >= leftLim - width) { posX = leftLim - width; }
        if (posX <= 0) { posX = 0; }
        if (posY >= topLim - height) { posY = topLim - height; }
        if (posY <= 0) { posY = 0; }


    }

    public void eat() {
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion frame = (TextureRegion) eatAnimation.getKeyFrame(stateTime, true);
        game.batch.draw(frame, flip ? posX + width : posX, posY, flip ? -width : width, height);

        if (tummies.getFullTummies() < tummies.getMaxTummies()) { tummies.fillTummy(); }
    }

    public void stand() {
        stateTime += Gdx.graphics.getDeltaTime();
        game.batch.draw(standAnimation, flip ? posX + width : posX, posY, flip ? -width : width, height);
    }

    public void moo() {
        game.moo.play();
    }


    private TextureRegion[] getAnimation(String filepath) {

        File[] files = new File("walk").listFiles();
        assert files != null;
        TextureRegion[] frames = new TextureRegion[files.length];

        int count = 0;
        for (File file : files) {
            if (file.isFile()) {
                frames[count] = new TextureRegion(new Texture(String.format(filepath, count + 1)));
            }
            count += 1;
        }
        return frames;
    }

    public int getHeight() { return height; }

    public int getWidth() { return width; }

    public float getWalkSpeed() { return walkSpeed; }

    public void setWalkSpeed(int walkSpeed) { this.walkSpeed = walkSpeed; }

    public int getPosX() { return posX; }

    public int getPosY() { return posY; }

    public Tummies getTummies() { return tummies; }
}
