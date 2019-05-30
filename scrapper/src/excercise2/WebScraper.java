package excercise2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class WebScraper implements ScraperInterface {

	private String url;
	private String title;
    private Document document;
    
    public WebScraper(String url) {
        this.url = url;
    }

	public static void print(String string) {
		System.out.println(string);
	}

	public void openScraper() {
		System.out.println("Scrapper starting.");
		scrappingWebsite();
	}

	public void scrappingWebsite() {
		try {
			document = Jsoup.connect(url).get();
			title = document.title();
			System.out.println("Scrapping the page: " + title);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveHTML() {
		BufferedWriter  writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter(title + ".html"));
            writer.write(document.toString());

        }
        catch (IOException e)
        {
        	System.out.println(e);
        }
	}
	
	public void closeScraper() {
		document = null;
		title = null;
		System.out.println("Scrapper has closed.");
	}
}
