package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HauntedSouls;


/**
 * Created by dovydas on 10/8/2017.
 */

public class HighscoresState extends State {

    private int [] topScores;
    private Texture backButton;

    public HighscoresState(GameStateManager gsm) {
        super(gsm);
        topScores = new int[5];
        backButton = new Texture("backButton.png");


    }

    @Override

    protected void handleInput() {
        if(Gdx.input.justTouched()) {

            Vector3 touchedCoordinates = new Vector3(Gdx.input.getX(), HauntedSouls.HEIGHT - Gdx.input.getY(), 0);
            Rectangle backButtonBounds = new Rectangle(
                                                       (float) (HauntedSouls.WIDTH / 1.2),
                                                        (float) (HauntedSouls.HEIGHT / 9),
                                                                    backButton.getWidth(),
                                                                    backButton.getHeight()
            );

            if(backButtonBounds.contains(touchedCoordinates.x,touchedCoordinates.y)) {
                gsm.set(new MenuState(gsm));
                dispose();
            }

        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {

        sb.begin();
        HauntedSouls.gameFont.getData().setScale((float) 0.8);
        HauntedSouls.gameFont.draw(sb, "Highscores", (float) (HauntedSouls.WIDTH / 3.5), (float) (HauntedSouls.HEIGHT / 1.1));
        sb.draw(backButton, (float) (HauntedSouls.WIDTH / 1.2), (float) (HauntedSouls.HEIGHT / 9));
        sb.end();

    }

    @Override
    public void dispose() {
        backButton.dispose();
    }
}
