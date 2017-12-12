package com.mygdx.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.HauntedSouls;

import java.util.Random;

/**
 * Created by cheapsoft on 10/11/2017.
 */

public class Ghost
{
    private TextureRegion image;
    private Sprite ghostSprite;

    public double direction_x = 0;
    public double direction_y = 0;

    public Ghost(TextureRegion image) {
        this.image = image;
        ghostSprite = new Sprite(image);
        ghostSprite.setSize(image.getRegionWidth()* HauntedSouls.SCALE_W, image.getRegionHeight() * HauntedSouls.SCALE_H);
        ghostSprite.setCenter(HauntedSouls.WIDTH/2, HauntedSouls.HEIGHT/2);

        //final double degree = Math.toRadians(Math.random() * 360);
        direction_x = new Random().nextFloat() * 2 - 1;
        direction_y = new Random().nextFloat() * 2 - 1;
        Gdx.app.log("Dovydo zaidimas", "Naujas NPC; X: " + direction_x + " Y: " + direction_y);
    }

    public Sprite getGhostSprite() {

        return ghostSprite;
    }

    public Rectangle getRectangle ()
    {
        Rectangle rectangle = new Rectangle (
            ghostSprite.getX(),
            ghostSprite.getY(),
            ghostSprite.getWidth(),
            ghostSprite.getHeight()
        );
        return rectangle;
    }
}
