package fr.raised_controller.interstellar_graveyard.registry;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public abstract class Registry<T> {
	
	protected BiMap<RegistryKey<? extends T>, T> values;
	private boolean erraseDuplicateKey;
	private RegistryKey<Registry<? extends T>> key;
	
	protected Registry(RegistryKey<Registry<? extends T>> key)
	{
		this.values = HashBiMap.create();
		erraseDuplicateKey = true;
		this.key = key;
	}
	
	public Registry<T> preventDuplicateKeyErase()
	{
		erraseDuplicateKey = false;
		return this;
	}
	
	public <R extends T> R add(RegistryKey<? extends T> key2, R registry)
	{
		values.put(key2, registry);
		return registry;
	}
	
	public abstract T get(Identifier id);	
	public abstract Identifier getId(T value);
	
	public static final Identifier ROOT_KEY = new Identifier("root");
	
	public static final Registry<Registry<?>> ROOT = new SimpleRegistry(Registry.createRegistryKey("root"));
	
	private static <T> RegistryKey<Registry<T>> createRegistryKey(String id)
	{
		return RegistryKey.ofRegistry(new Identifier(id));
	}
	
	private static <T> Registry<T> create(RegistryKey<Registry<? extends T>> key, String defaultId, DefaultProvider<T> provider)
	{
		return create(key, new SimpleRegistry<T>(key));
	}
	
	private static <T> Registry<T> create(RegistryKey<Registry<? extends T>> key)
	{
		return create(key, new SimpleRegistry<T>(key));
	}
	
	public static <T, R extends Registry<T>> R create(RegistryKey<Registry<? extends T>> key, R registry)
	{
		Registry<Registry<?>> root = ROOT;
		return root.add(key, registry);
	}

	public static void setupRegistries() {
		//put code on registry setup here
	}
}
