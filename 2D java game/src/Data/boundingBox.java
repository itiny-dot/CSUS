package Data;

public class boundingBox {

	//fields
	private spriteInfo spriteData;
	private int x1, x2, y1, y2;
	
	//methods
	public boundingBox(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public boundingBox(spriteInfo sprite) {
		spriteData = sprite;
		x1 = spriteData.getCoords().getX();
		x2 = spriteData.getCoords().getX() +128;
		y1 = spriteData.getCoords().getY();
		y2 = spriteData.getCoords().getY() + 128;
	}
	
	public boundingBox (spriteInfo sprite, int adjust_x1, int adjust_x2, int adjust_y1, int adjust_y2) {
		spriteData = sprite;
		x1 = spriteData.getCoords().getX() + adjust_x1;
		x2 = spriteData.getCoords().getX() + adjust_x2;
		y1 = spriteData.getCoords().getY() + adjust_y1;
		y2 = spriteData.getCoords().getY() + adjust_y2;
	}
	
	public String toString(){
		return "x1 = " +x1 + " x2 = " +x2 + " y1 = " + y1 + " y2 = " +y2;
	}
	
	public int getX1() {
		return x1;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getY1() {
		return y1;
	}
	
	public int getY2() {
		return y2;
	}
	
	public void setX1(int num) {
		x1 = num;
	}
	
	public void setX2(int num) {
		x2 = num;
	}
	
	public void setY1(int num) {
		y1 = num;
	}
	
	public void setY2(int num) {
		y2 = num;
	}
	
	
}
