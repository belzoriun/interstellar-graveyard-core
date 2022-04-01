package fr.raised_controller.interstellar_graveyard.board.chunk;

import java.util.HashMap;
import java.util.Map;

import fr.raised_controller.interstellar_graveyard.board.biome.Biome;
import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.registry.Registry;
import fr.raised_controller.interstellar_graveyard.util.Position;
import fr.raised_controller.interstellar_graveyard.util.noise.Noise;

public abstract class NoiseChunkBuilder implements ChunkBuilder{
	private Map<String, Noise> noises;
	
	private static final double GROUND_LEVEL = -0.6;
	
	protected NoiseChunkBuilder(Map<String, Noise> noises)
	{
		this.noises = noises;
	}

	public BoardPiece create(Position pos)
	{
		Map<String, Double> values = new HashMap<>();
		for(Map.Entry<String, Noise> entry : noises.entrySet())
		{
			values.put(entry.getKey(), entry.getValue().evaluate(pos.getX(), pos.getY()));
		}
		double value = combiner(values);
		if(value > GROUND_LEVEL)
		{
			Biome biome = evaluate(value);
			if(biome != null)
				return biome.getPiece(scale(value));
		}
		return Registry.PIECE.getDefaultValue();
	}
	
	private double scale(double value)
	{
		return (value-1)/-2;
	}
	
	public abstract Biome evaluate(double data);
	
	public abstract double combiner(Map<String, Double> data);
	
	
}
