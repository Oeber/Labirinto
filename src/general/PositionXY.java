package general;

public class PositionXY {
	private int posX;
	private int posY;
	
	public PositionXY() {
		this.posX = 0;
		this.posY = 0;
	}
	
	public PositionXY(int returnPosX, int returnPosY) {
		this.posX = returnPosX;
		this.posY = returnPosY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
}
