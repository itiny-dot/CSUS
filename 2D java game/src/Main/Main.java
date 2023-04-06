/* Rachael Wang
 * CS 130-04
 */
package Main;

import java.awt.Color;
import java.util.ArrayList;

import Data.Vector2D;
import Data.boundingBox;
import Data.spriteInfo;
import logic.Control;

public class Main {
	// Fields (Static) below...
	public static boolean isImageDrawn = false;

	public static int num = 0;

	public static String trigger = " ";
	public static String textTrigger = "nothing";

	public static ArrayList<spriteInfo> sprites = new ArrayList<spriteInfo>();
	public static ArrayList<boundingBox> boxes = new ArrayList<boundingBox>();

	public static Vector2D currVec = new Vector2D(600, 290);
	public static Vector2D lastVec = new Vector2D(0, 0);

	public static spriteInfo player = new spriteInfo(currVec, "down" + num);
	public static spriteInfo dialog = new spriteInfo(new Vector2D(480, 70), textTrigger);
	public static spriteInfo lastPos = new spriteInfo(lastVec, player.getTag());

	public static boundingBox playerBox;
	public static boundingBox door = new boundingBox(800, 885, 200, 280); // interactable object
	public static boundingBox flower1 = new boundingBox(485, 545, 210, 275); // interactable object
	public static boundingBox flower2 = new boundingBox(170, 230, 60, 125); // interactable object
	public static boundingBox flower3 = new boundingBox(895, 955, 540, 605); // interactable object

	// End Static fields...

	public static void main(String[] args) {
		Control ctrl = new Control(); // Do NOT remove!
		ctrl.gameLoop(); // Do NOT remove!
	}

	/* This is your access to things BEFORE the game loop starts */
	public static void start() {
		// TODO: Code your starting conditions here...NOT DRAW CALLS HERE! (no addSprite
		// or drawString)

		boxes.add(new boundingBox(580, 1300, -500, 0)); // top
		boxes.add(new boundingBox(-128, 1300, 630, 720)); // bottom
		boxes.add(new boundingBox(-128, 140, 0, 720)); // left
		boxes.add(new boundingBox(1195, 1280, -128, 230)); // right
		boxes.add(new boundingBox(-128, 570, -100, -20)); // top entrance
		boxes.add(new boundingBox(1290, 1500, 300, 640)); // right entrace/exit
		boxes.add(new boundingBox(750, 1300, 50, 240)); // house and tree

		sprites.add(new spriteInfo(new Vector2D(0, 0), "background"));
		sprites.add(player);
		sprites.add(dialog);

	}

	/*
	 * This is your access to the "game loop" (It is a "callback" method from the
	 * Control class (do NOT modify that class!))
	 */
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you
		// how it works)

		playerBox = new boundingBox(player, 30, 90, 30, 90);

		for (int i = 0; i < boxes.size(); i++) {
			if (checkCollision(playerBox, boxes.get(i)))
				bouncePlayer();
		}

		for (int i = 0; i < sprites.size(); i++) {
			ctrl.addSpriteToFrontBuffer(sprites.get(i).getCoords().getX(), sprites.get(i).getCoords().getY(),
					sprites.get(i).getTag());
		}
		ctrl.drawString(527, 230, trigger, Color.DARK_GRAY);

	}

	// Additional Static methods below...(if needed)

	public static boolean checkCollision(boundingBox box1, boundingBox box2) {
		if (((box1.getX1() > box2.getX2())
				|| (box1.getX2() < box2.getX1())
				|| (box1.getY1() > box2.getY2())
				|| (box1.getY2() < box2.getY1())))
			return false;
		else
			return true;
	}

	public static void bouncePlayer() {
		if ((player.getCoords().getX() - lastPos.getCoords().getX()) != 0) {
			if ((player.getCoords().getX() - lastPos.getCoords().getX()) > 0) // If moved from West to East
				player.getCoords().adjustX(-16);
			if ((player.getCoords().getX() - lastPos.getCoords().getX()) < 0) // If moved from East to West
				player.getCoords().adjustX(+16);
		}
		if ((player.getCoords().getY() - lastPos.getCoords().getY()) != 0) {
			if ((player.getCoords().getY() - lastPos.getCoords().getY()) > 0) // If moved from North to South
				player.getCoords().adjustY(-16);
			if ((player.getCoords().getY() - lastPos.getCoords().getY()) < 0) // If moved from South to North
				player.getCoords().adjustY(+16);
		}
	}
}
