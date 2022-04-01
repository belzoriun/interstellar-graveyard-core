package fr.raised_controller.interstellar_graveyard.board.biome;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPieces;

public class AsteroidBeltBiome extends Biome{

	protected AsteroidBeltBiome() {
		super(100, 
				new BiomeSetting(BoardPieces.TINY_ASTEROID, 10, 0, 0.4),
				new BiomeSetting(BoardPieces.MEDIUM_ASTEROID, 10, 0.4, 0.7),
				new BiomeSetting(BoardPieces.LARGE_ASTEROID, 10, 0.7, 1)
			);
		// TODO Auto-generated constructor stub
	}

}
