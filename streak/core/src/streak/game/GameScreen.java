package streak.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;


/** @author: madz
 *  Welcome menu for the streak game
 */

public class GameScreen implements Screen {

    private final Skin skin;
    private Label title;
    private Label subTitle;
    private Table table;

    SimonButton button1;
    SimonButton button2;
    SimonButton button3;
    SimonButton button4;

    private int waitTime = 5;

    private final int buttonDim = 100;

    private Stage stage;

    public GameScreen(String skinPath, String soundPath) {

        skin = new Skin((Gdx.files.internal(skinPath)));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table(skin);
        table.setFillParent(true);

        title = new Label("Simon Says...", skin, "title-white");
        table.add(title);

        subTitle = new Label("A game to test your memory.", skin, "sub-title-white");
        table.row();
        table.add(subTitle);

        Table buttonTable = new Table();

        button1 = new SimonButton(skin, "button-1", soundPath + "/note-1.wav");
        button2 = new SimonButton(skin, "button-2", soundPath + "/note-2.wav");
        button3 = new SimonButton(skin, "button-3", soundPath + "/note-3.wav");
        button4 = new SimonButton(skin, "button-4", soundPath + "/note-4.wav");

        buttonTable.add(button1.getButton()).width(buttonDim).height(buttonDim);
        buttonTable.add(button2.getButton()).width(buttonDim).height(buttonDim);
        buttonTable.row();
        buttonTable.add(button4.getButton()).width(buttonDim).height(buttonDim);
        buttonTable.add(button3.getButton()).width(buttonDim).height(buttonDim);


//        button2 = new Button(skin, "button-2");
//        button2.setTransform(true);
//        buttonTable.add(button2).width(buttonDim).height(buttonDim);
//
//        buttonTable.row();
//
//        button3 = new Button(skin, "button-3");
//        button3.setTransform(true);
//        buttonTable.add(button3).width(buttonDim).height(buttonDim);
//
//        button4 = new Button(skin, "button-4");
//        button4.setTransform(true);
//        buttonTable.add(button4).width(buttonDim).height(buttonDim);

//        buttonTable.add(button1, button2, button3, button4);
//        buttonTable.setDebug(true);

        table.row();
        table.add(buttonTable).width(buttonDim);

        stage.addActor(table);


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // normal Libgdx stuff to draw the screen
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        // button renders

        if (button1.getButton().isPressed()) button1.play();
        if (button2.getButton().isPressed()) button2.play();
        if (button3.getButton().isPressed()) button3.play();
        if (button4.getButton().isPressed()) button4.play();
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
        stage.dispose();
    }

}
