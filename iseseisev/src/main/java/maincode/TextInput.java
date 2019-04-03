package maincode;

public class TextInput {

    private final String words;
    private final int word_count;
    private final int starts_with_uppercase;

    public TextInput(String words, int word_count, int starts_with_uppercase) {
    	this.words = words;
        this.word_count = word_count;
        this.starts_with_uppercase = starts_with_uppercase;
    }

	public String getWords() {
		return words;
	}

	public int getWord_count() {
		return word_count;
	}

	public int getStarts_with_uppercase() {
		return starts_with_uppercase;
	}
}
