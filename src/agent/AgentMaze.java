package agent;

import environment.Maze;
import general.PositionXY;

public class AgentMaze {

	private Maze maze;
	private AgentMazeMoves moves;

	private PositionXY posXY;
	
	private int moveStack;

	public AgentMaze(Maze maze) {
		this.maze = maze;
		maze.SetAgent(this);
		this.posXY = new PositionXY();
		this.moves = AgentMazeMoves.UP;
	}
	
	public void move() {
		if(this.moveStack >= 4) {
			return;
		}
		
		PositionXY nextMove = returnMoves();
		
		String value = this.maze.returnValuePositionMaze(nextMove);
		
		if(value.contentEquals("E") || value.equals("*A*")) {
			nextMove();
			increaseStack();
			move();
		} else {
			this.maze.clean();
			this.posXY = nextMove;
		}
	}

	private void increaseStack() {
		this.moveStack++;
	}

	private void nextMove() {
		switch(this.moves) {
		case UP:
			this.moves = AgentMazeMoves.DOWN;
			break;
		case DOWN:
			this.moves = AgentMazeMoves.LEFT;
			break;
		case LEFT:
			this.moves = AgentMazeMoves.RIGHT;
			break;
		case RIGHT:
			this.moves = AgentMazeMoves.UP;
			break;
		}
	}

	public PositionXY returnMoves() {

		int returnPosX = this.posXY.getPosX();
		int returnPosY = this.posXY.getPosY();

		switch (moves) {
		case UP:
			if (returnPosX > 0) {
				returnPosX -= 1;
			}
			break;
		case DOWN:
			if (returnPosX < this.maze.getMazeSize() - 1) {
				returnPosX += 1;
			}
			break;
		case LEFT:
			if (returnPosY > 0) {
				returnPosY -= 1;
			}
			break;
		case RIGHT:
			if (returnPosY < this.maze.getMazeSize() - 1) {
				returnPosY += 1;
			}
			break;
		}
		
		return new PositionXY(returnPosX, returnPosY);
	}

	public PositionXY getPosition() {
		return this.posXY;
	}

	public boolean isNotEndEaten() {
		return moveStack < 4;
	}

	public void zeroStack() {
		this.moveStack = 0;
		
	}

	public void setPosition(PositionXY positionXY) {
		this.posXY = positionXY;
		
	}
}
