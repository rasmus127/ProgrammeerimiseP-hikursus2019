package TekstiYl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReadTXT {

	public static void main(String[] args) throws IOException {
		ReadTXT rt = new ReadTXT();
		HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
		String[] words = rt.readFile("artiklikogumik.txt").split("\\s+|,\\s*|\\.\\s*");
		for (String word : words) {
			String wordLower = word.toLowerCase();
			Integer count = wordsCount.get(wordLower);
			if (count == null) {
				wordsCount.put(wordLower, 1);
			}
			else {
				wordsCount.put(wordLower, count + 1);
			}
		}
		
		
		for (String s : ReadTXT.sortMap(wordsCount).keySet()) {
			  System.out.println("key: " + s + " value: " + wordsCount.get(s));
		}
	}
	
	public String readFile (String name) throws IOException {
		return new String(Files.readAllBytes(Paths.get(name)), StandardCharsets.UTF_8);
	}
	
	public static LinkedHashMap<String, Integer> sortMap(HashMap<String, Integer> map) {
        List<Map.Entry<String, Integer>> capitalList = new LinkedList<>(map.entrySet());

        Collections.sort(capitalList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : capitalList)
        {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
