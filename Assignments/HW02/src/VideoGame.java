/*
 * Gavin Hewitt
 */
public class VideoGame {
	private String name;
	private String console;
	public VideoGame()
	{
		name = null;
		console = null;
	}
	public VideoGame(String n, String c)
	{
		name = n;
		console = c;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name != null)
			this.name = name;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		if(console != null)
			this.console = console;
	}
	public void print()
	{
		System.out.println("Game: "+name+" Console: "+console);
	}
}
