package fr.raised_controller.interstellar_graveyard.util.texture;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.raised_controller.interstellar_graveyard.exception.TextureNotFoundException;
import fr.raised_controller.interstellar_graveyard.registry.Identifier;
import fr.raised_controller.interstellar_graveyard.registry.Registry;

public abstract class TextureMapper<T> {
	
	private Map<Identifier, T> textures;
	protected T defaultTexture;
	
	private static final List<Registry<?>> TEXTURED_REGISTRIES = List.of(Registry.PIECE);
	
	public void init()
	{
		for(Registry<?> registry : TEXTURED_REGISTRIES)
		{
			for(Identifier id : registry.getIds())
			{
				String texturePath = getTexturePath(registry, id);
				try {
					textures.put(id, loadTexture(getTextureFile(texturePath)));
				} catch (TextureNotFoundException e) {
					System.out.println("ERROR : texture not found for id "+id+" ("+texturePath+"). Using default texture instead.");
					textures.put(id, defaultTexture);
				}
			}
		}
	}
	
	public T getTexture(Identifier id)
	{
		if(!textures.containsKey(id))
		{
			return defaultTexture;
		}
		return textures.get(id);
	}
	
	protected abstract T loadTexture(InputStream stream) throws TextureNotFoundException;
	
	private String getTexturePath(Registry<?> r, Identifier id)
	{
		return "/assets/"+id.getNamespace()+"/models/"+r.getKey().getValue().getPath()+"/"+id.getPath()+".json";
	}
	
	private InputStream getTextureFile(String path)
	{
		return TextureMapper.class.getResourceAsStream(path);
	}
	
	protected TextureMapper(T defaultTexture)
	{
		textures = new HashMap<>();
		this.defaultTexture = defaultTexture;
	}
}
