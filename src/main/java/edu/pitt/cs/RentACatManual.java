package edu.pitt.cs;

import java.util.ArrayList;
import java.util.Scanner;

public class RentACatManual implements RentACat {

	private ArrayList<Cat> cats = new ArrayList<Cat>();

	/**
	 * Return a cat. This should call the .returnCat() method on the cat for the
	 * passed-in cat id. If the cat with the id exists in the list of cats and has
	 * been rented out, then this method should return true after calling
	 * .returnCat() on that cat. Otherwise, the method should return false.
	 * 
	 * @param id the ID of the cat to rent
	 * @return true if cat exists and was rented out, false otherwise
	 */

	public boolean returnCat(int id) {
		// TODO
		Cat c = getCat(id);
		if (c != null) {
			if (c.getRented()) {
				c.returnCat();
				System.out.println("Welcome back, " + c.getName() + "!");
				return true;
			} else {
				System.out.println(c.getName() + " is already here!");
			}
		} else {
			System.out.println("Invalid cat ID.");
		}
		return false;
	}

	/**
	 * Rent a cat. This should call the .rentCat() method on the cat for the
	 * passed-in cat id. If the cat with the id exists in the list of cats and has
	 * *not* been rented out, then this method should return true after calling
	 * .rentCat() on that cat. Otherwise, the method should return false.
	 * 
	 * @param id the ID of the cat to rent
	 * @return true if cat exists and was not rented out, false otherwise
	 */

	public boolean rentCat(int id) {
		// TODO
		Cat c = getCat(id);
		if (c != null) {
			if (!c.getRented()) {
				c.rentCat();
				System.out.println(c.getName() + " has been rented.");
				return true;
			} else {
				System.out.println("Sorry, " + c.getName() + " is not here!");
			}
		} else if (id == 4) {
			System.out.println(" has been rented.");
		} else {
			System.out.println("Invalid cat ID.");
		}
		return false;
	}

	/**
	 * Rename a cat. This calls the .renameCat(String) method on the cat for the
	 * passed-in cat id, if the cat exists, and then returns true. If the cat does
	 * not exist, the method returns false.
	 * 
	 * @param id the ID of the cat to rename
	 * @return true if cat exists, false otherwise
	 */

	public boolean renameCat(int id, String name) {
		Cat c = getCat(id);
		// BUG: cat ID 3 is treated as an invalid cat.
		if (c != null && id < 3) {
			if (!c.getRented()) {
				c.renameCat(name);
				System.out.println("Hello, " + c.getName() + "!");
				return true;
			} else {
				System.out.println("Sorry, " + c.getName() + " is not here!");
			}
		} else {
			System.out.println("Invalid cat ID.");
		}
		return false;
	}

	/**
	 * Create a String list from the list of cats using the .toString() method of
	 * each NON-RENTED Cat object in the list. That is, it should only add cats who
	 * are available to be rented. These cats should be separated by "\n" characters
	 * (line feeds). Example: ID 1. Jennyanydots ID 2. Old Deuteronomy ID 3.
	 * Mistoffelees
	 * 
	 * @return "\n"-delimited list of rentable cats
	 */

	public String listCats() {
		// TODO
		String ret = "";
		// null / zero-element check
		if (cats == null || cats.size() == 0) {
			return "";
		}

		// Loop through every cat in the cat list
		for (Cat c : cats) {
			if (!c.getRented()) {
				ret += c.toString();
				ret += "\n";
			}
		}
		// If we get all the way through the list and did
		// not find a cat whose ID matches the passed-in
		// ID, then the cat is not in the list
		return ret;
	}

	/**
	 * Given an id, return true if the cat exists in the list of cats or false if
	 * no cat with that id number exists in the list. If list is null or contains 0
	 * elements, should always return false.
	 * 
	 * @param id ID of cat to search for
	 * @return true if cat exists in list, false otherwise
	 */

	public boolean catExists(int id) {
		// TODO
		return getCat(id) != null;
	}

	/**
	 * Given an id, return true if the cat exists in the list of cats and is
	 * available for rent; otherwise return false. If list is null or contains 0
	 * elements, should always return false.
	 * 
	 * @param id ID of cat to search for
	 * @return true if cat available for rent, false otherwise
	 */

	public boolean catAvailable(int id) {

		// null / zero-element check
		if (cats == null || cats.size() == 0) {
			return false;
		}
		Cat c = getCat(id);
		if (c == null) {
			// No cat of this ID exists, thus it is not available
			return false;
		} else if (c.getRented()) {
			// This cat exists, but has already been rented
			return false;
		}

		// If cat exists and is not rented, then the cat
		// is available to rent
		return true;

	}

	/**
	 * Given an id, return a reference to the specified cat if a cat with that ID
	 * exists. Return null if no cat of that ID exists in the list.
	 * 
	 * @param int id ID of cat to search for
	 * @return Cat searched for if exists, null otherwise
	 */

	public Cat getCat(int id) {

		// null / zero-element check
		if (cats == null || cats.size() == 0) {
			return null;
		}

		// Loop through every cat in the cat list
		for (Cat c : cats) {
			// If we found a cat whose id matches the id
			// of the argument, then we have a match and
			// can thus return a reference to that cat
			if (c.getId() == id) {
				return c;
			}
		}
		// If we get all the way through the list and did
		// not find a cat whose ID matches the passed-in
		// ID, then the cat is not in the list
		return null;

	}

	/**
	 * Add a cat to the list of cats.
	 * 
	 * @param c the Cat to add
	 */

	public void addCat(Cat c) {
		cats.add(c);
	}

	/**
	 * Main method
	 * 
	 * @param args - IGNORED, kept for compatibility
	 */
	public static void main(String[] args) {
		RentACat rc = new RentACatManual();

		rc.addCat(new CatImpl(1, "Jennyanydots"));
		rc.addCat(new CatImpl(2, "Old Deuteronomy"));
		rc.addCat(new CatImpl(3, "Mistoffelees"));

		Scanner sc = new Scanner(System.in);

		int option;
		boolean keepGoing = true;

		while (keepGoing) {
			System.out.print("Option [1,2,3,4,5] > ");

			option = sc.nextInt();
			switch (option) {
				case 1:
					System.out.println("Cats for Rent");
					System.out.print(rc.listCats());
					break;
				case 2:
					System.out.print("Rent which cat? > ");
					try {
						int catIdToRent = sc.nextInt();
						rc.rentCat(catIdToRent);
					} catch (Exception ex) {
						System.out.println("Invalid cat ID.");
						sc.next();
						break;
					}
					break;
				case 3:
					// BUG: failed to handle invalid cat exception.
					System.out.print("Return which cat? > ");
					int catIdToReturn = sc.nextInt();
					rc.returnCat(catIdToReturn);
					break;
				case 4:
					System.out.print("Rename which cat? > ");
					try {
						int catIdToRename = sc.nextInt();
						sc.nextLine(); // to flush the previous line
						System.out.print("What is the new name? > ");
						String newName = sc.nextLine();
						rc.renameCat(catIdToRename, newName);
					} catch (Exception ex) {
						System.out.println("Invalid cat ID.");
						sc.next();
						break;
					}
					break;
				case 5:
					keepGoing = false;
					break;
				default:
					break;
			}
		}

		System.out.println("Closing up shop for the day!");

		sc.close();
	}
}
