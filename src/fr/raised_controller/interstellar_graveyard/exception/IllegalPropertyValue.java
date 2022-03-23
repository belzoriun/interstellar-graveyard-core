package fr.raised_controller.interstellar_graveyard.exception;

public class IllegalPropertyValue extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4409659677279595328L;

	public IllegalPropertyValue(String propertyName, Object value)
	{
		super("Value "+value+" is invalid for property "+propertyName);
	}
}
