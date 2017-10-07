package com.mygdx.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.HauntedSouls;

/**
 * Created by dovydas on 10/6/2017,.
 */

public class MenuState extends State {

    private Texture startScreen;

    private TextureRegion background;
    private TextureRegion gameHeader;
    private TextureRegion playButton;
    private TextureRegion optionsButton;
    private TextureRegion exitButton;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        startScreen = new Texture("startScreenItems.png");
        background = new TextureRegion(startScreen, 1, 1, 1920, 1080);
        gameHeader = new TextureRegion(startScreen, 1, 1083, 942, 244);
        playButton = new TextureRegion(startScreen, 945, 1083, 257, 84);
        optionsButton = new TextureRegion(startScreen, 945, 1169, 462, 80);
        exitButton = new TextureRegion(startScreen, 945, 1251, 255, 73);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, HauntedSouls.WIDTH, HauntedSouls.HEIGHT);
        sb.draw(gameHeader, (HauntedSouls.WIDTH / 2 - gameHeader.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 1.5));
        sb.draw(playButton, (HauntedSouls.WIDTH / 2 - playButton.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 2.2));
        sb.draw(optionsButton, (HauntedSouls.WIDTH / 2 - optionsButton.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 3.0));
        sb.draw(exitButton, (HauntedSouls.WIDTH / 2 - exitButton.getRegionWidth() / 2), (float) (HauntedSouls.HEIGHT / 4.7));
        sb.end();

    }
}
