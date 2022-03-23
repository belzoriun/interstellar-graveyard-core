package fr.raised_controller.interstellar_graveyard.registry;

public class SimpleRegistry<T> extends Registry<T>{

	protected SimpleRegistry(RegistryKey<? extends Registry<T>> key) {
		super(key);
	}

	@Override
	public T get(Identifier id) {
		return idEntries.get(id);
	}

	@Override
	public Identifier getId(T value) {
		return values.inverse().get(value).getValue();
	}

}
