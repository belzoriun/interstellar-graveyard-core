package fr.raised_controller.interstellar_graveyard.registry;

public class SimpleRegistry<T> extends Registry<T>{

	protected SimpleRegistry(RegistryKey<Registry<? extends T>> key) {
		super(key);
	}

	@Override
	public T get(Identifier id) {
		return values.get(id);
	}

	@Override
	public Identifier getId(T value) {
		return values.inverse().get(value).getValue();
	}

}
