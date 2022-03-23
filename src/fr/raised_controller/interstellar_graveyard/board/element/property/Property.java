package fr.raised_controller.interstellar_graveyard.board.element.property;

import java.util.ArrayList;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import fr.raised_controller.interstellar_graveyard.exception.IllegalPropertyValue;

public abstract class Property<T> {
	protected Set<T> possibleValues;
	private String name;
	private Class<T> type;
	
	protected Property(String name, Class<T> type, ImmutableSet<T> values)
	{
		if(values.size()<=0)
		{
			throw new IllegalArgumentException("Property has to define at least one value");
		}
		this.type = type;
		this.name = name;
		this.possibleValues = values;
	}
	
	public Class<T> getType()
	{
		return this.type;
	}
	
	public Set<T> getValues(){
		return possibleValues;
	}
	
	public String getName()
	{
		return name;
	}
	
	public PropertyValue<T> createValue() throws IllegalPropertyValue
	{
		return new PropertyValue<T>(this, new ArrayList<T>(this.possibleValues).get(0));
	}
	
	public PropertyValue<T> createValue(T value) throws IllegalPropertyValue
	{
		return new PropertyValue<T>(this, value);
	}
}
