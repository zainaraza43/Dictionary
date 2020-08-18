/**
 * 
 * This is the entrance point of the dictionary.
 * To-do items is contained.
 * 
 * @author Zackham Guo
 *
 */
public class Launch {
	public static void main(String[] args) {
		//TODO: initializing. Call methods from InternalList and UserList to load the dictionary data base.
		
		//TODO: provide user interface, may be GUI
		
		//TODO: accept user command to perform actions like displaying, searching.

		// Testing hash table
		HashTable t = new HashTable(5);
		t.Insert("Apple","A red fruit");
		t.Insert("Keyboard","A modern typewriter");
		t.Insert("Bed","A piece of furniture for rest");
		t.Insert("Apple","A big technology focused company");
		t.Display();
		t.Remove("Apple","A big technology focused company");
		t.Display();
	}
}
