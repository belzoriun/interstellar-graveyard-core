package fr.raised_controller.interstellar_graveyard.util;

public enum OptionKey {
	LANG("lang", String.class),
	DEFAULT("", String.class);
	
	private String key;
	private Class<?> type;
	
	private OptionKey(String key, Class<?> type)
	{
		this.key=key;
		this.type=type;
	}

	public String getKey() {
		return key;
	}

	public Class<?> getType() {
		return type;
	}
	
	public static OptionKey fromKey(String key)
	{
		for(OptionKey value : OptionKey.values())
		{
			if(value.getKey().equals(key))
			{
				return value;
			}
		}
		return null;
	}
}
