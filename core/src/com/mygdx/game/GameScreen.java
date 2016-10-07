package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;

public class GameScreen extends ScreenAdapter {
	private Pacman pacman;
    World world;
    WorldRenderer worldRenderer;
    public GameScreen(PacmanGame pacmanGame) {
    	new Texture("pacman.png");
    	world = new World(pacmanGame);
    	pacman = world.getPacman();
    	worldRenderer = new WorldRenderer(pacmanGame, world);
    }
    
    @Override
    public void render(float delta) {
    	update(delta);
        worldRenderer.render(delta);
    }
    
    private void update(float delta) {
    	updatePacmanDirection();
        world.update(delta);
    }
    
    private void updatePacmanDirection() {
    	Pacman pacman = world.getPacman();
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            pacman.setNextDirection(Pacman.DIRECTION_UP);
        }
        else if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            pacman.setNextDirection(Pacman.DIRECTION_DOWN);
        }
        else if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
        }
        else if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            pacman.setNextDirection(Pacman.DIRECTION_LEFT);
        }
        else{
        	pacman.setNextDirection(Pacman.DIRECTION_STILL);
        }  
    }

}
