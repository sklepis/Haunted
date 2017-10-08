package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HauntedSouls;

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

    public MenuState(GameStateManager gsm) {
        super(gsm);
        startScreen = new Texture("startScreenItems.png");
        background = new TextureRegion(startScreen, 1, 1, 1920, 1080);
        gameHeader = new TextureRegion(startScreen, 1, 1083, 942, 244);
        playButton = new TextureRegion(startScreen, 945, 1169, 257, 84);
        scoresButton = new TextureRegion(startScreen, 945, 1083, 627, 84);
        optionsButton = new TextureRegion(startScreen, 1204, 1169, 462, 80);
        exitButton = new TextureRegion(startScreen, 1204, 1251, 255, 73);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            Vector3 touchedCoordinates = new Vector3(Gdx.input.getX(), HauntedSouls.HEIGHT - Gdx.input.getY(), 0);


            Rectangle playButtonBounds = new Rectangle(
                                                       (HauntedSouls.WIDTH / 2 - playButton.getRegionWidth() / 2),
                                                                                (float) (HauntedSouls.HEIGHT / 2),
                                                                                      playButton.getRegionWidth(),
                                                                                      playButton.getRegionHeight()
            );
            Rectangle scoresButtonBounds = new Rectangle(
                                                         (HauntedSouls.WIDTH / 2 - scoresButton.getRegionWidth() / 2),
                                                                                  (float) (HauntedSouls.HEIGHT / 2.8),
                                                                                        scoresButton.getRegionWidth(),
                                                                                        scoresButton.getRegionHeight()
            );
            Rectangle optionsButtonBounds = new Rectangle(
                                                          (HauntedSouls.WIDTH / 2 - optionsButton.getRegionWidth() / 2),
                                                                                    (float) (HauntedSouls.HEIGHT / 4.0),
                                                                                         optionsButton.getRegionWidth(),
                                                                                         optionsButton.getRegionHeight()
            );
            Rectangle exitButtonBounds = new Rectangle(
                                                       (HauntedSouls.WIDTH / 2 - exitButton.getRegionWidth() / 2),
                                                                              (float) (HauntedSouls.HEIGHT / 7.0),
                                                                                      exitButton.getRegionWidth(),
                                                                                      exitButton.getRegionHeight()
            );

            if(playButtonBounds.contains(touchedCoordinates.x,touchedCoordinates.y)) {
                 gsm.set(new PlayState(gsm));
                 dispose();
            }
            else if(scoresButtonBounds.contains(touchedCoordinates.x, touchedCoordinates.y)) {
                gsm.set(new HighscoresState(gsm));
                dispose();
            }
            else if(optionsButtonBounds.contains(touchedCoordinates.x, touchedCoordinates.y)) {
                // gsm.set(new PlayState(gsm));
                // dispose();
            }
            else if(exitButtonBounds.contains(touchedCoordinates.x, touchedCoordinates.y))
                Gdx.app.exit();

           // console logging
          // Gdx.app.log("Touchpoint", "Input occurred at x=" + Gdx.input.getX() + ", y=" +  Gdx.input.getY());

        }
    }

    @Override
    public void update(float dt) {
        handleInput();


    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, HauntedSouls.WIDTH, HauntedSouls.HEIGHT);
        sb.draw(gameHeader, (HauntedSouls.WIDTH / 2 - gameHeader.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 1.3));
        sb.draw(playButton, (HauntedSouls.WIDTH / 2 - playButton.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 2));
        sb.draw(scoresButton, (HauntedSouls.WIDTH / 2 - scoresButton.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 2.8));
        sb.draw(optionsButton, (HauntedSouls.WIDTH / 2 - optionsButton.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 4.0));
        sb.draw(exitButton, (HauntedSouls.WIDTH / 2 - exitButton.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 7.0));
        sb.end();

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
