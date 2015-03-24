package webapp.escape;
/*
 * 40 black
 * 41 red
 * 42 green
 * 43 yellow
 * 44 blue
 * 45 magenta
 * 46 cyan
 * 47 white
 */
public enum Foreground {
	BLACK(30),RED(31),GREEN(32),YELLOW(33),BLUE(34),MAGENTA(35),CYAN(36),WHITE(37);
	
	final int value;
	private Foreground(int v) {
		// TODO Auto-generated constructor stub
		this.value = v;
	}
}
