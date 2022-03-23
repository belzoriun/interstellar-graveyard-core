package fr.raised_controller.interstellar_graveyard.registry;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.board.element.BoardPieces;

public abstract class Registry<T> {
	
	protected BiMap<RegistryKey<? extends T>, T> values;
	protected Map<Identifier, T> idEntries;
	private boolean erraseDuplicateKey;
	private RegistryKey<? extends Registry<T>> key;
	
	protected Registry(RegistryKey<? extends Registry<T>> key)
	{
		this.values = HashBiMap.create();
		erraseDuplicateKey = true;
		this.key = key;
		idEntries = new HashMap<>();
	}
	
	public Registry<T> preventDuplicateKeyErase()
	{
		erraseDuplicateKey = false;
		return this;
	}
	
	public RegistryKey<? extends Registry<T>> getKey()
	{
		return key;
	}
			
	
	public <R extends T> R add(RegistryKey<? extends T> key2, R registry)
	{
		if((values.containsKey(key2) && erraseDuplicateKey) || !values.containsKey(key2))
		{
			values.put(key2, registry);
			idEntries.put(key2.getValue(), registry);
		}
		return registry;
	}
	
	public abstract T get(Identifier id);	
	public abstract Identifier getId(T value);
	
	public static final Identifier ROOT_KEY = new Identifier("root");
	public static final RegistryKey<Registry<BoardPiece>> PIECE_KEY = Registry.createRegistryKey("piece");
	
	public static final Registry<Registry<?>> ROOT = new SimpleRegistry<Registry<?>>(Registry.createRegistryKey("root"));
	public static final DefaultedRegistry<BoardPiece> PIECE = Registry.create(PIECE_KEY, "void", ()->BoardPieces.VoidPiece);
	
	private static <T> RegistryKey<Registry<T>> createRegistryKey(String id)
	{
		return RegistryKey.ofRegistry(new Identifier(id));
	}
	
	private static <T> DefaultedRegistry<T> create(RegistryKey<? extends Registry<T>> key, String defaultId, DefaultProvider<T> provider)
	{
		return create(key, new DefaultedRegistry<T>(key, new Identifier(defaultId), provider));
	}
	
	private static <T> SimpleRegistry<T> create(RegistryKey<? extends Registry<T>> key)
	{
		return create(key, new SimpleRegistry<T>(key));
	}
	
	public static <T, R extends Registry<T>> R create(RegistryKey<? extends Registry<T>> key, R registry)
	{
		Registry<Registry<?>> root = ROOT;
		return root.add(key, registry);
	}
	
	public static <T> T register(Registry<T> registry, String id, T value)
	{
		return register(registry, RegistryKey.of(registry.getKey().getValue(), new Identifier(id)), value);
	}
	
	public static <T> T register(Registry<T> registry, Identifier id, T value)
	{
		return register(registry, RegistryKey.of(registry.getKey().getValue(), id), value);
	}
	
	public static <T> T register(Registry<T> registry, RegistryKey<T> id, T value)
	{
		return registry.add(id, value);
	}

	public static void setupRegistries() {
		//put code on registry setup here
	}
}
