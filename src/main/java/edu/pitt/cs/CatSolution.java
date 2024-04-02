package edu.pitt.cs;

public class CatSolution implements Cat {

	/**
	 * Indicates whether or not the cat is rented.
	 */
	private boolean rented = false;

	/**
	 * ID of the cat By default, -1
	 */
	private int id = -1;

	/**
	 * Name of the cat
	 */
	private String name;

	/**
	 * Constructor - creates a new Cat object Note there are no checks that this ID
	 * is not taken by another cat! This is probably something that we would fix in
	 * a production system.
	 * 
	 * @param int    id - the id number of this cat
	 * @param String name - the name of this Cat
	 */
	public CatSolution(int id, String name) {
		this.rented = false;
		this.id = id;
		this.name = name;
	}

	/**
	 * Rent cat. Simply sets the _rented flag to true.
	 */
	public void rentCat() {
		rented = true;
	}

	/**
	 * Return cat. Simply sets the _rented flag to false.
	 */
	public void returnCat() {
		rented = false;
	}

	/**
	 * Rename cat. Simply sets the name to the new name.
	 * 
	 * @param String name New name of the cat
	 */
	public void renameCat(String name) {
		this.name = name;
	}

	/**
	 * Accessor for _name variable. Returns the name of this cat.
	 * 
	 * @return String name of cat
	 */
	public String getName() {
		return name;
	}

	/**
	 * Accessor for _id variable. Returns the ID of this cat.
	 * 
	 * @return int ID of this cat
	 */
	public int getId() {
		return id;
	}

	/**
	 * Accessor for _rented variable. Returns if cat is rented.
	 * 
	 * @return boolean - true if rented, false otherwise
	 */
	public boolean getRented() {
		return rented;
	}

	/**
	 * Returns string version of this cat, in form: "ID *id_num*. *name*" Example
	 * for cat of ID 1, name Jennyanydots: "ID 1. Jennyanydots"
	 * 
	 * @return String string version of cat
	 */
	public String toString() {
		return "ID " + id + ". " + name;
	}

}
