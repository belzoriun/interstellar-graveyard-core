package fr.raised_controller.interstellar_graveyard.board.token;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.board.element.PieceSettings;
import fr.raised_controller.interstellar_graveyard.board.element.property.Property;
import fr.raised_controller.interstellar_graveyard.board.element.property.PropertyValue;
import fr.raised_controller.interstellar_graveyard.exception.IllegalPropertyValue;

public class BoardToken{
	protected BoardPiece piece;
	protected Map<Property<?>, PropertyValue<?>> properties;
	
	protected BoardToken(BoardPiece piece, PieceSettings settings, Map<String, Property<?>> properties)
	{
		this.piece = piece;
		for(Property<?> prop : properties.values())
		{
			try {
				this.properties.put(prop, prop.createValue());
			} catch (IllegalPropertyValue e) {
				e.printStackTrace();
			}
		}
		//TODO : use settings
	}
	
	public <T> BoardToken with(Property<T> prop, T value)
	{
		if(!properties.containsKey(prop))
		{
			throw new IllegalArgumentException("Property "+prop+" not found in token");
		}
		try {
			this.properties.put(prop, prop.createValue(value));
		} catch (IllegalPropertyValue e) {
			System.out.println("Property set ignored "+e.getMessage());
		}
		
		return this;
	}
	
	public <T> T get(Property<T> prop)
	{
		return prop.getType().cast(properties.get(prop).get());
	}
	
	public BoardPiece getPiece()
	{
		return this.piece;
	}
	
	public List<Property<?>> getProperties()
	{
		return new ArrayList<>(this.properties.keySet());
	}

	public static class Builder
	{
		private Map<String, Property<?>> properties;
		private BoardPiece owner;
		private PieceSettings settings;
		
		public Builder(BoardPiece owner)
		{
			properties = new HashMap<>();
			this.owner=owner;
			settings = new PieceSettings();
		}
		
		public Builder useSettings(PieceSettings settings)
		{
			this.settings = settings;
			return this;
		}
		
		public Builder add(Property<?> ...properties)
		{
			for(Property<?> property : properties)
			{
				this.properties.put(property.getName(), property);
			}
			return this;
		}
		
		public BoardToken build()
		{
			return new BoardToken(owner, settings, properties);
		}
	}
}
