package fr.raised_controller.interstellar_graveyard.registry;

public class DefaultedRegistry<T> extends Registry<T>{
	
	private DefaultProvider<T> defaultValue;
	private Identifier defaultId;

	protected DefaultedRegistry(RegistryKey<Registry<? extends T>> key, Identifier defaultId, DefaultProvider<T> defaultValue) {
		super(key);
		this.defaultId = defaultId;
		this.defaultValue = defaultValue;
	}

	@Override
	public T get(Identifier id) {
		if(!idEntries.containsKey(id))
		{
			return defaultValue.provide();
		}
		return idEntries.get(id);
	}

	@Override
	public Identifier getId(T value) {
		if(!values.inverse().containsKey(value))
		{
			return defaultId;
		}
		return values.inverse().get(value).getValue();
	}

}
