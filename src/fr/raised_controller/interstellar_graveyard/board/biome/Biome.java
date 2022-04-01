package fr.raised_controller.interstellar_graveyard.board.biome;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.registry.Registry;

public abstract class Biome {
	
	private List<BiomeSetting> settings;
	
	private static float GROUND_LEVEL = 0.3f;
	
	private int getTotalPriority()
	{
		int priority = 0;
		for(BiomeSetting setting : settings)
		{
			priority += setting.getPriority();
		}
		return priority;
	}
	
	private int getTotalPriority(double elevation)
	{
		int priority = 0;
		if(elevation <= GROUND_LEVEL)
		{
			return 0;
		}
		for(BiomeSetting setting : settings)
		{
			if(elevation >= scaleElevation(setting.getElevationMin()) && elevation <= scaleElevation(setting.getElevationMax()))
				priority += setting.getPriority();
		}
		return priority;
	}
	
	private double scaleElevation(double elevation)
	{
		return ((1-GROUND_LEVEL)*(elevation))+GROUND_LEVEL;
	}
	
	/**
	 * Get a piece on this biome from its elevation
	 * @param elevation the elevation parameter, from 0 to 1
	 * @return
	 */
	public BoardPiece getPiece(double elevation)
	{
		if(elevation <= GROUND_LEVEL)
		{
			return Registry.PIECE.getDefaultValue();			
		}
		int totalPriority = this.getTotalPriority(elevation);
		int selector = new Random().nextInt(totalPriority);
		int priority = 0;
		for(BiomeSetting setting : settings)
		{
			if(elevation >= scaleElevation(setting.getElevationMin()) && elevation <= scaleElevation(setting.getElevationMax()))
			{
				priority += setting.getPriority();
				if(priority > selector)
				{
					return setting.getElement();
				}
			}
		}
		return Registry.PIECE.getDefaultValue();
	}
	
	protected Biome(int density, BiomeSetting... settings)
	{
		this.settings = Arrays.asList(settings);
		if(density > 100) density = 100;
		if(density < 0) density = 0;
		if(density != 100)
		{
			int total = getTotalPriority();
			this.settings.add(new BiomeSetting(Registry.PIECE.getDefaultValue(), total*((100-density)/100), 0, 1));
		}
	}
}
