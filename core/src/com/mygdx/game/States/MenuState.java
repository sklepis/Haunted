package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HauntedSouls;
import com.mygdx.game.Objects.ScaleElement;

import java.util.HashMap;
import java.util.Map;

import static com.badlogic.gdx.Gdx.app;

/**
 * Created by dovydas on 10/6/2017,.
 */

public class MenuState extends State {

    private Texture startScreen;

    private TextureRegion background;
    private TextureRegion gameHeader;
    private TextureRegion playButton;
    private TextureRegion scoresButton;
    private TextureRegion optionsButton;
    private TextureRegion exitButton;

    private HashMap<String, ScaleElement> Sizes = new HashMap<String, ScaleElement>();

    public static float scale_w;
    public static float scale_h;
    public static float background_default_w;
    public static float background_default_h;


    public MenuState(GameStateManager gsm)
    {
        super(gsm);
        startScreen = new Texture("startScreenItems.png");
        background = new TextureRegion(startScreen, 1, 1, 1920, 1080);
        gameHeader = new TextureRegion(startScreen, 1, 1083, 942, 244);
        playButton = new TextureRegion(startScreen, 945, 1169, 257, 84);
        scoresButton = new TextureRegion(startScreen, 945, 1083, 627, 84);
        optionsButton = new TextureRegion(startScreen, 1204, 1169, 462, 80);
        exitButton = new TextureRegion(startScreen, 1204, 1251, 255, 73);

        scale_w = ( (float)HauntedSouls.WIDTH / (float) background.getRegionWidth());
        scale_h = ( (float) HauntedSouls.HEIGHT / (float) background.getRegionHeight());

        Sizes.put("Header", new ScaleElement(gameHeader, scale_w, scale_h, (float) 1.3));
        Sizes.put("Play", new ScaleElement(playButton, scale_w, scale_h, (float) 2));
        Sizes.put("Scores", new ScaleElement(scoresButton, scale_w, scale_h, (float) 2.8));
        Sizes.put("Options", new ScaleElement(optionsButton, scale_w, scale_h, 4));
        Sizes.put("Exit", new ScaleElement(exitButton, scale_w, scale_h, 7));

        for (Map.Entry<String, ScaleElement> se : Sizes.entrySet())
        {
            se.getValue().calculateCenteredPosition();
        }

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            Vector3 touchedCoordinates = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchedCoordinates);

            Rectangle playButtonBounds = setRectangle(Sizes, "Play");
            Rectangle scoresButtonBounds = setRectangle(Sizes, "Scores");
            Rectangle optionsButtonBounds = setRectangle(Sizes, "Options");
            Rectangle exitButtonBounds = setRectangle(Sizes, "Exit");

            if(playButtonBounds.contains(touchedCoordinates.x,touchedCoordinates.y)) {
                 gsm.set(new PlayState(gsm));
                 dispose();
            }
            else if(scoresButtonBounds.contains(touchedCoordinates.x, touchedCoordinates.y)) {
                gsm.set(new HighscoresState(gsm));
              //  dispose();
            }
            else if(optionsButtonBounds.contains(touchedCoordinates.x, touchedCoordinates.y)) {
                // gsm.set(new PlayState(gsm));
                // dispose();
            }
            else if(exitButtonBounds.contains(touchedCoordinates.x, touchedCoordinates.y))
                app.exit();


        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void update(float dt) {
        handleInput();
        camera.update();


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(background, 0, 0, HauntedSouls.WIDTH, HauntedSouls.HEIGHT);

        for (Map.Entry<String, ScaleElement> se : Sizes.entrySet())
        {
                final ScaleElement details = se.getValue();
                sb.draw(details.SavedReference, details.Position_X, details.Position_Y, details.Scaled_Width, details.Scaled_Height);

        }

        sb.end();

    }

    public static Rectangle setRectangle(HashMap<String, ScaleElement> Sizes, String key) {

        Rectangle rectangle = new Rectangle (
                                    Sizes.get(key).Position_X,
                                    Sizes.get(key) .Position_Y,
                                    Sizes.get(key).Scaled_Width,
                                    Sizes.get(key).Scaled_Height
        );
        return rectangle;
    }

    @Override
    public void dispose() {
        startScreen.dispose();
        background.getTexture().dispose();
        gameHeader.getTexture().dispose();
        playButton.getTexture().dispose();
        optionsButton.getTexture().dispose();
        exitButton.getTexture().dispose();
    }
}
