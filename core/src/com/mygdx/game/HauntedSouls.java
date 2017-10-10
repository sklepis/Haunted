package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Managers.GameStateManager;
import com.mygdx.game.States.MenuState;

public class HauntedSouls extends Game {

	public static int WIDTH;
	public static int HEIGHT;

	public static final String TITLE = "Haunted Souls";
	public static BitmapFont gameFont;
	private GameStateManager gsm;
	private SpriteBatch batch;
	public static Music music;


	@Override
	public void create ()
	{

		/* Music setup */

		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/intro.mp3"));
		music.setVolume((float) 0.3);
		music.play();
		music.setLooping(true);

		/* Current device screen resolution */

		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();

		/* Initializing application container and setting its default color */

		batch = new SpriteBatch();
		Gdx.gl.glClearColor(0, 0, 0, 1);

		/*  Intializing States stack manager */

		gsm = new GameStateManager();
		gsm.push(new MenuState(gsm));
	}

	/* This method is called whenever screen resize occurs */

	@Override
	public void resize(int width, int height)
	{
		gsm.resize(width, height);
	}

	/* This method is called number of times per second automatically */

	@Override
	public void render ()
	{
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}

	/* This method is callend when application is about to turn off
	*  Disposes game elements*/

	@Override
	public void dispose ()
	{
		batch.dispose();
		music.dispose();

	}
}
