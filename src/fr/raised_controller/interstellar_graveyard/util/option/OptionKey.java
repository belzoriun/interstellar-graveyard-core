package fr.raised_controller.interstellar_graveyard.util.option;

public enum OptionKey {
	LANG("lang"),
	RENDER_DISTANCE("renderdistance"),
	DEFAULT("");
	
	private String key;
	
	private OptionKey(String key)
	{
		this.key=key;
	}

	public String getKey() {
		return key;
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
