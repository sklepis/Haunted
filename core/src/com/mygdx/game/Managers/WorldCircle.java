package com.mygdx.game.Managers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.mygdx.game.HauntedSouls;

/**
 * Created by cheapsoft on 11/19/2017.
 */

public class WorldCircle
{
    private Sprite deathSprite;
    private Circle deathArea;

    public WorldCircle()
    {
        Texture deathCircle = new Texture("death.png");
        deathSprite = new Sprite(deathCircle);
        deathSprite.setSize(deathCircle.getWidth()* HauntedSouls.SCALE_W, deathCircle.getWidth() * HauntedSouls.SCALE_H);
        deathSprite.setCenter(HauntedSouls.WIDTH/2, HauntedSouls.HEIGHT/2);

        deathArea = new Circle(HauntedSouls.WIDTH/2, HauntedSouls.HEIGHT/2, deathSprite.getHeight() / 2);
    }

    public Sprite getCircle()
    {
        //update();
        return deathSprite;
    }

    public boolean isPresent(float x, float y)
    {
        return deathArea.contains(x, y);
    }

    public void update()
    {
        //deathSprite.setSize((float)(deathSprite.getWidth() * 0.99999999999999999999999), (float) (deathSprite.getHeight() * 0.99999999999999999999999));
        //deathSprite.setScale((float)(deathSprite.getWidth() * 0.99), (float) (deathSprite.getHeight() * 0.99));
        //deathSprite.setCenter(HauntedSouls.WIDTH/2, HauntedSouls.HEIGHT/2);
    }
}
