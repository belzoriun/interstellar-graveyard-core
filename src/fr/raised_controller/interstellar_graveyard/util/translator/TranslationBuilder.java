package fr.raised_controller.interstellar_graveyard.util.translator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import fr.raised_controller.interstellar_graveyard.registry.Identifier;
import fr.raised_controller.interstellar_graveyard.registry.Registry;

public class TranslationBuilder {
	
	private BiMap<String, Identifier> translationKeys;
	private List<String> missingTranslations;
	
	private static final String LANG_FILE_BASE_PATH = "/assets/lang/";
	
	public TranslationBuilder()
	{
		translationKeys = HashBiMap.create();
	}
	
	public String getTranslationKey(Identifier id)
	{
		return translationKeys.inverse().get(id);
	}
	
	public TranslationBuilder createRegistryTranslation(Registry<?> registry)
	{
		for(Identifier id : registry.getIds())
		{
			translationKeys.put(createTranslationKey(registry, id), id);
		}
		return this;
	}
	
	private String createTranslationKey(Registry<?> registry, Identifier id)
	{
		return id.getNamespace()+"."+registry.getKey().getValue().getPath()+"."+id.getPath();
	}
	
	public Map<Identifier, String> build(String lang)
	{
		missingTranslations = new ArrayList<>();
		Map<Identifier, String> translations = new HashMap<>();
		Class<TranslationBuilder> clazz = TranslationBuilder.class;
	    InputStream inputStream = clazz.getResourceAsStream(LANG_FILE_BASE_PATH+lang+".json");
	    String json = "";
	    try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
		{
	    	String line;
			while((line = reader.readLine()) != null)
			{
				json += line;
			}
		} catch (Exception e) {
			System.out.println("ERROR : translation file "+LANG_FILE_BASE_PATH+lang+".json not found");
			json = "{}";
		}
	    JSONObject object = new JSONObject(json);
	    for(Map.Entry<String, Identifier> entry : translationKeys.entrySet())
	    {
	    	if(!object.has(entry.getKey()))
	    	{
	    		missingTranslations.add(entry.getKey());
	    		continue;
	    	}
	    	translations.put(entry.getValue(), object.get(entry.getKey()).toString());
	    }
	    return translations;
	}
	
	public List<String> getMissingTranslations()
	{
		return missingTranslations;
	}
}
