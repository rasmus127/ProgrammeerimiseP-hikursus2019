package excercise4;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class Tests {
	
	TextAnalytics text = new TextAnalytics("test.txt");
	
	@Test
	public void TestIfTextFileIsNotEmpty() {
		assertEquals(text.file_content.length > 0, false);
	}
	
	@Test
	public void TestFileReading() {
		assertEquals(text.file_content, "Kass koer inimene");
	}
	
	@Test
	public void TestWordCounting() {
		assertEquals(text.counter.size(), 3);
	}
	
	@Test
	public void TestIfWordsAreSplit() {
		assertEquals(text.array_of_words.length, 3);
	}
	

	@Test
	public void TestIfIsLowerCase() {
		assertEquals(text.array_of_words[0], "kass");
	}
	
	@Test
	public void TestHowManyLettersInText () {
		assertEquals(text.file_content.length, 17);
	}
	
	
	@Test
	public void TestIfNoUppercaseLetters () {
		boolean answer = !text.array_of_words[0].Equals("Kass");
		assertEquals(answer, true);

	}
	
	@Test
	public void TestIfCountingIsCorrect() {
		Integer count = new Integer(1);
		assertEquals(text.counter.get("inimene"), count);
	}

}
