package fr.raised_controller.interstellar_graveyard.util.option;

public class Option<T> {
	private T value;
	private Class<T> type;
	
	public Option(Class<T> type, T defaultValue)
	{
		this.value = defaultValue;
		this.type = type;
	}
	
	public T get()
	{
		return value;
	}
	
	public boolean set(Object value)
	{
		try
		{
			this.value = type.cast(value);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
}
