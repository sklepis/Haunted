package com.mygdx.game.States;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Managers.GhostsManager;
import com.mygdx.game.Objects.Ghost;

/**
 * Created by cheapsoft on 10/7/2017.
 */

public class PlayState extends State {


    private Texture background;
    private Texture xt_ghosts;
    private GhostsManager manager;


    private Ghost red_ghost;
    private Ghost blue_ghost;
    private Ghost yellow_ghost;
    private Ghost green_ghost;


    public PlayState(com.mygdx.game.Managers.GameStateManager gsm)
    {
        super(gsm);

        background = new Texture("background.png");
        xt_ghosts = new Texture("ghosts.png");
        red_ghost = new Ghost (new TextureRegion(xt_ghosts, 0, 0, 128, 128));
        blue_ghost = new Ghost (new TextureRegion(xt_ghosts, 128, 0, 128, 128));
        yellow_ghost = new Ghost (new TextureRegion(xt_ghosts, 256, 0, 128, 128));
        green_ghost = new Ghost (new TextureRegion(xt_ghosts, 384, 0, 128, 128));



    }

    @Override
    protected void handleInput() {

        if(Gdx.input.isTouched())
        {
            Vector3 touchedCoordinates = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchedCoordinates);
            if(red_ghost.getRectangle().contains(touchedCoordinates.x,touchedCoordinates.y))
            {
                red_ghost.getGhostSprite().setCenter(touchedCoordinates.x,touchedCoordinates.y);
            }
            else if(blue_ghost.getRectangle().contains(touchedCoordinates.x,touchedCoordinates.y))
            {
                blue_ghost.getGhostSprite().setCenter(touchedCoordinates.x,touchedCoordinates.y);
            }
            else if(yellow_ghost.getRectangle().contains(touchedCoordinates.x,touchedCoordinates.y))
            {
                yellow_ghost.getGhostSprite().setCenter(touchedCoordinates.x,touchedCoordinates.y);
            }
            else if(green_ghost.getRectangle().contains(touchedCoordinates.x,touchedCoordinates.y))
            {
                green_ghost.getGhostSprite().setCenter(touchedCoordinates.x,touchedCoordinates.y);
            }

        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0, 0);

        red_ghost.getGhostSprite().draw(sb);
        blue_ghost.getGhostSprite().draw(sb);
        yellow_ghost.getGhostSprite().draw(sb);
        green_ghost.getGhostSprite().draw(sb);

        red_ghost.getGhostSprite().translate(1,1);
        blue_ghost.getGhostSprite().translate(1,0);
        yellow_ghost.getGhostSprite().translate(0,1);
        green_ghost.getGhostSprite().translate(1,2);
        sb.end();
    }

    @Override
    public void dispose()
    {
//        for (Ghost ghost : manager.getGhostsList())
//        {
//            ghost.getGhostSprite().getTexture().dispose();
//        }

    }

    @Override
    public void resize(int width, int height) {

    }
}
