package com.mygdx.game.Managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by cheapsoft on 11/4/2017.
 */

public class Assets {

    public static BitmapFont gameFont;
    public static Music music;

    public static void load () {

        	/* Music load & setup */

        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/intro.mp3"));
        music.setVolume((float) 0.3);
        music.play();
        music.setLooping(true);

         /* Font setup */

        gameFont = new BitmapFont(Gdx.files.internal("fonts/gameFont.fnt"));






    }
}
