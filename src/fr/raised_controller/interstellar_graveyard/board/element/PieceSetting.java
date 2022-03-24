package fr.raised_controller.interstellar_graveyard.board.element;

public class PieceSetting<T> {
	private T value;
	private boolean imutable;
	
	public PieceSetting(T value)
	{
		this(value, true);
	}
	
	public PieceSetting(T value, boolean imutable)
	{
		this.value=value;
		this.imutable = imutable;
	}
	
	public T getValue()
	{
		return value;
	}
	
	public void setValue(T value)
	{
		if(!imutable)
		{
			this.value = value;
		}
	}
	
	public boolean isImutable()
	{
		return imutable;
	}

	public void makeImutable() {
		this.imutable = true;
	}
}
