package fr.raised_controller.interstellar_graveyard.util.option;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Options {
	public static Options instance = Options.create();
	
	private Map<OptionKey, Option<?>> optionRegister;
	
	private static final String OPTION_PATTERN = ".*:.*";
	private InputStream optionStream;
	
	public final Option<String> LANG = registerOption(OptionKey.LANG, String.class, "en_us");
	public final Option<Integer> RENDER_DISTANCE = registerOption(OptionKey.RENDER_DISTANCE, int.class, 5);
	
	private <T> Option<T> registerOption(OptionKey key, Class<T> type, T defaultValue)
	{
		if(optionRegister == null)
		{
			optionRegister = new HashMap<>();
		}
		Option<T> option = new Option<T>(type, defaultValue);
		optionRegister.put(key, option);
		return option;
	}
	
	private Options()
	{
		Class<Options> clazz = Options.class;
	    optionStream = clazz.getResourceAsStream("/options.txt");
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(optionStream)))
		{
			this.parseOptions(reader);
		} catch (Exception e) {
			System.out.println("ERROR : option file not found : setting default options");
		}
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
			if(name.equals(OptionKey.DEFAULT))
			{
				System.out.println("Error in option line, "+name+" option was not found");
				continue;
			}
			try
			{
				if(!setOption(name, value))
				{
					System.out.println("Error while setting option "+name.getKey());
					continue;
				}
			}catch(Exception e)
			{
				System.out.println("Error in option set, "+name+":"+value+" is wrongly typed, expected "+optionRegister.get(name).getType().getName());
			}
		}
	}
	
	public boolean setOption(OptionKey key, Object value)
	{
		if(!optionRegister.containsKey(key))
		{
			return false;
		}
		optionRegister.get(key).set(value);
		return true;
	}
	
	public void save()
	{
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(optionStream)))
		{
			
		} catch (Exception e) {
			System.out.println("ERROR : option file not found : setting default options");
		}
	}
	
	private static Options create()
	{
		return new Options();
	}
}
