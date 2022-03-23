package fr.raised_controller.interstellar_graveyard.board.element.property;

import fr.raised_controller.interstellar_graveyard.exception.IllegalPropertyValue;

public class PropertyValue<T> {
	private T value;
	
	public PropertyValue(Property<T> prop, T value) throws IllegalPropertyValue
	{
		if(!prop.getValues().contains(value))
		{
			throw new IllegalPropertyValue(prop.getName(), value);
		}
		this.value=value;
	}
	
	public T get()
	{
		return value;
	}
}
