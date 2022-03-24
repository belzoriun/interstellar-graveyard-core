package fr.raised_controller.interstellar_graveyard.util;

import java.util.List;
import java.util.Map;

import fr.raised_controller.interstellar_graveyard.registry.Identifier;
import fr.raised_controller.interstellar_graveyard.registry.Registry;
import fr.raised_controller.interstellar_graveyard.util.option.OptionKey;
import fr.raised_controller.interstellar_graveyard.util.option.Options;
import fr.raised_controller.interstellar_graveyard.util.translator.TranslationBuilder;

public class Language {
	
	public static Language instance = Language.create(); 
	private List<String> missing;
	private TranslationBuilder builder;
	
	private Map<Identifier, String> translations;
	
	private Language(TranslationBuilder builder, String lang)
	{
		this.translations = builder.build(lang);
		this.missing = builder.getMissingTranslations();
		this.builder=builder;
	}
	
	public static Language create()
	{
		String lang = Options.instance.LANG_OPTION.get();
		TranslationBuilder builder = new TranslationBuilder();
		builder.createRegistryTranslation(Registry.PIECE);
		return new Language(builder, lang);
	}
	
	public String getTranslation(Identifier id)
	{
		if(!translations.containsKey(id))
		{
			String key = builder.getTranslationKey(id);
			if(key != null)
			{
				return key;
			}
			return "placeholder";
		}
		return translations.get(id);
	}
	
	public List<String> getMissing()
	{
		return missing;
	}
}
