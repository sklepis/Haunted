package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HauntedSouls;
import com.mygdx.game.Objects.ScaleElement;

import java.util.HashMap;


/**
 * Created by cheapsoft on 10/8/2017.
 */

public class HighscoresState extends State {

    private int [] topScores;
    private Texture backButton;
    private TextureRegion  backButtonRegion;
    private GlyphLayout layout;

    private HashMap<String, ScaleElement> Sizes = new HashMap<String, ScaleElement>();

    public HighscoresState(com.mygdx.game.Managers.GameStateManager gsm) {
        super(gsm);

       // topScores = new int[5];
        setTextures();
        setFont();
        setHashMap();
    }

    @Override

    protected void handleInput() {
        if(Gdx.input.justTouched()) {

            Vector3 touchedCoordinates = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchedCoordinates);

            if(Sizes.get("Back").getRectangle().contains(touchedCoordinates.x,touchedCoordinates.y)) {
                gsm.set(new MenuState(gsm));
                dispose();
            }

        }

    }

    @Override
    public void update(float dt)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb)
    {

        camera.update();
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(backButton, Sizes.get("Back").position_X, Sizes.get("Back").position_Y, Sizes.get("Back").scaled_Width, Sizes.get("Back").scaled_Height);
        HauntedSouls.gameFont.getData().setScale(HauntedSouls.SCALE_W, HauntedSouls.SCALE_H);
        HauntedSouls.gameFont.draw(sb, "Highscores", Sizes.get("Highscores").position_X, Sizes.get("Highscores").position_Y);
        sb.end();

    }

    @Override
    public void dispose()
    {
        backButton.dispose();
    }

    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height);
    }

    /* Calculates written font resolution (the only one possible way is GlyphLayout) */

    public float calculateFontWidth(String text)
    {
        layout = new GlyphLayout();
        layout.setText(HauntedSouls.gameFont, text);
        return layout.width;
    }

    public float calculateFontHeight(String text)
    {
        layout = new GlyphLayout();
        layout.setText(HauntedSouls.gameFont, text);
        return layout.height;
    }

    private  void setHashMap ()
    {
        Sizes.put("Back", new ScaleElement(backButtonRegion, HauntedSouls.SCALE_W, HauntedSouls.SCALE_H, (float) 1.2, (float) 8));
        Sizes.put("Highscores", new ScaleElement(HauntedSouls.gameFont, HauntedSouls.SCALE_W,HauntedSouls.SCALE_H, calculateFontWidth("Highscores"), calculateFontHeight("Highscores"), (float) 1.1));

        Sizes.get("Back").calculateCustomPosition();
        Sizes.get("Highscores").calculateFontPosition();
    }

    public void setFont()
    {
        HauntedSouls.gameFont = new BitmapFont(Gdx.files.internal("fonts/gameFont.fnt"));
    }

    public void setTextures()
    {
        backButton = new Texture("backButton.png");
        backButtonRegion = new TextureRegion(backButton);
    }

}
