package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer extends ScreenAdapter {
	private Texture pacmanImg;
    private PacmanGame pacmanGame;
    private Pacman pacman;
    private SpriteBatch batch;
    private MazeRenderer mazeRenderer;
    
	public WorldRenderer(PacmanGame pacmanGame, World world) {
        this.pacmanGame = pacmanGame;
        batch = this.pacmanGame.batch;
        pacmanImg = new Texture("pacman.png");
        pacman = world.getPacman();
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
    }
	
	@Override
	public void render(float delta) {
		mazeRenderer.render();
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Vector2 pos = pacman.getPosition();
        batch.begin();
        batch.draw(pacmanImg, pos.x, pos.y);
        batch.end();
    }
}


