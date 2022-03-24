package fr.raised_controller.interstellar_graveyard.game;

import fr.raised_controller.interstellar_graveyard.registry.Identifier;
import fr.raised_controller.interstellar_graveyard.registry.Registry;
import fr.raised_controller.interstellar_graveyard.util.Language;
import fr.raised_controller.interstellar_graveyard.util.texture.TextTextureMapper;

public class BootStrap {
	public static void init()
	{
		System.out.println("init");
		if(Registry.ROOT.getIds().isEmpty())
		{
			System.out.println("Enable to load registries");
		}
		for(Registry<?> registry : Registry.ROOT)
		{
			for(Identifier id : registry.getIds())
			{
				System.out.println("Registered "+id);
			}
		}
		for(String missingTranslationKey : Language.instance.getMissing())
		{
			System.out.println("WARN : Missing translation : "+missingTranslationKey);
		}
		TextTextureMapper.instance.init();
	}
}
