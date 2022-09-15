package streak.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * @author: madz
 * This will hold some methods for the buttons to make this easier
 */

public class SimonButton {

    private Button button;
    private Sound sound;

    public SimonButton(Skin skin, String style, String soundPath) {
        sound = Gdx.audio.newSound(Gdx.files.internal(soundPath));

        button = new Button(skin, style);
        button.setTransform(true);
    }

    public void play() { sound.play(); }

    public Button getButton() { return button; }
}
