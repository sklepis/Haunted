package com.mygdx.game.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.HauntedSouls;

/**
 * Created by dovydas on 10/6/2017.
 * This class is template for every State used in game.
 */

public abstract class State
{
    OrthographicCamera camera;
    Viewport viewport;
    protected Vector3 mouse;
    com.mygdx.game.Managers.GameStateManager gsm;

    State(com.mygdx.game.Managers.GameStateManager gsm)
    {
        this.gsm = gsm;
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        viewport = new FitViewport(HauntedSouls.WIDTH, HauntedSouls.HEIGHT, camera);
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render (SpriteBatch sb);
    public abstract void dispose();
    public abstract void resize(int width, int height);
}
