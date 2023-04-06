/* This will handle the "Hot Key" system. */

package Main;

import logic.Control;
import timer.stopWatchX;

public class KeyProcessor {
	// Static Fields
	private static char last = ' '; // For debouncing purposes
	private static stopWatchX sw = new stopWatchX(130);
	private static stopWatchX timer = new stopWatchX(60);
	private static int i, j;

	// Static Method(s)
	public static void processKey(char key) {
		if (key == ' ')
			return;
		// Debounce routine below...
		if (key == last)
			if (sw.isTimeUp() == false)
				return;
		last = key;
		sw.resetWatch();

		/* TODO: You can modify values below here! */
		switch (key) {
			case '%': // ESC key
				System.exit(0);
				break;

			case 'm':
				// For mouse coordinates
				Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
				break;

			// space bar
			case '$':

				if (Main.checkCollision(Main.playerBox, Main.door)) {
					Main.trigger = " The house is dirty. Out you go.";
					Main.dialog.setTag("dialogbox");
				}

				if (Main.checkCollision(Main.playerBox, Main.flower1)
						|| Main.checkCollision(Main.playerBox, Main.flower2)
						|| Main.checkCollision(Main.playerBox, Main.flower3)) {
					Main.trigger = "          Look a flower";
					Main.dialog.setTag("dialogbox");
				}

				break;

			case 'w':
				Main.trigger = " ";
				Main.dialog.setTag("nothing");
				if (timer.isTimeUp()) {
					Main.lastPos.setCoords(Main.player.getCoords().getX(), Main.player.getCoords().getY());
					Main.player.getCoords().adjustY(-16);
					Main.player.setTag("up" + j);
					j++;
					if (j >= 3) {
						j = 0;
					}
					timer.resetWatch();
				}
				break;

			case 'a':
				Main.trigger = " ";
				Main.dialog.setTag("nothing");
				if (timer.isTimeUp()) {
					Main.lastPos.setCoords(Main.player.getCoords().getX(), Main.player.getCoords().getY());
					Main.player.getCoords().adjustX(-16);
					Main.player.setTag("left" + i);
					i++;
					if (i >= 4) {
						i = 0;
					}
					timer.resetWatch();
				}
				break;

			case 's':
				Main.trigger = " ";
				Main.dialog.setTag("nothing");
				if (timer.isTimeUp()) {
					Main.lastPos.setCoords(Main.player.getCoords().getX(), Main.player.getCoords().getY());
					Main.player.getCoords().adjustY(16);
					Main.player.setTag("down" + j);
					j++;
					if (j >= 3) {
						j = 0;
					}
					timer.resetWatch();
				}

				break;

			case 'd':
				Main.trigger = " ";
				Main.dialog.setTag("nothing");
				if (timer.isTimeUp()) {
					Main.lastPos.setCoords(Main.player.getCoords().getX(), Main.player.getCoords().getY());
					Main.player.getCoords().adjustX(16);
					Main.player.setTag("right" + i);
					i++;
					if (i >= 4) {
						i = 0;
					}
					timer.resetWatch();
				}
				break;
		}

	}
}