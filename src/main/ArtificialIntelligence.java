package main;

import agent.AgentMaze;
import environment.Maze;
import general.PositionXY;

public class ArtificialIntelligence {

	public static void main(String[] args) throws InterruptedException {
		
		Maze maze = new Maze(4);
		
		maze.showMaze();
		
		AgentMaze agent = new AgentMaze(maze);
		agent.setPosition(new PositionXY(2,2));
		
		while(agent.isNotEndEaten()) {
			agent.zeroStack();
			agent.move();
			maze.showMaze();
			Thread.sleep(1500);
		}
		return;

	}

}
