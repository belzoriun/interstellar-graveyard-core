package fr.raised_controller.interstellar_graveyard.board.chunk;

import java.util.Map;

import fr.raised_controller.interstellar_graveyard.board.biome.Biome;
import fr.raised_controller.interstellar_graveyard.board.biome.Biomes;
import fr.raised_controller.interstellar_graveyard.util.noise.OpenSimplexNoise;

public class OpenSimplexChunkBuilder extends NoiseChunkBuilder{

	public OpenSimplexChunkBuilder(long seed) {
		super(Map.of("density", new OpenSimplexNoise(seed), "electromagnetism", new OpenSimplexNoise(seed)));
	}

	@Override
	public Biome evaluate(double data) {
		// TODO Auto-generated method stub
		if(data == 0)
		{
			return Biomes.ASTEROID_BELT_BIOME;
		}
		return null;
	}

	@Override
	public double combiner(Map<String, Double> data) {
		double density = data.get("density");
		double electromagnetism = data.get("electromagnetism");
		if(electromagnetism <= 0.5 && density > 0.3)
		{
			return 0;
		}
		return -1;
	}

}
