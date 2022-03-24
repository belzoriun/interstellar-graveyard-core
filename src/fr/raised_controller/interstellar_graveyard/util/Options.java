package fr.raised_controller.interstellar_graveyard.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Options {
	public static Options instance = Options.create();
	private Map<OptionKey, Object> options;
	
	private static final String OPTION_PATTERN = ".*:.*";
	
	private Options()
	{
		initOptions();
		Class<Options> clazz = Options.class;
	    InputStream inputStream = clazz.getResourceAsStream("/options.txt");
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
		{
			this.parseOptions(reader);
		} catch (Exception e) {
			System.out.println("ERROR : option file not found : setting default options");
		}
	}
	
	private void initOptions()
	{
		options = new HashMap<>();
		options.put(OptionKey.LANG, "en_us");
	}
	
	private void parseOptions(BufferedReader reader) throws IOException
	{
		String line;
		Pattern pattern = Pattern.compile(OPTION_PATTERN);
		while((line = reader.readLine()) != null)
		{
	        Matcher matcher = pattern.matcher(line);
			if(!matcher.matches())
			{
				System.out.println("Error in option line "+line+" / not valid");
				continue;
			}
			OptionKey name = OptionKey.fromKey(line.split(":")[0]);
			String value = line.split(":")[1];
			if(name.equals(OptionKey.DEFAULT) || !options.containsKey(name))
			{
				System.out.println("Error in option line, "+name+" option was not found");
				continue;
			}
			try
			{
				options.put(name, name.getType().cast(value));
			}catch(Exception e)
			{
				System.out.println("Error in option set, "+name+":"+value+" is wrongly typed, expected "+name.getType());
			}
		}
	}
	
	private static Options create()
	{
		return new Options();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(OptionKey key)
	{
		if(!options.containsKey(key))
		{
			return null;
		}
		try
		{
			return (T)key.getType().cast(options.get(key));
		}catch(Exception e)
		{
			return null;
		}
	}
}
