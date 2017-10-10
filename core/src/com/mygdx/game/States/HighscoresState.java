package com.mygdx.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HauntedSouls;
import com.mygdx.game.Objects.ScaleElement;

import java.util.HashMap;


/**
 * Created by dovydas on 10/8/2017.
 */

public class HighscoresState extends State {

    private int [] topScores;
    private Texture backButton;
    private TextureRegion  backButtonRegion;
    private GlyphLayout layout;
   // public static BitmapFont gameFont;

    private HashMap<String, ScaleElement> Sizes = new HashMap<String, ScaleElement>();

    public HighscoresState(GameStateManager gsm) {
        super(gsm);

        topScores = new int[5];

        backButton = new Texture("backButton.png");
        backButtonRegion = new TextureRegion(backButton);


        HauntedSouls.gameFont = new BitmapFont(Gdx.files.internal("fonts/gameFont.fnt"));


        Sizes.put("Back", new ScaleElement(backButtonRegion, MenuState.scale_w, MenuState.scale_h, (float) 1.2, (float) 8));
        Sizes.put("Highscores", new ScaleElement(HauntedSouls.gameFont, MenuState.scale_w, MenuState.scale_h, calculateFontWidth("Highscores"), calculateFontHeight("Highscores"), (float) 1.1));

        Sizes.get("Back").calculateCustomPosition();
        Sizes.get("Highscores").calculateFontPosition();
    }

    @Override

    protected void handleInput() {
        if(Gdx.input.justTouched()) {

            Vector3 touchedCoordinates = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchedCoordinates);

            Rectangle backButtonBounds = MenuState.setRectangle(Sizes, "Back");


            if(backButtonBounds.contains(touchedCoordinates.x,touchedCoordinates.y)) {
                gsm.set(new MenuState(gsm));
            }

        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {

        camera.update();
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        sb.draw(backButton, Sizes.get("Back").Position_X, Sizes.get("Back").Position_Y, Sizes.get("Back").Scaled_Width, Sizes.get("Back").Scaled_Height);
        HauntedSouls.gameFont.getData().setScale(MenuState.scale_w, MenuState.scale_h);
        HauntedSouls.gameFont.draw(sb, "Highscores", Sizes.get("Highscores").Position_X, Sizes.get("Highscores").Position_Y);
        sb.end();

    }

    @Override
    public void dispose() {
        backButton.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public float calculateFontWidth(String text) {
        layout = new GlyphLayout();
        layout.setText(HauntedSouls.gameFont, text);
        return layout.width;
    }

    public float calculateFontHeight(String text) {
        layout = new GlyphLayout();
        layout.setText(HauntedSouls.gameFont, text);
        return layout.height;
    }
}
