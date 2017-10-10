package com.mygdx.game.Objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.HauntedSouls;

/**
 * Created by dovydas on 10/9/2017.
 */

public class ScaleElement
{
    public TextureRegion SavedReference;
    public BitmapFont SavedFontReference;
    public float Scaled_Width;
    public float Scaled_Height;
    public float Position_X;
    public float Position_Y;

    private float PositionScale_w;
    private float PositionScale_h;


    public ScaleElement(TextureRegion reference, float scale_w, float scale_h, float value_h)
    {
        SavedReference = reference;
        Scaled_Width = reference.getRegionWidth() * scale_w;
        Scaled_Height = reference.getRegionHeight() * scale_h;
        PositionScale_h = value_h;
    }
    public ScaleElement(TextureRegion reference, float scale_w, float scale_h, float value_w, float value_h)
    {
        SavedReference = reference;
        Scaled_Width = reference.getRegionWidth() * scale_w;
        Scaled_Height = reference.getRegionHeight() * scale_h;
        PositionScale_w = value_w;
        PositionScale_h = value_h;
    }

    public ScaleElement(BitmapFont font, float scale_w, float scale_h, float width, float height, float default_scale_h) {

        SavedFontReference = font;
        Scaled_Width =  width * scale_w;
        Scaled_Height = height * scale_h;
        // PositionScale_w = default_scale_w;
        PositionScale_h = default_scale_h;

    }

    public void calculateCenteredPosition()
    {
        Position_X = HauntedSouls.WIDTH / 2 - Scaled_Width / 2;
        Position_Y = HauntedSouls.HEIGHT / PositionScale_h - (Scaled_Height / PositionScale_h) / 2;
    }

    public void calculateCustomPosition()
    {
        Position_X = HauntedSouls.WIDTH / PositionScale_w - (Scaled_Width / PositionScale_w) / 2;
        Position_Y = HauntedSouls.HEIGHT / PositionScale_h - (Scaled_Height / PositionScale_h) /2;
    }

    public void calculateFontPosition()
    {
        Position_X = HauntedSouls.WIDTH / 2 - Scaled_Width / 2;
        Position_Y = HauntedSouls.HEIGHT / PositionScale_h - (Scaled_Height / PositionScale_h) / 2;
    }
}
