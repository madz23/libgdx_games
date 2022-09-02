package streak.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.util.List;

/** @author: madz
 *  Welcome menu for the streak game
 */

public class GameScreen implements Screen {

    private Skin skin;
    private Label title;
    private Label subTitle;
    private Table table;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    private final int buttonDim = 100;

    private Stage stage;

    public GameScreen(String skinPath) {

        skin = new Skin((Gdx.files.internal(skinPath)));
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        table = new Table(skin);
        table.setFillParent(true);

        title = new Label("Streak", skin, "title-white");
        table.add(title);

        subTitle = new Label("A game to test your memory.", skin, "sub-title-white");
        table.row();
        table.add(subTitle);

        Table buttonTable = new Table();

        button1 = new Button(skin, "button-1");
        button1.setTransform(true);
        buttonTable.add(button1).width(buttonDim).height(buttonDim);

        button2 = new Button(skin, "button-2");
        button2.setTransform(true);
        buttonTable.add(button2).width(buttonDim).height(buttonDim);

        button3 = new Button(skin, "button-3");
        button3.setTransform(true);
        buttonTable.add(button3).width(buttonDim).height(buttonDim);

        button4 = new Button(skin, "button-4");
        button4.setTransform(true);
        buttonTable.add(button4).width(buttonDim).height(buttonDim);

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
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
