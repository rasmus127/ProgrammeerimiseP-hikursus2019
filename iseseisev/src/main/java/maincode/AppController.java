package maincode;

import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

	@GetMapping("/text")
    @ResponseBody
    public TextInput getInput(@RequestParam(name="text", required=true) String text) throws JSONException {
    	
    	String[] inputWords = text.split(" ");
    	ArrayList<Integer> foundWords = new ArrayList<Integer>();
    	int upperCase = 0;
    	String result = "[";
    	Integer count;
    	
    	for (int i = 0; i < inputWords.length; i++) {
			if (Character.isUpperCase(inputWords[i].charAt(0))) {
				upperCase ++;
			}
			count = 0; 
				if (!foundWords.contains(i)) {
				for (int j = 0; j < inputWords.length; j++) {
					if (inputWords[i].equals(inputWords[j])) {
						count ++;
						foundWords.add(j);
					}
				}
				result += "{" + "\'" + inputWords[i] + "\'" + ":" + count.toString() + "}, ";
			}
		}
    	result = result.substring(0, result.length()-2) + "]";
    	
        return new TextInput(result, inputWords.length, upperCase);
    }

}