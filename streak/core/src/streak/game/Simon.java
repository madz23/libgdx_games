package streak.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * @author: madz
 * This is the main class that will actually be run
 */

public class Simon extends Game {
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();

		this.setScreen(new GameScreen("skins/test-skin-3/test-skin-3.json", "sounds/guitar"));
	}

	@Override
	public void render () { super.render(); }
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
