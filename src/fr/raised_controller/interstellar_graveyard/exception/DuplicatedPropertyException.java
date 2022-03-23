package fr.raised_controller.interstellar_graveyard.exception;

public class DuplicatedPropertyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6142294112779277168L;

	public DuplicatedPropertyException(String propName)
	{
		super("Found duplicate property "+propName);
	}
}
