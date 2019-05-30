package excercise2;

public class App {

	public static void main(String[] args) {
		WebScraper ws = new WebScraper("https://www.delfi.ee/");
		ws.openScraper();
		ws.saveHTML();
		ws.closeScraper();
	}
}
