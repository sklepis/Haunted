package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.HauntedSouls;

/**
 * Created by cheapsoft on 10/9/2017.
 */

public class ScaleElement
{
    public TextureRegion savedReference;
    public BitmapFont savedFontReference;
    public float scaled_Width;
    public float scaled_Height;
    public float position_X;
    public float position_Y;

    private float positionScale_w;
    private float positionScale_h;

    /* Constructor for centered position screen computability (TexturesRegions) */

    public ScaleElement(TextureRegion reference, float scale_w, float scale_h, float value_h)
    {
        savedReference = reference;
        scaled_Width = reference.getRegionWidth() * scale_w;
        scaled_Height = reference.getRegionHeight() * scale_h;
        positionScale_h = value_h;
    }

    /* Constructor for custom position screen computability (TextureRegions) */

    public ScaleElement(TextureRegion reference, float scale_w, float scale_h, float value_w, float value_h)
    {
        savedReference = reference;
        scaled_Width = reference.getRegionWidth() * scale_w;
        scaled_Height = reference.getRegionHeight() * scale_h;
        positionScale_w = value_w;
        positionScale_h = value_h;
    }

      /* Constructor for centered position screen computability (BitmapFonts) */

    public ScaleElement(BitmapFont font, float scale_w, float scale_h, float width, float height, float default_scale_h)
    {

        savedFontReference = font;
        scaled_Width =  width * scale_w;
        scaled_Height = height * scale_h;
        positionScale_h = default_scale_h;

    }

    /* Calculating centered screen position (TextureRegions) */

    public void calculateCenteredPosition()
    {
        position_X = HauntedSouls.WIDTH / 2 - scaled_Width / 2;
        position_Y = HauntedSouls.HEIGHT / positionScale_h - (scaled_Height / positionScale_h) / 2;
    }

    /* Calculating custom screen position (TextureRegions) */

    public void calculateCustomPosition()
    {
        position_X = HauntedSouls.WIDTH / positionScale_w - (scaled_Width / positionScale_w) / 2;
        position_Y = HauntedSouls.HEIGHT / positionScale_h - (scaled_Height / positionScale_h) /2;
    }

    /* Calculating centered screen position (TextureRegions) */

    public void calculateFontPosition()
    {
        position_X = HauntedSouls.WIDTH / 2 - scaled_Width / 2;
        position_Y = HauntedSouls.HEIGHT / positionScale_h - (scaled_Height / positionScale_h) / 2;
    }

    /* Creates rectangle using given scaled parameters */

    public Rectangle getRectangle ()
    {

        Rectangle rectangle = new Rectangle (
                                              position_X,
                                              position_Y,
                                              scaled_Width,
                                              scaled_Height
        );
        return rectangle;
    }
}
