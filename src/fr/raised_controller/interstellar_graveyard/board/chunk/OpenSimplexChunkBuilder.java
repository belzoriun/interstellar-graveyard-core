package fr.raised_controller.interstellar_graveyard.board.chunk;

import java.util.Map;

import fr.raised_controller.interstellar_graveyard.board.biome.Biome;
import fr.raised_controller.interstellar_graveyard.board.element.BoardPiece;
import fr.raised_controller.interstellar_graveyard.util.noise.OpenSimplexNoise;

public class OpenSimplexChunkBuilder extends NoiseChunkBuilder{

	protected OpenSimplexChunkBuilder(long seed) {
		super(Map.of("density", new OpenSimplexNoise(seed), "electromagnetism", new OpenSimplexNoise(seed)));
	}

	@Override
	public Biome evaluate(double data) {
		// TODO Auto-generated method stub
		if(data == 0)
		{
			return null;
		}
		return null;
	}

	@Override
	public double combiner(Map<String, Double> data) {
		double density = data.get("density");
		double electromagnetism = data.get("electromagnetism");
		if(electromagnetism >= 0.8 && density > 0.2)
		{
			return 0;
		}
		return -1;
	}

}
