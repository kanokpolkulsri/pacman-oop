package com.mygdx.game;

public class World {
    private Pacman pacman;
    private Maze maze;
    World(PacmanGame pacmanGame) {
    	pacman = new Pacman(60,60);
        maze = new Maze();
    }
 
    Pacman getPacman() {
        return pacman;
    }
 
    Maze getMaze() {
        return maze;
    }
    
    public void update(float delta) {
        pacman.update();
    }
}
