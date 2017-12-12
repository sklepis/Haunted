package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.HauntedSouls;
import com.mygdx.game.Managers.GhostsManager;

import java.util.ArrayList;

/**
 * Created by cheapsoft on 10/11/2017.
 */

public class World {

    private Texture worldBackground;
    private GhostsManager manager;
    private ArrayList<Ghost> ghosts;

    public World(GhostsManager manager) {
        this.manager = manager;
        worldBackground = new Texture("background.png");
       // worldBackground.set

    }

    public void spawnGhosts(SpriteBatch sb) {
        for(int i = 0; i < ghosts.size(); i++) {
            int random_w = (int )(Math.random() * HauntedSouls.WIDTH + 1);
            int random_h = (int )(Math.random() * HauntedSouls.HEIGHT + 1);
            ghosts.get(i).getGhostSprite().setCenter(random_w, random_h);
            ghosts.get(i).getGhostSprite().draw(sb);
        }

    }


}
