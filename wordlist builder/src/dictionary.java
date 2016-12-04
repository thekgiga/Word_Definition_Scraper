import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class dictionary {
	public dictionary(String...strings){

		String base ="http://www.dictionary.com/browse/";
		for (String s : strings) {
			Document doc;
			try {
				doc = Jsoup.connect(base+s)
						.userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
						.timeout(10000).get();
				Elements e = doc.select("#source-luna > div.source-box > section > div.source-data > div.def-list > section:nth-child(1) > div:nth-child(2)");
				System.out.println(e.first().text());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}


	}
	public static void main(String[] args){
		dictionary d = new dictionary("cat","whisper");
	}
}

