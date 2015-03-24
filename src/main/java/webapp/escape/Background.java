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

public enum Background {
	BLACK(40),RED(41),GREEN(42),YELLOW(43),BLUE(44),MAGENTA(45),CYAN(46),WHITE(47);
	
	final int value;
	
	private Background(int value){
		this.value = value;
	}
}
