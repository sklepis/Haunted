package com.mygdx.game.Managers;

import com.mygdx.game.Objects.Ghost;

import java.util.ArrayList;

/**
 * Created by cheapsoft on 10/11/2017.
 * Manages ghosts movements and interactions
 *
 * Game difficulty:
 *  Level 1  -> 5 ghosts at the same time
 *  Level 2  -> 7 ghosts at the same time
 *  Level 3  -> 10 ghosts at the same time
 *
 */

public class GhostsManager
{
    private ArrayList<Ghost> ghosts;
    private int level;


    public GhostsManager (int level) {

        ghosts = new ArrayList<Ghost>();
        this.level = level;

    }


    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    //    public void spawnGhosts()
//    {
//        int spawn = 0;
//
//        switch (setDifficulty) {
//            case EASY:
//                spawn = 5;
//                break;
//            case MEDIUM:
//                spawn = 7;
//                break;
//            case HARD:
//                spawn = 10;
//                break;
//            default:
//                spawn = 0;
//        }
//
//        for (int i = 1; i <= spawn; i++)
//        {
//            ghostsList.add(new Ghost(getRandomType()));
//        }
//    }


//    public enum Difficulty
//    {
//        EASY,
//        MEDIUM,
//        HARD
//    }
//
//    public enum Type
//    {
//        RED,
//        BLUE,
//        YELLOW,
//        GREEN
//    }
//
//    public static final Texture xt_ghosts = new Texture("ghosts.png");
//
//    private ArrayList<Ghost> ghostsList;
//
//    private Difficulty setDifficulty;
//
//
//    public GhostsManager(Difficulty difficulty)
//    {
//        ghostsList = new ArrayList<Ghost>();
//        setDifficulty = difficulty;
//        spawnGhosts();
//    }
//
//    public void spawnGhosts()
//    {
//        int spawn = 0;
//
//        switch (setDifficulty) {
//            case EASY:
//                spawn = 5;
//                break;
//            case MEDIUM:
//                spawn = 7;
//                break;
//            case HARD:
//                spawn = 10;
//                break;
//            default:
//                spawn = 0;
//        }
//
//        for (int i = 1; i <= spawn; i++)
//        {
//            ghostsList.add(new Ghost(getRandomType()));
//        }
//    }
//
//    /*
//    public static final TextureRegion red_ghost = new TextureRegion(xt_ghosts, 0, 0, 128, 128);
//    public static final TextureRegion blue_ghost = new TextureRegion(xt_ghosts, 128, 0, 128, 128);
//    public static final TextureRegion yellow_ghost = new TextureRegion(xt_ghosts, 256, 0, 128, 128);
//    public static final TextureRegion green_ghost = new TextureRegion(xt_ghosts, 384, 0, 128, 128);
//    */
//
//    private TextureRegion getRandomType()
//    {
//        float probability = new Random().nextFloat();
//
//        if (probability <= 0.1)
//            return new TextureRegion(xt_ghosts, 0, 0, 128, 128);
//        if (probability > 0.1 && probability <= 0.4)
//            return new TextureRegion(xt_ghosts, 384, 0, 128, 128);
//        if (probability > 0.4 && probability <= 0.9)
//            return new TextureRegion(xt_ghosts, 256, 0, 128, 128);
//
//
//        return new TextureRegion(xt_ghosts, 128, 0, 128, 128);
//    }
//
//    public ArrayList<Ghost> getGhostsList() {
//        return ghostsList;
//    }
}