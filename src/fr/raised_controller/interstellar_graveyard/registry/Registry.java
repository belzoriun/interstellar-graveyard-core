package fr.raised_controller.interstellar_graveyard.registry;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public abstract class Registry<T> {
	
	protected BiMap<Identifier, T> values;
	
	protected Registry()
	{
		this.values = HashBiMap.create();
	}
	
	public T add(Identifier id, T value)
	{
		values.put(id, value);
		return value;
	}
	
	public abstract T get(Identifier id);
	
	public abstract T getId(T value);
	
	public static void setupRegistries() {
		//put code on registry setup here
	}
}
