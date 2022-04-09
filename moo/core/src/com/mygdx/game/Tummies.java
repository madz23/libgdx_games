package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Tummies {

    final CowGame game;

    private Texture[] tum;
    private int fullTummies;
    private int maxTummies;

    private int height;
    private int width;
    private float posX;
    private float posY;

    public Tummies(final CowGame game, int maxTummies, int height, int width) {
        this.game = game;
        this.height = height;
        this.width = width;
        this.maxTummies = maxTummies;

        posX = 0;
        posY = 0;

        tum = new Texture[maxTummies];
        for (int i = 0; i < maxTummies; i++) {
            tum[i] = new Texture(Gdx.files.internal("empty_tum.png"));
        }
        fillTummy();
        fullTummies = 0;
    }

    public void fillTummy() {
        if (fullTummies < 4) {
            tum[fullTummies] = new Texture(Gdx.files.internal("full_tum.png"));
            fullTummies++;
        }
    }

    public void displayTummies() {
        float temX = posX;
        for (int i = 0; i < maxTummies; i++) {
            game.batch.draw(tum[i], temX, posY, width, height);
            temX += width;
        }
    }

    public Texture[] getTum() {
        return tum;
    }

    public int getFullTummies() {
        return fullTummies;
    }

    public int getMaxTummies() {
        return maxTummies;
    }

    public void setPosX(float posX) { this.posX = posX; }

    public void setPosY(float posY) { this.posY = posY; }

    public float getPosX() { return posX; }

    public float getPosY() { return posY; }

    public int getHeight() { return height; }

    public int getWidth() { return width; }
}
