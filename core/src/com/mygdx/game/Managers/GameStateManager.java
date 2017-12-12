package com.mygdx.game.Managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.States.State;

import java.util.Stack;

/**
 * Created by cheapsoft on 10/6/2017.
 * This class manages States, uses stack for proper States changing.
 */

public class GameStateManager {

    private Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();
    }

    public void push(State state) {
        states.push(state);
    }

    public void pop(){
        states.pop();
    }

    public void set(State state){
        states.pop();
        states.push(state);
    }

    public void update(float dt){
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }

    public void resize(int width, int height) {states.peek().resize(width, height);}
}
