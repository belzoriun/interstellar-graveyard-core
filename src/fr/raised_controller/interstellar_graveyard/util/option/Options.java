package fr.raised_controller.interstellar_graveyard.util.option;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Options {
	public static Options instance = Options.create();
	public Option<String> LANG_OPTION;
	
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
		LANG_OPTION = new Option<String>(String.class, "en_us");
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
				setOption(name, value);
			}catch(Exception e)
			{
				System.out.println("Error in option set, "+name+":"+value+" is wrongly typed, expected "+name.getType());
			}
		}
	}
	
	private boolean setOption(OptionKey key, Object value)
	{
		switch(key)
		{
		case LANG:
			return LANG_OPTION.set(value);
		default:
			return false;
		}
	}
	
	private static Options create()
	{
		return new Options();
	}
}
