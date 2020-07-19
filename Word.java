/**
 * Word is the basic building block. Words searching and display are base on Word object.
 * Each Word object is consist of field "word" and "explanation", both are private final to protect from modifying.
 * User can create new Word object and add it into UserList, and may delete items from UserList.
 *
 */
public class Word {
	private final String word;
	private final String explanation;
	
	public Word(String word, String explanation) {
		this.word = word;
		this.explanation = explanation;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public String getExplanation() {
		return this.explanation;
	}
}
