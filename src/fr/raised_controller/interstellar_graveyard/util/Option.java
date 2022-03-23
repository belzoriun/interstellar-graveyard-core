package fr.raised_controller.interstellar_graveyard.util;

public class Option<T> {
	private T value;
	
	public Option(T defaultValue)
	{
		this.value = defaultValue;
	}
	
	public T get()
	{
		return value;
	}
	
	public boolean set(Object value)
	{
		try
		{
			this.value = (T)value;
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
}
