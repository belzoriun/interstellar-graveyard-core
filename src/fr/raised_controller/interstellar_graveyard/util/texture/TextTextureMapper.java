package fr.raised_controller.interstellar_graveyard.util.texture;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONObject;

import fr.raised_controller.interstellar_graveyard.exception.TextureNotFoundException;

public class TextTextureMapper extends TextureMapper<String>{

	private TextTextureMapper() {
		super("M");
		// TODO Auto-generated constructor stub
	}
	
	public static final TextTextureMapper instance = new TextTextureMapper();

	@Override
	protected String loadTexture(InputStream stream) throws TextureNotFoundException {
		String json = "";
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(stream)))
		{
	    	String line;
			while((line = reader.readLine()) != null)
			{
				json += line;
			}
		} catch (Exception e) {
			throw new TextureNotFoundException(e);
		}
	    JSONObject object = new JSONObject(json);
	    try
	    {
	    	return object.getJSONObject("text").getString("texture");
	    }catch(Exception e)
	    {
	    	System.out.println("ERROR : malformed texture file : "+e.getMessage()+". Using default texture instead.");
	    	return defaultTexture;
	    }
	}

}
