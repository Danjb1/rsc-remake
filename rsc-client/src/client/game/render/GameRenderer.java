package client.game.render;

import client.Canvas;
import client.StateRenderer;
import client.game.Game;
import client.game.scene.Scene;
import client.game.world.World;

/**
 * Class responsible for rendering the game.
 *
 * <p>The general idea is:
 *
 * <ul>
 *  <li>Build the scene</li>
 *  <li>Tell the SoftwareRenderer to render the scene</li>
 *  <li>Draw the UI on top</li>
 * </ul>
 *
 * @author Dan Bryce
 */
public class GameRenderer extends StateRenderer {

    private World world;
    private SceneBuilder sceneBuilder;
    private Scene scene;

    private SoftwareRenderer softwareRenderer;
    private MousePicker mousePicker;

    private MenuBarRenderer menuRenderer;

    public GameRenderer(Game game) {

        world = game.getWorld();
        scene = game.getScene();

        sceneBuilder = new SceneBuilder(scene, world);
        softwareRenderer = new SoftwareRenderer(scene,
                game.getLauncher().getWidth(),
                game.getLauncher().getHeight());
        mousePicker = softwareRenderer.getMousePicker();

        menuRenderer = new MenuBarRenderer(game);
    }

    @Override
    public void render(Canvas canvas) {
        renderWorld(canvas);
        renderUi(canvas);
    }

    private void renderWorld(Canvas canvas) {

        // Don't render until the world is loaded
        if (!world.isLoaded()) {
            return;
        }

        // Render the scene
        sceneBuilder.build();
        softwareRenderer.render(canvas);
    }

    public MousePicker getMousePicker() {
        return mousePicker;
    }

    private void renderUi(Canvas canvas) {
        menuRenderer.render(canvas);
    }

}
