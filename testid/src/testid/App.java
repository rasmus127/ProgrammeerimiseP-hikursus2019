package excercise4;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        TextAnalytics text = new TextAnalytics("text.txt");
        String array_string = Arrays.toString(text.array_of_words);
        System.out.println(array_string);
        String map_string = text.counter.toString();
        System.out.println(map_string);
    }
}