package fr.raised_controller.interstellar_graveyard.board.biome;

import java.util.List;

import fr.raised_controller.interstellar_graveyard.board.element.BoardPieces;

public class AsteroidBeltBiome extends Biome{

	protected AsteroidBeltBiome() {
		super(100, 
				new BiomeSetting(BoardPieces.TINY_ASTEROID, 10, 0, 0.15),
				new BiomeSetting(BoardPieces.MEDIUM_ASTEROID, 10, 0.15, 0.6),
				new BiomeSetting(BoardPieces.LARGE_ASTEROID, 10, 0.6, 1)
			);
		// TODO Auto-generated constructor stub
	}

}
