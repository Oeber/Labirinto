package environment;

import agent.AgentMaze;
import general.PositionXY;

public class Maze {
	
	private int mazeSize;
	
	private String[][] maze;
	
	private AgentMaze agent;
	
	public Maze(int mazeSize) {
		this.mazeSize = mazeSize;
		this.buildNewMaze();
	}
	
	private void buildNewMaze() {
		maze = new String[this.mazeSize][this.mazeSize];
		for (int i = 0; i < this.mazeSize; i++) {
			for (int j = 0; j < this.mazeSize; j++) {
				this.maze[i][j] = "C";
			}
		}
	}
	
	public void showMaze() {
		updatePositionAgent();
		for (int i = 0; i < mazeSize; i++) {
			for (int j = 0; j < mazeSize; j++) {
				if(maze[i][j].equals("*A*")) {
					System.out.print("|" + maze[i][j] + "|");
				}else {
					System.out.print("| " + maze[i][j] + " |");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private void updatePositionAgent() {
		if(this.agent != null) {
			PositionXY posAgent = this.agent.getPosition();
			
			maze[posAgent.getPosX()][posAgent.getPosY()] = "*A*";
		}
		
	}

	public int getMazeSize() {
		return mazeSize;
	}
	
	public String returnValuePositionMaze(PositionXY position) {
		return this.maze[position.getPosX()][position.getPosY()];
	}

	public void SetAgent(AgentMaze agent) {
		this.agent = agent;
		
	}

	public void clean() {
		PositionXY position = this.agent.getPosition();
		maze[position.getPosX()][position.getPosY()] = "E";
	}

}
