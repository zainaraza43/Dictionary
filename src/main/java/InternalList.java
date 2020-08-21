
public class InternalList {
	/**
	 * The field of InternalList is final to protect it from modifying.
	 */
	private final Word[] internalList;
	private final int size;
	
	public InternalList() {
		
		//TODO: This constructor should read data from a text file and convert its contents to Word objects.
		//TODO: Then similar as shown below, create new Word[size], which should be big enough to contain all the words,
		//TODO: and put them into the Word[].
		
		//The lines below are only for IDE not issuing errors.
		this.size = 0;
		Word[] newList = new Word[size];
		internalList = newList;
	}
	
	/**
	 * Note that this method returns a Word object.
	 * @param index
	 * @return
	 */
	public Word getWord(int index) {
		return internalList[index];
	}
	
	/**
	 * There should not be any setter method for interalList to protect it from modifying after initializing.
	 */
}
