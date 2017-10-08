package com.mygdx.game.States;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by dovydas on 10/7/2017.
 */

public class PlayState extends State {

    private Texture ghosts;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
       // sb.begin();
       // sb.end();

    }

    @Override
    public void dispose() {

    }
}
